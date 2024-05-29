package list;
/**
 * 자바 LIST 인터페이스
 * List는 ArrayList, SinglyLinkedList, DoublyLinked에 의해 각각 구현
 * @param <E>
 */
public interface List <E>{

    /**
     *
     * 리스트 요소 추가
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우 리스트에 이미 중복되는 요소가 있을 경우 false,
     * 없는경우 true를 반환
     */
    boolean add( E value );

    /**
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param index 리스트가 추가될 변수 위치
     * @param value 리스트가 추가할 요소
     */
    void add(int index, E value);

    /**
     *
     * 리스트 요소 추가
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param index 삭제할 요소 위치
     * @return 삭제한 요소를 반환
     */
    E remove(int index);

    /**
     *
     * 리스트 삭제
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param value 삭제할 요소
     * @return 리스트에 삭제할 요소가 없거나 삭제에 실패할 경우 false를 반환하고, 성공하는 경우 true를 반환
     */
    boolean remove(Object value);

    /**
     *
     * 리스트 삭제
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param index 접근할 인덱스의 위치
     * @return 접근한 요소의 값 반환
     */
    E get(int index);

    /**
     *
     * 특정위치의 요소를 새 요소로 대체합니다.
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param index
     * @param value
     */
    void set(int index, E value);

    /**
     *
     * 리스트에 특저 요소가 있는지 여부 확인
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param value 찾는 요소
     * @return 요소가 있는경우 true, 없는경우 false 반환
     */
    boolean contains(Object value);

    /**
     *
     * 리스트에 있는 요소의 개수를 반환
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @param value 리스트에서 위치를 찾을 요소 변수
     * @return 리스트에서 처음로 요소와 일치하는 위치를 반환
     * 만약 일치하는 요소가 없을 경우 -1 반환
     */
    int indexOf(Object value);

    /**
     *
     * 리스트에 요소가 비어있는지 반환
     *
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     * @return 리스트에 요소가 없을 경우 true, 있는 경우 false 반환
     */
    boolean isEmpty();

    /**
     *
     *  리스트에 모든 요소를 삭제한다.
     * @AUTHOR       dyd71
     * @DATE         2024-05-27
     * @PARAM
     * @VERSION      1.0
     */
    public void clear();


}
