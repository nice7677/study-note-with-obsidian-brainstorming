스프링의 컨텍스트는 ApplicationContext 임
ApplicationContext는 인터페이스임.

ApplicationContext말고 BeanFactory도 있음.

근데 BeanFactory는 사용하는 경우가 거의 없어 ApplicationContext를 스프링 컨테이너라함.

# Bean 등록
@Bean 스캔 후 등록
키 -> method name
벨류 -> bean 객체