package simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();
        try {
            IPhone apple = phoneFactory.createPhone(Apple.class);
            apple.call();

            IPhone huawei = phoneFactory.createPhone(Huawei.class);
            huawei.call();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
