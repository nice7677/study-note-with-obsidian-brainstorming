스프링 트랜잭션 옵션.

### @Transaction 의 트랜잭션 매니저 설정
트랜잭션 매니저를 설정하는법 두가지
1. value
2. transactionManager
기본적으로 트랜잭션 매니저를 스프링에서 자동으로 설정하지만
그게아니라 추가로 설정하고 싶은경우 value, transactionManager를 사용해 원하는 트랜잭션 매니저로 설정한다

```java
@Transactional("testTxManager")
public void test() {

}

@Transactional("brokenTxManager")
public void broken() {

}
```
### rollbackFor, noRollbackFor

- rollbackFor
	-  언체크 예외 RuntimeException, Error와 그 하위 예외가 발생하면 롤백
	-  체크 예외인 Exception과 그 하위 예외는 커밋
체크 예외는 커밋하는 이유는 비지니스 로직 상에서 난 에러인 경우 잡아서 처리를 해 로직을 완성해야 한다.
RuntimeException은 시스템 예외의 에러이기 때문에 복구가 불가한 경우가 많음으로 롤백을 시키는 기본 옵션이다.

이 기본 옵션을 제어하기 위해 rollbackFor과 noRollbackFor을 사용한다.

```java
@Transactional(rollbackFor = Excepction.class)
```
이렇게 되면 체크 예외인 Exception 에러가 발생해도 롤백하게 된다.
물론 Exception을 상속받은 하위 예외들도 포함이다.


rollbackFor뿐만아니라 **`rollbackForClassName`** 도 있는데 이런 예외 이름을 문자로 넣으면된다.

- noRollbackFor
	- 위에 있는 rollbackFor과 반대다.

noRollbackFor도 위에 rollbackForClassName 처럼 **`noRollbackForClassName`** 이 존재한다.

### propagation
트랜잭션 전파 옵션이다.
[[Transaction Propagation]]

### isolation
트랜잭션 격리 수준이다.
DB의 기본값을 따른다.
[[DB Isolation]]

### timeout
타임아웃을 정할 수 있는 옵션

### readOnly
readOnly는 성능 최적화를 위한 옵션이다
등록, 수정, 삭제가 안되고 읽기만 가능.
