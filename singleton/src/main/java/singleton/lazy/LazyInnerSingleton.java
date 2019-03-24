package singleton.lazy;

// 使用该方法，在保证了线程安全的同时，保证了性能
public class LazyInnerSingleton {

    private LazyInnerSingleton() {
        // 保证不会通过反射给方式创建实例
        if (LazySingletonHolder.lazyInnerSingleton != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    // final保证这个方法不会被重载、重写
    public static final LazyInnerSingleton getInstance() {
        return LazySingletonHolder.lazyInnerSingleton;
    }

    private static class LazySingletonHolder {
        private static final LazyInnerSingleton lazyInnerSingleton = new LazyInnerSingleton();
    }

}
