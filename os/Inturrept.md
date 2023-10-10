인터럽트는 `띵동`과도 같음

무언가를 하고 있을때 이를 방해하는 요소임.

인터럽트가 발생하면 I/O 가 발생하게됨.

만약 내가 `Hello world`와 같은 출력은 작성하고 실행하면 이것 또한 출력이기에 [[Operation System]]단 API에서 ~write를 호출 할 것임.

hello world -> user mode -> kernel -> interrept 발생 이런 순임.

인터럽트가 발생되면 WAIT 모드가 작동함.