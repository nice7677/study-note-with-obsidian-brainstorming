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

클래스로 빼서 사용하는 경우

내부호출 -> 외부호출로 전환 되기에 위와 같은 경우를 방지 할 수 있다.

그리고 Spring Transaction은 pulbic method에만 걸린다.

클래스레벨에 Transaction을 선언한 경우 public으로 선언된 method에만 트랜잭션이 적용 된다.

Transaction을 선언하는 메소드의 경우 **`외부에서 호출 되는 시작점`** 에 선언한다!