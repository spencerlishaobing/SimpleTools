"""Exercise the actual bundled DLL without requiring a desktop or a network source."""
import ctypes as C
import pathlib
import time

path = pathlib.Path(__file__).resolve().parents[1] / 'src-tauri/resources/mpv/libmpv-2.dll'
lib = C.CDLL(str(path))
lib.mpv_create.restype = C.c_void_p
lib.mpv_set_option_string.argtypes = [C.c_void_p,C.c_char_p,C.c_char_p]
lib.mpv_initialize.argtypes = [C.c_void_p]
lib.mpv_command.argtypes = [C.c_void_p,C.POINTER(C.c_char_p)]
lib.mpv_get_property_string.argtypes = [C.c_void_p,C.c_char_p]
lib.mpv_get_property_string.restype = C.c_void_p
lib.mpv_free.argtypes = [C.c_void_p]
lib.mpv_terminate_destroy.argtypes = [C.c_void_p]
class Event(C.Structure):
    _fields_ = [('id',C.c_int),('error',C.c_int),('userdata',C.c_uint64),('data',C.c_void_p)]
lib.mpv_wait_event.argtypes = [C.c_void_p,C.c_double]
lib.mpv_wait_event.restype = C.POINTER(Event)
handle = lib.mpv_create()
assert handle
def option(k,v):
    result = lib.mpv_set_option_string(handle,k.encode(),v.encode())
    assert result >= 0, (k,result)
def command(*args):
    values = (C.c_char_p * (len(args)+1))(*[s.encode() for s in args],None)
    result = lib.mpv_command(handle,values)
    assert result >= 0, (args,result)
def prop(key):
    pointer = lib.mpv_get_property_string(handle,key.encode())
    if not pointer: return ''
    value = C.string_at(pointer).decode(); lib.mpv_free(pointer); return value
try:
    for k,v in [('vo','null'),('ao','null'),('hwdec','auto-safe'),('osc','yes'),('input-default-bindings','yes'),('input-vo-keyboard','yes'),('idle','yes'),('config','no'),('cache','yes'),('demuxer-max-bytes','256MiB'),('demuxer-max-back-bytes','64MiB'),('cache-pause','yes'),('cache-pause-wait','3'),('network-timeout','20')]: option(k,v)
    assert lib.mpv_initialize(handle) >= 0
    option('user-agent','SimpleTools-TVBOX'); option('referrer',''); option('force-media-title','测试')
    for k,v in [('start','0'),('speed','1'),('volume','80'),('pause','no'),('http-header-fields','%15%X-Test: one,two')]: option(k,v)
    for width,height in [(3840,2160),(7680,4320)]:
        command('loadfile',f'av://lavfi:testsrc2=size={width}x{height}:rate=24','replace')
        deadline = time.monotonic()+20
        loaded = False
        while time.monotonic() < deadline:
            event = lib.mpv_wait_event(handle,0.2).contents
            if event.id == 8:
                loaded = True; break
        assert loaded, 'Timed out waiting for video'
        assert prop('width') == str(width) and prop('height') == str(height), (prop('width'),prop('height'))
        command('cycle','pause'); command('seek','10','relative'); command('stop')
        print(f'PASS: bundled libmpv loaded synthetic {width}x{height} source and accepted playback controls (null output, not GPU performance)')
    print('Version:',prop('mpv-version'))
finally:
    lib.mpv_terminate_destroy(handle)
