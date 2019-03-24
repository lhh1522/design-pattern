package singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {
    private ContainerSingleton() {}

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();     // 保存实例的容器

    public static Object getInstance(String className) {
        synchronized (ioc) {  //牺牲性能，保证线程安全
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }

}
