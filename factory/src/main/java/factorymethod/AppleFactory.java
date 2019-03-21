package factorymethod;

public class AppleFactory implements IPhoneFactory {
    public IPhone createPhone() {
        return new Apple();
    }
}
