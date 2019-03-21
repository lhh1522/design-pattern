package factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        IPhoneFactory appleFactory = new AppleFactory();
        IPhone apple = appleFactory.createPhone();
        apple.call();

        IPhoneFactory huaweiFactory = new HuaweiFactory();
        IPhone huawei = huaweiFactory.createPhone();
        huawei.call();
    }
}
