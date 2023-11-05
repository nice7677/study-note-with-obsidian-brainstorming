인터럽트는 `띵동`과도 같음

사전적 의미로는 `끼어들다`,`중단시키다` 정도의 의미를 가진다.

무언가를 하고 있을때 이를 방해하는 요소임.

인터럽트가 발생하면 I/O 가 발생하게됨.

만약 내가 `Hello world`와 같은 출력은 작성하고 실행하면 이것 또한 출력이기에 [[Operation System]]단 API에서 ~write를 호출 할 것임.

hello world -> user mode -> kernel -> interrept 발생 이런 순임.

인터럽트가 발생되면 WAIT 모드가 작동함.

# 인터럽트 종류

### 외부 인터럽트

외부 인터럽트 == S/W 인터럽트

1. 전원 이상
2. 기계 고장
3. 입출력(I/O)
4. 외부 신호

### 내부 인터럽트

내부 인터럽트 == H/W 인터럽트

1. 0으로 나누는 경우
2. 오버플로우 / 언더플로우가 발생하는 경우
3. 프로그램 상의 오류
4. CPU가 인스트럭션을 수행하는 도중에 일어나는 인터럽트

# ISR (Interrupt Service Routine)

isr은 인터럽트 핸들러라고도 한다.

인터럽트가 발생 할 경우 전에 현재 상태를 백업하고 인터럽트 처리가 끝나면 다시 복구한다.

### 인터럽트 동작 순서

![interrupt](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6bJRKXr9wkwEBhoudu8LP4eEejlGDunhR0Ma6KghIZ0VAS9MdZ2MOTi9b6MzxN1BQEQ&usqp=CAU)