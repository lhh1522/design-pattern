package simple;

import java.util.List;

public class ConcreteTypeA implements Prototype {
    private String name;
    private int age;
    private List<String> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public ConcreteTypeA clone() {
        ConcreteTypeA concreteTypeA = new ConcreteTypeA();
        concreteTypeA.setName(this.name);
        concreteTypeA.setAge(this.age);
        concreteTypeA.setChildren(this.children);

        return concreteTypeA;
    }
}
