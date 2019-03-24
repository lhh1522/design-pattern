package singleton.seriable;

import java.io.Serializable;

public class SeriableSingleton implements Serializable {
    private static final SeriableSingleton singleton = new SeriableSingleton();

    private SeriableSingleton() {}

    public static SeriableSingleton getInstance() {
        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }
}
