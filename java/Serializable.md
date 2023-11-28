# 직렬화

**serialVersionUID** -> 중요한놈

객체의 버전을 명시함

파일 읽고 쓰기할때 ID 가 변경됨.

그러므로 읽고 쓰기를 할때에는 ID를 명시해서 어떤 객체인지를 알려주자.

이렇게 해놓으면 값을 찾을수없는 변수에는 null 이 들어간다.

**transient** -> Serializable에서 중요한놈, 떨어질수없는관계

transient를 선언한 변수는 Serializable 대상에서 제외됨.