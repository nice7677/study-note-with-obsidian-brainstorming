빈 생명 주기

객체 생성 -> 의존관계 주입

스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸 전 콜백 -> 스프링 종료

@PostConstruct, @PreDestory

## @PostConstruct

빈 속성이 초기화 직후에 @PostConstruct 주석이 달린 메소드를 한번 호출함. 초기화할 항목이 없어도 실행됨.
이 메서드 용도중 하나는 DB를 연결하는것.

[예제](../study-java/src/main/java/beanlifecycle/DbInit.java)


## PreDestory

Srping이 애플리케이션 컨텍스트에서 빈을 제거하기 직전에 한번만 실행됨.
@PostConstruct와 마찬가지로 @PreDestory가 달린 메소드는 정적일 수 없음.

사용 용도는 Bean이 삭제되기 전에 리소스를 해제하거나 데이터베이스 연결을 닫기 위한 작업을 수행함.

[예제](../study-java/src/main/java/beanlifecycle/DbDisposable.java)
