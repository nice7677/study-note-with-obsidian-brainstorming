스프링 트랜잭션의 경우 트랜잭션 프록시로 감싼 Bean을 등록해 사용하게 되는데

잘못사용하게 되는 경우 트랜잭션이 적용되지 않고 실행될 수 있다.

다음과 같은 경우에 만날 수 있다.

```java
@Transaction
public void hello() {
	
}

public void world() {
	hello();
}
```

다음과 같은 코드가있을때 

hello 메서드의 Transaction을 활용하기 위해서는 Transaction Proxy로 등록된 hello를 호출 해야하는데

Transaction Proxy로 등록되지 않은 world 메소드에서 hello를 호출하게 될 경우

world는 Transcation Proxy가 아닌 this 즉 자신의 hello를 호출하게 되어 트랜잭션이 적용하지 않게 된다는 것임.

이런 경우 **`내부호출`** 이기 때문에 트랜잭션 프록시를 거치지 않고 바로 실행하게 되어 원하던 트랜잭션 적용이 되지않는다.

코드를 쓸때 이 점을 주의 해야 한다.

간단한 해결방법으로는 hello메서드를 다른 클래스로 빼서 사용하는 법이 있다.