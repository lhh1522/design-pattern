package abstractfactory;

public class BlackHuaweiFactory implements IPhoneFactory {
    public IType setType() {
        return new Huawei();
    }

    public IColor setColor() {
        return new Black();
    }
}
