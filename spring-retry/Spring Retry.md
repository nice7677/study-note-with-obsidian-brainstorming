[spring retry](https://github.com/spring-projects/spring-retry)

예제
```java
@Configuration
@EnableRetry
public class Application {

}

@Service
class Service {
    @Retryable(RemoteAccessException.class)
    public void service() {
        // ... do something
    }
    @Recover
    public void recover(RemoteAccessException e) {
       // ... panic
    }
}
```

기본 3회의 retry후 recover 실행

옵션
예외, 재시도 횟수, 백오프 정책

```java
RetryTemplate template = RetryTemplate.builder()
				.maxAttempts(3)
				.fixedBackoff(1000)
				.retryOn(RemoteAccessException.class)
				.build();

template.execute(ctx -> {
    // ... do something
});
```

BackOff 정책

```java
@Retryable(maxAttempts=12, backoff=@Backoff(delay=100, maxDelay=500))
```

다음과같이 delay와 maxDelay 지정 가능

Recover
```java
@Service
class Service {
    @Retryable(recover = "service1Recover", value = RemoteAccessException.class)
    public void service1(String str1, String str2) {
        // ... do something
    }

    @Retryable(recover = "service2Recover", value = RemoteAccessException.class)
    public void service2(String str1, String str2) {
        // ... do something
    }

    @Recover
    public void service1Recover(RemoteAccessException e, String str1, String str2) {
        // ... error handling making use of original args if required
    }

    @Recover
    public void service2Recover(RemoteAccessException e, String str1, String str2) {
        // ... error handling making use of original args if required
    }
}
```

@Retryable에 설정된 옵션을 통한 Retry까지 실패한경우 Recover 실행
```java
@Retryable(recover = "service1Recover")
```
Retryable 안에 Recover 옵션 설정

1.3.2 버전 이상부터
```java
@LocalRetryable
@RemoteRetryable
```

두개의 어노테이션 추가
로컬 서비스 호출용, Remote 서비스 호출용

```java
@Service
class Service {
    ...
    
    @LocalRetryable(include = TemporaryLocalException.class, recover = "service1Recovery")
    public List<Thing> service1(String str1, String str2){
        //... do something
    }
    
    public List<Thing> service1Recovery(TemporaryLocalException ex,String str1, String str2){
        //... Error handling for service1
    }
    ...
    
    @RemoteRetryable(include = TemporaryRemoteException.class, recover = "service2Recovery")
    public List<Thing> service2(String str1, String str2){
        //... do something
    }

    public List<Thing> service2Recovery(TemporaryRemoteException ex, String str1, String str2){
        //... Error handling for service2
    }
    ...
}
```