package queue;

/**
 *
 * Queue interface
 * Queue는 ArrayQueue, LinkedQueue, Deque, PriorityQueue에 의해 구현됩니다.
 *
 * @AUTHOR dyd71
 * @DATE 2024-06-05
 * @PARAM
 * @VERSION 1.0
 */
public interface Queue<E> {
    /**
     * 큐의 가장 마지막에 요소를 추가
     * @AUTHOR       dyd71
     * @DATE         2024-06-05
     * @PARAM
     * @VERSION      1.0
     * @param e 큐에 추가할 요소
     * @return 큐에 요소가 정상적으로 추가되었을 경우 true를 반환
     */
    boolean offer(E e);

    /**
     * 큐의 첫 번째 요소를 삭제하고 삭제된 요소를 반환
     * @AUTHOR       dyd71
     * @DATE         2024-06-05
     * @PARAM
     * @VERSION      1.0
     * @return 큐의 삭제된 요소 반환
     */
    E poll();

    /**
     * 큐의 첫 번째 요소를 반환
     * @AUTHOR       dyd71
     * @DATE         2024-06-05
     * @PARAM
     * @VERSION      1.0
     * @return 큐의 첫번째 요소를 반환
     */
    E peek();

}
