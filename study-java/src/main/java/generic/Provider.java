package generic;

import java.io.Serializable;

/**
 * E: 요소 (element)
 * K: 키
 * N: 숫자
 * T: 타입
 * V: 값
 * S,U,V 2,3,4번째 선언된 타입
 * @param <T>
 */
public class Provider<T> implements Serializable {

    private T object;

    public Provider(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
