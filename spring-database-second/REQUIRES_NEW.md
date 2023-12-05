물리 트랜잭션을 나누는 방법.

```java
DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
```
위와 같이 트랜잭션을 선언하고 설정값으로 **TransactionDefinition.PROPAGATION_REQUIRES_NEW** 을 준다.

이 옵션을 사용하게 되면 A 트랜잭션이 사용되던 도중 잠시 멈추고 B 트랜잭션이 동작한다. 그리고 B 트랜잭션이 끝나고 트랜잭션 동기화 매니저에 반납되면 A 트랜잭션이 다시 시작 된다.

이 옵션의 경우 물리 트랜잭션이 동시에 연결되는 것이기에 사용시 주의해야한다.