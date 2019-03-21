package simplefactory;

public class PhoneFactory {
    public IPhone createPhone(Class<? extends IPhone> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
