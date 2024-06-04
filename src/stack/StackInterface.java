package stack;

/**
 *
 * 자바 stack Interface 입니다.
 * StackInterface는 Stack에 의해 구현됩니다.
 *
 * @AUTHOR dyd71
 * @DATE 2024-06-04
 * @PARAM <E> the type of elements in this Stack
 * @VERSION 1.0
 */
public interface StackInterface<E> {
    /**
     * 스택의 맨 위에 요소를 추가한다.
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     * @param item 스택에 추가할 요소
     * @return 스택에 추가된 요소
     */
    E push(E item);

    /**
     * 스택의 맨 위에 있는 요소를 제거하고 제거된 요소를 반환한다.
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     * @return 제거된 요소
     */
    E pop();

    /**
     * 스택의 맨 위에 있는 요소를 제거하지 않고 반환한다.
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     * @return 스택에서 맨위에 있는 요소
     */
    E peek();

    /**
     * 스택의 상반 부터 특정 요소가 몇 번째 위치에 있는지를 반환한다.
     * 중복되는 원소가 있을 경우 가장 위에 있는 요소의 위치가 반환된다.
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     * @param value 스택에서 찾을 요소
     * @return 스택의 맨위에 요소
     */
    int search(Object value);

    /**
     * 스택의 요소 개수를 반환
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     * @return 스택의 요소 갯수
     */
    int size();

    /**
     * 스택의 모든 요소를 삭제
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     */
    void clear();

    /**
     *
     * 스택의 요소가 비어있는지 확인
     * @AUTHOR       dyd71
     * @DATE         2024-06-04
     * @PARAM
     * @VERSION      1.0
     * @return 스택의 요소가 없을 경우 {@code true}, 그외 {@code false} 반환
     */
    boolean empty();
}
