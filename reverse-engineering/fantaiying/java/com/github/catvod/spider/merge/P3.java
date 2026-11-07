/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.github.catvod.spider.merge;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import com.github.catvod.spider.merge.OI;
import com.github.catvod.spider.merge.oX;
import com.github.catvod.spider.merge.oi_0;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class P3 {
    private static final boolean SN;
    private static final Set<File> yq;

    static {
        Object object;
        boolean bl;
        String string;
        block6: {
            boolean bl2;
            yq = new HashSet<File>();
            string = System.getProperty("java.vm.version");
            bl = bl2 = false;
            if (string != null) {
                object = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(string);
                bl = bl2;
                if (((Matcher)object).matches()) {
                    try {
                        int n2 = Integer.parseInt(((Matcher)object).group(1));
                        int n3 = Integer.parseInt(((Matcher)object).group(2));
                        if (n2 <= 2) {
                            bl = bl2;
                            if (n2 != 2) break block6;
                            bl = bl2;
                            if (n3 < 1) break block6;
                        }
                        bl = true;
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl = bl2;
                    }
                }
            }
        }
        object = oX.yq("VM with version ", string);
        string = bl ? " has multidex support" : " does not have multidex support";
        ((StringBuilder)object).append(string);
        Log.i((String)"MultiDex", (String)((StringBuilder)object).toString());
        SN = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void N(Context object, File file, File object2) {
        Set<File> set = yq;
        synchronized (set) {
            block22: {
                ClassLoader classLoader;
                Comparable<StringBuilder> comparable;
                block21: {
                    if (set.contains(file)) {
                        return;
                    }
                    set.add(file);
                    int n2 = Build.VERSION.SDK_INT;
                    if (n2 > 20) {
                        comparable = new Comparable<StringBuilder>();
                        ((StringBuilder)comparable).append("MultiDex is not guaranteed to work in SDK version ");
                        ((StringBuilder)comparable).append(n2);
                        ((StringBuilder)comparable).append(": SDK version higher than ");
                        ((StringBuilder)comparable).append(20);
                        ((StringBuilder)comparable).append(" should be backed by ");
                        ((StringBuilder)comparable).append("runtime with built-in multidex capabilty but it's not the ");
                        ((StringBuilder)comparable).append("case here: java.vm.version=\"");
                        ((StringBuilder)comparable).append(System.getProperty("java.vm.version"));
                        ((StringBuilder)comparable).append("\"");
                        Log.w((String)"MultiDex", (String)((StringBuilder)comparable).toString());
                    }
                    try {
                        classLoader = object.getClassLoader();
                        if (classLoader != null) break block21;
                    }
                    catch (RuntimeException runtimeException) {
                        Log.w((String)"MultiDex", (String)"Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", (Throwable)runtimeException);
                        return;
                    }
                    Log.e((String)"MultiDex", (String)"Context class loader is null. Must be running in test mode. Skip patching.");
                    return;
                }
                try {
                    P3.SN(object);
                }
                catch (Throwable throwable) {
                    Log.w((String)"MultiDex", (String)"Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", (Throwable)throwable);
                }
                comparable = new Comparable<StringBuilder>((File)object2, "code_cache");
                try {
                    P3.t0(comparable);
                    object2 = comparable;
                }
                catch (IOException iOException) {
                    object2 = new File(object.getFilesDir(), "code_cache");
                    P3.t0((File)object2);
                }
                comparable = new Comparable<StringBuilder>((File)object2, "secondary-dexes");
                P3.t0(comparable);
                object2 = new OI(file, (File)comparable);
                file = null;
                List list = ((OI)object2).zH((Context)object, false);
                try {
                    P3.i(classLoader, comparable, list);
                }
                catch (IOException iOException) {
                    Log.w((String)"MultiDex", (String)"Failed to install extracted secondary dex files, retrying with forced extraction", (Throwable)iOException);
                    P3.i(classLoader, comparable, ((OI)object2).zH((Context)object, true));
                }
                object = file;
                if (object != null) break block22;
                return;
            }
            throw object;
            finally {
                ((OI)object2).close();
            }
        }
    }

    private static void SN(Context object) {
        if (((File)(object = new File(object.getFilesDir(), "secondary-dexes"))).isDirectory()) {
            Object object2 = oi_0.yq("Clearing old secondary dex dir (");
            ((StringBuilder)object2).append(((File)object).getPath());
            ((StringBuilder)object2).append(").");
            Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
            object2 = ((File)object).listFiles();
            if (object2 == null) {
                object2 = oi_0.yq("Failed to list secondary dex dir content (");
                ((StringBuilder)object2).append(((File)object).getPath());
                ((StringBuilder)object2).append(").");
                Log.w((String)"MultiDex", (String)((StringBuilder)object2).toString());
                return;
            }
            for (Object object3 : object2) {
                StringBuilder stringBuilder = oi_0.yq("Trying to delete old file ");
                stringBuilder.append(((File)object3).getPath());
                stringBuilder.append(" of size ");
                stringBuilder.append(((File)object3).length());
                Log.i((String)"MultiDex", (String)stringBuilder.toString());
                if (!((File)object3).delete()) {
                    stringBuilder = oi_0.yq("Failed to delete old file ");
                    stringBuilder.append(((File)object3).getPath());
                    Log.w((String)"MultiDex", (String)stringBuilder.toString());
                    continue;
                }
                stringBuilder = oi_0.yq("Deleted old file ");
                stringBuilder.append(((File)object3).getPath());
                Log.i((String)"MultiDex", (String)stringBuilder.toString());
            }
            if (!((File)object).delete()) {
                object2 = oi_0.yq("Failed to delete secondary dex dir ");
                ((StringBuilder)object2).append(((File)object).getPath());
                Log.w((String)"MultiDex", (String)((StringBuilder)object2).toString());
            } else {
                object2 = oi_0.yq("Deleted old secondary dex dir ");
                ((StringBuilder)object2).append(((File)object).getPath());
                Log.i((String)"MultiDex", (String)((StringBuilder)object2).toString());
            }
        }
    }

    private static void i(ClassLoader object, File object2, List<? extends File> serializableArray) {
        block9: {
            if (!serializableArray.isEmpty()) {
                Object object3 = P3.tF(object, "pathList").get(object);
                ArrayList arrayList = new ArrayList();
                ArrayList<? extends File> arrayList2 = new ArrayList<File>((Collection<? extends File>)serializableArray);
                serializableArray = new Class[]{ArrayList.class, File.class, ArrayList.class};
                for (object = object3.getClass(); object != null; object = ((Class)object).getSuperclass()) {
                    Method method;
                    block8: {
                        try {
                            method = ((Class)object).getDeclaredMethod("makeDexElements", (Class<?>[])serializableArray);
                            if (method.isAccessible()) break block8;
                            ((AccessibleObject)method).setAccessible(true);
                        }
                        catch (NoSuchMethodException noSuchMethodException) {
                            continue;
                        }
                    }
                    P3.yq(object3, "dexElements", (Object[])method.invoke(object3, arrayList2, object2, arrayList));
                    if (arrayList.size() > 0) {
                        object = arrayList.iterator();
                        while (object.hasNext()) {
                            Log.w((String)"MultiDex", (String)"Exception in makeDexElement", (Throwable)((IOException)object.next()));
                        }
                        object2 = P3.tF(object3, "dexElementsSuppressedExceptions");
                        serializableArray = (IOException[])((Field)object2).get(object3);
                        if (serializableArray == null) {
                            object = arrayList.toArray(new IOException[arrayList.size()]);
                        } else {
                            object = new IOException[arrayList.size() + serializableArray.length];
                            arrayList.toArray((T[])object);
                            System.arraycopy(serializableArray, 0, object, arrayList.size(), serializableArray.length);
                        }
                        ((Field)object2).set(object3, object);
                        object = new IOException("I/O exception during makeDexElement");
                        ((Throwable)object).initCause((Throwable)arrayList.get(0));
                        throw object;
                    }
                    break block9;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Method ");
                ((StringBuilder)object).append("makeDexElements");
                ((StringBuilder)object).append(" with parameters ");
                ((StringBuilder)object).append(Arrays.asList(serializableArray));
                ((StringBuilder)object).append(" not found in ");
                ((StringBuilder)object).append(object3.getClass());
                throw new NoSuchMethodException(((StringBuilder)object).toString());
            }
        }
    }

    private static void t0(File file) {
        file.mkdir();
        if (!file.isDirectory()) {
            CharSequence charSequence;
            File file2 = file.getParentFile();
            if (file2 == null) {
                charSequence = oi_0.yq("Failed to create dir ");
                ((StringBuilder)charSequence).append(file.getPath());
                ((StringBuilder)charSequence).append(". Parent file is null.");
                charSequence = ((StringBuilder)charSequence).toString();
            } else {
                charSequence = oi_0.yq("Failed to create dir ");
                ((StringBuilder)charSequence).append(file.getPath());
                ((StringBuilder)charSequence).append(". parent file is a dir ");
                ((StringBuilder)charSequence).append(file2.isDirectory());
                ((StringBuilder)charSequence).append(", a file ");
                ((StringBuilder)charSequence).append(file2.isFile());
                ((StringBuilder)charSequence).append(", exists ");
                ((StringBuilder)charSequence).append(file2.exists());
                ((StringBuilder)charSequence).append(", readable ");
                ((StringBuilder)charSequence).append(file2.canRead());
                ((StringBuilder)charSequence).append(", writable ");
                ((StringBuilder)charSequence).append(file2.canWrite());
                charSequence = ((StringBuilder)charSequence).toString();
            }
            Log.e((String)"MultiDex", (String)charSequence);
            charSequence = oi_0.yq("Failed to create directory ");
            ((StringBuilder)charSequence).append(file.getPath());
            throw new IOException(((StringBuilder)charSequence).toString());
        }
    }

    private static Field tF(Object object, String string) {
        Serializable serializable;
        for (serializable = object.getClass(); serializable != null; serializable = ((Class)serializable).getSuperclass()) {
            try {
                Field field = ((Class)serializable).getDeclaredField(string);
                if (!field.isAccessible()) {
                    ((AccessibleObject)field).setAccessible(true);
                }
                return field;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                continue;
            }
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Field ");
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append(" not found in ");
        ((StringBuilder)serializable).append(object.getClass());
        object = new NoSuchFieldException(((StringBuilder)serializable).toString());
        throw object;
    }

    static void yq(Object object, String objectArray, Object[] objectArray2) {
        Field field = P3.tF(object, (String)objectArray);
        objectArray = (Object[])field.get(object);
        Object[] objectArray3 = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), objectArray.length + objectArray2.length);
        System.arraycopy(objectArray, 0, objectArray3, 0, objectArray.length);
        System.arraycopy(objectArray2, 0, objectArray3, objectArray.length, objectArray2.length);
        field.set(object, objectArray3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zH(Context object) {
        Exception exception2;
        block7: {
            Log.i((String)"MultiDex", (String)"Installing application");
            if (SN) {
                object = "VM has multidex support, MultiDex support library is disabled.";
            } else {
                ApplicationInfo applicationInfo;
                try {
                    try {
                        applicationInfo = object.getApplicationInfo();
                    }
                    catch (RuntimeException runtimeException) {
                        Log.w((String)"MultiDex", (String)"Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", (Throwable)runtimeException);
                        applicationInfo = null;
                    }
                }
                catch (Exception exception2) {
                    break block7;
                }
                if (applicationInfo == null) {
                    Log.i((String)"MultiDex", (String)"No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                }
                File file = new File(applicationInfo.sourceDir);
                File file2 = new File(applicationInfo.dataDir);
                P3.N((Context)object, file, file2);
                object = "install done";
            }
            Log.i((String)"MultiDex", (String)object);
            return;
        }
        Log.e((String)"MultiDex", (String)"MultiDex installation failure", (Throwable)exception2);
        object = oi_0.yq("MultiDex installation failed (");
        ((StringBuilder)object).append(exception2.getMessage());
        ((StringBuilder)object).append(").");
        throw new RuntimeException(((StringBuilder)object).toString());
    }
}

