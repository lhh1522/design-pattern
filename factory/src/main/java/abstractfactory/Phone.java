package abstractfactory;

public class Phone {
    private IColor color;
    private IType type;

    public IColor getColor() {
        return color;
    }

    public void setColor(IColor color) {
        this.color = color;
    }

    public IType getType() {
        return type;
    }

    public void setType(IType type) {
        this.type = type;
    }

    public void getPhone() {
        System.out.println("This is " + color.getColor() + " " + type.getType() + " phone");
    }
}
