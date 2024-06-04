package list.dlink;


import list.List;

import java.util.NoSuchElementException;

/**
 * @AUTHOR dyd71
 * @DATE 2024-06-03
 * @PARAM
 * @VERSION 1.0
 */
public class DLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){

        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        // 뒤에서 부터 색인
        if ( index + 1 > size / 2){
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--){
                x = x.prev;
            }
            return x;
        }
        // 앞에서 부터 색인
        else {
            Node<E> x = head;
            for (int i = 0; i < index; i++){
                x = x.next;
            }
            return x;
        }
    }
    public void addFirst(E value){
        Node<E> newNode = new Node<>(value);
        newNode.next = head;

        /**
         * head가 null이 아닐 경우에만 기존 head노드의 prev 변수가
         * 새 노드를 가리키도록 하자
         * 기존 head노드가 없는 경우(null)는 데이터가 없는경우로 head.prev를 하면 잘못된 참조가 된다.
         */
        if (head != null){
            head.prev = newNode;
        }

        head = newNode;
        size++;

        /**
         * next 가 null인경우 최초의 데이터 삽입으로 tail 값에 head로 맞춰준다.
         */
        if (head.next == null){
            tail = head;
        }
    }
    public void addLast(E value){
        Node<E> newNode = new Node<>(value);
        if (size == 0){
            addFirst(value);
            return ;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }


    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {

        // 인덱스 범위 확인
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        // 첫번째 삽입이라면 addFirst 호출
        if (index == 0){
            addFirst(value);
            return;
        }

        // 마지막 삽입이라면 addLast 호출
        if (index == size){
            addLast(value);
            return;
        }

        /**
         * 첫 삽입, 마지막 삽입 외 인덱스 삽입 연산시
         * 삽입할 index 하나 전 노드, 삽입할 인덱스의
         * 노드를 지정하여 기존 연결을 끊고 newNode에 새롭게 연결하여 삽입한다.
         */
        Node<E> prev_Node = search(index - 1);
        Node<E> next_Node = prev_Node.prev;
        Node<E> newNode = new Node<>(value);

        prev_Node.next = null;
        next_Node.next = null;

        prev_Node.next = newNode;

        newNode.prev = prev_Node;
        newNode.next = next_Node;

        prev_Node.next = newNode;
        size++;
    }

    private E remove(){

        Node<E> headNode = head;

        // List에 아무 것도 없는 경우
        if (headNode == null){
            throw new NoSuchElementException();
        }

        // 반환하기 위한 값
        E element = head.data;

        Node<E> nextNode = head.next;


        head.data = null;
        head.next = null;

        if (nextNode != null){
            nextNode.prev = null;
        }

        head = nextNode;
        size--;

        if (size == 0){
            tail = null;
        }
        return element;
    }

    @Override
    public E remove(int index) {

        // 인덱스 범위가 벚어난 경우
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }


        // 가장 앞의 인덱스의 경우
        if (index == 0){
            return remove();
        }

        Node<E> prevNode = search(index - 1);
        Node<E> removeNode = prevNode.next;
        Node<E> nextNode = removeNode.next;
        E element = removeNode.data;

        prevNode.next = null;
        removeNode.next = null;
        removeNode.prev = null;
        removeNode.data = null;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;


        /**
         * nextNode가 null이라는 것은 마지막 노드를 삭제했다는 의미
         */
        if (nextNode != null){
            nextNode.prev = null;

            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        }
        else {
            tail = prevNode;
        }
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {

        Node<E> prevNode = head;
        Node<E> x = head;

        for (; x != null; x = x.next){
            if (value.equals(x.data)){
                break;
            }
            prevNode = x;
        }

        if (x == null){
            return false;
        }

        if (x.equals(head)){
            remove();
            return true;
        } else {
            Node<E> nextNode = x.next;

            prevNode.next = null;
            x.data = null;
            x.next = null;
            x.prev = null;

            if (nextNode != null){
                nextNode.prev = null;

                nextNode.prev = prevNode;
                prevNode.next = nextNode;
            } else {
                tail = prevNode;
            }
            size--;
            return true;
        }
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {

        Node<E> setNode = search(index);
        setNode.data = null;
        setNode.data = value;
        search(index).data = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;

        for (Node<E> x = head; x != null; x = x.next){
            if (value.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object value){
        int index = size;
        for (Node<E> x = tail; x != null; x = x.prev){
            index--;
            if (value.equals(x.data)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        /**
         * 모든 요소를 전부 null로 초기화 해주는것이 자바의 가비지 컬렉터가 명시적으로
         * 해당 메모리를 안쓴다고 인지하기에 메모리 관리 효율 측면에서 더욱 좋다.
         */
        for (Node<E> x = head; x != null;){
            Node<E> nextNode = x.next;
            x.next = null;
            x.data = null;
            x.prev = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
}
