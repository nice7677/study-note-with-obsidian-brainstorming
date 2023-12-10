# BeanFactory 
- 스프링 컨테이너 최상위 인터페이스
- 빈을 관리하고 조회 담당
- getBean 제공
- 우리가 사용했던 대부분은 BeanFactory가 제공하는 기능

# ApplicationContext
- BeanFactory 상속 받아 제공
- BeanFactory의 기능외 수 많은 기능을 제공함

### 부가기능
- 메세지소스 국제화
- 환경변수
	- dev, stg, prod
- 애플리케이션 이벤트
	- 이벤트 발행, 구독하는 모델을 지원
- 편리한 리소스 조회
	- 파일, 클래스파일, 외부 등 리소스 조회