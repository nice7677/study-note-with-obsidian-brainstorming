package generic;

public class HanaBank implements Bank{

    @Override
    public void printName() {
        System.out.println("HELLO IM HANA");
    }

    public <T extends String> void printName(T name) {
        System.out.println(name);
    }

}
