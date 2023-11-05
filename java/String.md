String은 불변, 변경을 하면 변경되는게 아니라 새로운 객체가 생성됨.
String pool에 의해 관리됨.

스택 메모리는 기본형이 저장됨.
String은 기본형이 아님.
그렇기 때문에 힙에 저장됨.
![[스크린샷 2023-11-05 오후 10.30.08.png]]

String을 제외한 기본형은 Stack, String은 Heap에서도 String pool에 저장됨.

String을 생성하면 문자열을 String pool에서 확인하고 풀안에 있으면 참조를함. 없으면 생성하고 참조함.

```java
String str = "Java";
String str1 = "Java";
String str2 = "Study";
```

str을 생성할 때는 값이 풀에 없기 때문에 풀에 생성 후 str에 참조 시킴.
str1을 생성할 때는 값이 풀에 존재하기 때문에 str에서 사용된 값을 str1에 참조 시킴.
str2에 값은 풀에 없기 때문에 str처럼 값을 풀에 생성하고 참조 시킴.

![[스크린샷 2023-11-05 오후 10.36.51.png]]

String 객체를 생성할 때 리터럴이아닌 new 키워드로 생성 할 수 있음.
new를 써서 생성하게 되면 String pool이 아니라 풀 외부 힙 영역에 생성됨.

```java
String str = "Java";
String str1 = new String("Java");
```
![[스크린샷 2023-11-05 오후 10.38.40.png]]

이렇게 되면 메모리 할당이 계속됨. 중복 값에대한 참조를 시킬 수 없음.

이때는 intern을 쓰면 JVM이 문자열을 힙 영역에 생성하지 않고 풀에서 찾아 참조 시킴. 없으면 생성하고 참조 시킴.

```java
String str = "Java";

String str1 = new String("Java").intern();

String str2 = new String("Code");
str2.intern();
```
![[스크린샷 2023-11-05 오후 10.41.59.png]]
문자열을 쓸때 == 이랑 equals

== 는 메모리 주소를 비교함. equals는 안에 있는 값을 비교함.
![[스크린샷 2023-11-05 오후 10.44.59.png]]
참조를 같이하는 str1, str3 은 == 이 true 지만 str1, str2는 false임.

```java
String str1 = "Java";
String str2 = "C++";

String str3 = "Java";

String str4 = new String("Java");
String str5 = new String("C++");

String str6 = new String("Java").intern();

System.out.println(str1 == str4);
System.out.println(str2 == str5);
System.out.println(str1 == str3);
System.out.println(str1 == str6);
```
연산 값은
```java
false
false
true
true
```
![[스크린샷 2023-11-05 오후 10.47.54.png]]

