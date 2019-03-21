package abstractfactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        Phone blackHuawei = new Phone();
        IPhoneFactory blackHuaweiFactory = new BlackHuaweiFactory();
        blackHuawei.setType(blackHuaweiFactory.setType());
        blackHuawei.setColor(blackHuaweiFactory.setColor());
        blackHuawei.getPhone();

        Phone redApple = new Phone();
        IPhoneFactory redAppleFactory = new RedAppleFactory();
        redApple.setType(redAppleFactory.setType());
        redApple.setColor(redAppleFactory.setColor());
        redApple.getPhone();
    }
}
