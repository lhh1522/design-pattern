package abstractfactory;

public class RedAppleFactory implements IPhoneFactory {
    public IType setType() {
        return new Apple();
    }

    public IColor setColor() {
        return new Red();
    }
}
