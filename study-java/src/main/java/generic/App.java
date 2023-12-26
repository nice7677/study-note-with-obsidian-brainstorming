package generic;

public class App {

    public static void main(String[] args) {

        Provider<HanaBank> hanaBankProvider = new Provider<>(new HanaBank());
        Provider<ScBank> scBankProvider = new Provider<>(new ScBank());

        hanaBankProvider.getObject().printName();
        hanaBankProvider.getObject().printName(new String("TWO"));
//        hanaBankProvider.getObject().printName(new Integer(1)); 에러

        scBankProvider.getObject().printName();

        ExtendsProvider<HanaBank> hanaBankExtendsProvider = new ExtendsProvider<>(hanaBankProvider.getObject());
//        ExtendsProvider<ScBank> hanaBankExtendsProvider = new ExtendsProvider<>(scBankProvider.getObject()); 에러 도출
        hanaBankExtendsProvider.getObject().printName();

    }

}
