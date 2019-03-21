package factorymethod;

public class HuaweiFactory implements IPhoneFactory {
    public IPhone createPhone() {
        return new Huawei();
    }
}
