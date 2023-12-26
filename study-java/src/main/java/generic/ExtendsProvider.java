package generic;

public class ExtendsProvider<T extends HanaBank> {

    T object;

    public ExtendsProvider(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
