# Java Collection framework 직접구현
### Java Collection framework를 직접 구현하여 정리하고자 한다.

# List
## 1. ArrayList


# Stack
스택은 컴퓨터에서 아주 많이 사용하는 자료구조로서, 쌓아놓은 더미를 뜻한다.

### 특징
- 후입선출(LIFO : Last-In First-Out) 가장 마지막에 들어온 데이터가 가장 먼저 나간다는 의미
- 문서 편집기에서 undo의 기능이 스택 자료구조이다.
- 스택은 데이터와 현재 위치를 기억하는 저장 공간 두가지 데이터가 필요로 한다.
- 배열( 정적 )과 연결리스트( 동적 )를 활용한 구현이 있다.

# Queue

### 특징
- 선입선출(FIFO : First In Firtst Out) 가장 처음에 들어온 데이터가 가장 먼저 나간다는 의미
- 줄서기, 마트 재고관리부터 운영체제의 프로세스 관리, 너비 우선 탐색 알고리즘까지 다양한 곳에 이용되고 있다.
- 배열( 정적 )과 연결리스트( 동적 )를 활용한 구현이 있다.


# Deque
덱은 어떤 쪽으로 입력하고 어떤 쪽으로 출력하느냐에 따라서 스택으로 사용할 수도 있고, 큐로도 사용할 수 있다.


### 특징
- ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 등의 클래스
- 단방향인 queue와는 달리 양방향 구조이다.
- 단방향구조였던 queue 인터페이스를 상속받아서 양방향 메소드를 더 추가해주는 과정을 거친것
