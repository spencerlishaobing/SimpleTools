package android.content;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.json.*;

/** Files and preferences are scoped to this source's private cache directory. */
public class Context {
    public static final int MODE_PRIVATE=0;
    public static final String CONNECTIVITY_SERVICE="connectivity";
    public static final String WIFI_SERVICE="wifi";
    public static final String POWER_SERVICE="power";
    public static final String ACTIVITY_SERVICE="activity";
    public static final String WINDOW_SERVICE="window";
    public static final String CLIPBOARD_SERVICE="clipboard";
    public static final String TELEPHONY_SERVICE="phone";
    public static final String NOTIFICATION_SERVICE="notification";
    public static final String INPUT_METHOD_SERVICE="input_method";
    public static final String LAYOUT_INFLATER_SERVICE="layout_inflater";
    public static final String CONNECTIVITY_ACTION="android.net.conn.CONNECTIVITY_CHANGE";
    private final File root;
    private final Map<String,SharedPreferences> prefs=new HashMap<>();
    public Context(){this(new File("context"));}
    public Context(File root){this.root=root;root.mkdirs();}
    private File folder(String name){File f=new File(root,name);f.mkdirs();return f;}
    public Context getApplicationContext(){return this;}
    public File getCacheDir(){return folder("cache");}public File getCodeCacheDir(){return folder("code");}
    public File getFilesDir(){return folder("files");}public File getExternalFilesDir(String type){return folder("external/"+(type==null?"":safe(type)));}
    public File getExternalCacheDir(){return folder("external-cache");}public File getDir(String name,int mode){return folder("app_"+safe(name));}
    /** TVBox 生态的 spider 常用包名做白名单校验，这里保持与主流客户端的既有包名一致。 */
    public String getPackageName(){return "com.github.tvbox.osc";}public android.content.pm.ApplicationInfo getApplicationInfo(){return new android.content.pm.ApplicationInfo();}
    public android.content.pm.PackageManager getPackageManager(){return new android.content.pm.PackageManager();}
    public int checkCallingOrSelfPermission(String permission){return 0;}
    public int checkCallingPermission(String permission){return 0;}
    public int checkSelfPermission(String permission){return 0;}
    public int checkPermission(String permission,int pid,int uid){return 0;}
    public void enforceCallingOrSelfPermission(String permission,String message){}
    public ClassLoader getClassLoader(){return getClass().getClassLoader();}
    public Object getSystemService(String name){if(CONNECTIVITY_SERVICE.equals(name))return new android.net.ConnectivityManager();throw new UnsupportedOperationException("Unsupported Android system service: "+name);}
    public File getFileStreamPath(String name){return new File(getFilesDir(),safe(name));}
    public FileInputStream openFileInput(String name)throws FileNotFoundException{return new FileInputStream(getFileStreamPath(name));}
    public FileOutputStream openFileOutput(String name,int mode)throws FileNotFoundException{return new FileOutputStream(getFileStreamPath(name),(mode&32768)!=0);}
    public boolean deleteFile(String name){return getFileStreamPath(name).delete();}
    public synchronized SharedPreferences getSharedPreferences(String name,int mode){return prefs.computeIfAbsent(name,k->new Preferences(new File(folder("preferences"),safe(k)+".json")));}
    private static String safe(String name){if(name.contains("/")||name.contains("\\")||name.equals(".."))throw new IllegalArgumentException("Invalid local name");return name;}
    private static final class Preferences implements SharedPreferences {
        final File file;final Map<String,Object> values=new HashMap<>();final Set<OnSharedPreferenceChangeListener> listeners=new HashSet<>();
        Preferences(File file){this.file=file;try{JSONObject json=new JSONObject(new String(Files.readAllBytes(file.toPath()),"UTF-8"));for(String key:json.keySet()){Object v=json.get(key);if(v instanceof JSONArray){Set<String> set=new HashSet<>();for(Object o:(JSONArray)v)set.add(o.toString());v=set;}values.put(key,v);}}catch(IOException ignored){}}
        public synchronized Map<String,?> getAll(){return new HashMap<>(values);}public synchronized boolean contains(String k){return values.containsKey(k);}
        public synchronized String getString(String k,String f){Object v=values.get(k);return v==null?f:(String)v;}
        public synchronized Set<String> getStringSet(String k,Set<String> f){Object v=values.get(k);return v==null?f:new HashSet<>((Set<String>)v);}
        public synchronized int getInt(String k,int f){Object v=values.get(k);return v==null?f:((Number)v).intValue();}public synchronized long getLong(String k,long f){Object v=values.get(k);return v==null?f:((Number)v).longValue();}
        public synchronized float getFloat(String k,float f){Object v=values.get(k);return v==null?f:((Number)v).floatValue();}public synchronized boolean getBoolean(String k,boolean f){Object v=values.get(k);return v==null?f:(Boolean)v;}
        public synchronized void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener l){listeners.add(l);}public synchronized void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener l){listeners.remove(l);}
        public Editor edit(){return new Editor(){final Map<String,Object> pending=new HashMap<>();boolean clear=false;
            public Editor putString(String k,String v){pending.put(k,v);return this;}public Editor putStringSet(String k,Set<String> v){pending.put(k,v==null?null:new HashSet<>(v));return this;}
            public Editor putInt(String k,int v){pending.put(k,v);return this;}public Editor putLong(String k,long v){pending.put(k,v);return this;}public Editor putFloat(String k,float v){pending.put(k,v);return this;}public Editor putBoolean(String k,boolean v){pending.put(k,v);return this;}
            public Editor remove(String k){pending.put(k,null);return this;}public Editor clear(){clear=true;return this;}
            public boolean commit(){synchronized(Preferences.this){if(clear)values.clear();for(Map.Entry<String,Object> e:pending.entrySet())if(e.getValue()==null)values.remove(e.getKey());else values.put(e.getKey(),e.getValue());try{Path temp=file.toPath().resolveSibling(file.getName()+".tmp");Files.write(temp,new JSONObject(values).toString().getBytes("UTF-8"));Files.move(temp,file.toPath(),StandardCopyOption.REPLACE_EXISTING);for(String k:pending.keySet())for(OnSharedPreferenceChangeListener l:listeners)l.onSharedPreferenceChanged(Preferences.this,k);return true;}catch(IOException e){return false;}}}public void apply(){commit();}
        };}
    }
}
