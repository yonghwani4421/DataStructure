package list.dlink;


import list.List;

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

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            addFirst(value);
            return;
        }

        if (index == size){
            addLast(value);
            return;
        }

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

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E value) {

    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}
