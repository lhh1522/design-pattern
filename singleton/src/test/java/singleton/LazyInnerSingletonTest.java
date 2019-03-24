package singleton;

import singleton.lazy.LazyInnerSingleton;

import java.lang.reflect.Constructor;

public class LazyInnerSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyInnerSingleton.class;
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);

            Object obj1 = constructor.newInstance();
            System.out.println(obj1);

            Object obj2 = LazyInnerSingleton.getInstance();
            System.out.println(obj2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
