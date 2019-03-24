package simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleProtoTest {
    public static void main(String[] args) {
        ConcreteTypeA type1 = new ConcreteTypeA();
        type1.setName("Jim");
        type1.setAge(44);
        List<String> children = new ArrayList<String>();
        children.add("Tom");
        type1.setChildren(children);

        Client client = new Client();
        ConcreteTypeA type2 = (ConcreteTypeA) client.clone(type1);

        System.out.println(type1.getChildren() == type2.getChildren());

    }
}
