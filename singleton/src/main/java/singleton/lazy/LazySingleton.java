package singleton.lazy;

public class LazySingleton {
    private volatile static LazySingleton lazySingleton;

    private LazySingleton() {}

    // 加双重判定，保证线程安全的同时优化性能
    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null)
                    lazySingleton = new LazySingleton();
            }
        }
        return lazySingleton;
    }
}
