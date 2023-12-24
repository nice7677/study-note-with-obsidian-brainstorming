빈  스코프

# Scope 종류

- 싱글톤 - 스프링 기본 스코프
- 프로토타입 - 스프링에서 빈 생성과 주입까지만 관여하고 더는 관리 하지않음. 버림.
- 웹
  - request - 요청이 들어오고 나갈때까지 유지
  - session - 세션이 생성되고 종료될 때 까지 유지
  - application - 서블릿 컨텍스트와 같은 범위로 유지

싱글톤 빈이 프토타입 스코프는 빈을 주입 받은 경우에 사용할때마다 새로 주입되는것이아니기에 이것을 주의하면 됨.

스프링에서 제공하는 ObjectFactory, ObjectProvider를 사용하면 위의 문제를 해결할 수 있음.

현재는 Provider를 사용하면댐.

다른 방법으로는 JSR-330 Provider를 사용하면댄다.

# 프록시
스프링에서 제공하는 스코프 프록시 기능을 사용할 수 있음.
CGLIB으로 프록시 객체를 사용해 기존에 ObjectProvider를 사용하던 넘을 대체함.

```java
 @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
```

proxyMode를 상황에 맞게 적용해 주면 된다. TARGET_CLASS or INTERFACE ...

사실 Provider를 사용하든, 프록시를 사용하든 핵심 아이디어는 **진짜 객체 조회를 꼭 필요한 시점까지ㄴ 지연처리 한다는 점이다.**

**주의점**
마치 싱글톤을 사용하는 것 같지만 다르게 동작하기 때문에 결국 주의해서 사용해야 한다.  
이런 특별한 scope는 꼭 필요한 곳에만 최소화해서 사용하자, 무분별하게 사용하면 유지보수하기 어려워진다.
