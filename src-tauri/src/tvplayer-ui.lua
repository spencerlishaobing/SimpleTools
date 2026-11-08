local mp = require 'mp'
local assdraw = require 'mp.assdraw'
local overlay = mp.create_osd_overlay('ass-events')
local feedback = -10
local function now() return mp.get_time() end
local function render()
    local w,h=mp.get_osd_size()
    if w<=0 or h<=0 then return end
    w=w*720/h;h=720
    local a=assdraw.ass_new()
    local function rect(x,y,r,b,alpha)
        a:new_event();a:append(string.format('{\\an7\\pos(0,0)\\bord0\\shad0\\1c&H101010&\\alpha&H%02X&}',alpha))
        a:draw_start();a:rect_cw(x,y,r,b);a:draw_stop()
    end
    local function icon(x,y,paused,alpha)
        a:new_event();a:append(string.format('{\\an7\\pos(0,0)\\bord0\\shad0\\1c&HFFFFFF&\\alpha&H%02X&}',alpha or 0));a:draw_start()
        if paused then a:move_to(x-7,y-12);a:line_to(x+12,y);a:line_to(x-7,y+12);a:line_to(x-7,y-12)
        else a:rect_cw(x-9,y-12,x-3,y+12);a:rect_cw(x+3,y-12,x+9,y+12) end
        a:draw_stop()
    end
    local age=now()-feedback
    if age<0.7 then
        local alpha=math.floor(255*math.max(0,(age-0.15)/0.55))
        rect(w/2-34,h/2-34,w/2+34,h/2+34,math.min(255,100+alpha*0.6))
        icon(w/2,h/2,mp.get_property_native('pause',false),alpha)
    end
    overlay.res_x=w;overlay.res_y=h;overlay.data=a.text;overlay:update()
end
mp.observe_property('pause','bool',function(_,paused) feedback=now();render();mp.commandv('script-message',paused and 'tvbox-paused' or 'tvbox-playing') end)
mp.register_script_message('simpletools-pointer',function() mp.commandv('cycle','pause') end)
mp.add_forced_key_binding('MBTN_LEFT','simpletools-click',function() mp.commandv('cycle','pause') end)
mp.add_periodic_timer(0.05,render)

local last_move=-10
mp.add_forced_key_binding('MOUSE_MOVE','simpletools-move',function() if now()-last_move>0.15 then last_move=now();mp.commandv('script-message','tvbox-controls') end end)
