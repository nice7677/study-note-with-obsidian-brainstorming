쓰레드 로컬은 해당 쓰레드만 접근할 수 있는 특별한 저장소.
여러쓰레드의 요청이 들어와도 저장을 실행한 쓰레드만이 접근할 수 있음.

```java
ThreadLocal<Object> threadLocal = new ThreadLocal<>();
```
위와 같은 코드를 넣어 사용 할 수 있다.

특히 스프링과같은 싱글톤으로 빈을 관리하는 곳에서 유용하게 사용한다.

하지만 웹서비스에서는 사용자의 요청이 끝날때 remove를 실행해 쓰레드 로컬을 삭제해줘야한다.

```java
ThreadLocal.remove();
```

안그러면 다른 유저의 요청에서 다른 요청시 들어있던 값이 나갈 수 있다.