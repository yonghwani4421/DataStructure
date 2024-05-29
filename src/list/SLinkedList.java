package list;

import java.util.NoSuchElementException;

public class SLinkedList<E> implements List<E> {

    private Node<E> head;   // 노드의 첫 부분
    private Node<E> tail;   // 노드의 마지막 부분
    private int size;       // 요소의 갯수

    public SLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 특정 위치의 노드를 반환하는 메서드
    private Node<E> search(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = this.head;

        for (int i = 0; i < index; i++) {
             x = x.next;
        }
        return x;
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<E>(value);   // 노드 생성
        newNode.next = head;                    // 새 노드의 다음 노드로 head 노드를 연결
        size++;

        /**
         * 첫데이터가 들어간경우
         */
        if (head.next == null){
            tail = head;
        }

    }

    @Override
    public boolean add(E value) {
        addFirst(value);
        return true;
    }

    public void addLast(E value){
        Node<E> newNode = new Node<E>(value);

        if (size == 0){
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;

    }

    @Override
    public void add(int index, E value) {

        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            addFirst(value);
            return;
        }
        if (index == size){
            addLast(value);
        }
        // 추가하려는 노드
        Node<E> newNode = new Node<E>(value);

        // 삽입하려는 위치 하나 이전 노드
        Node<E> prev_Node = search(index-1);

        // 삽입하려는 위치의 노드
        Node<E> next_Node = prev_Node.next;

        prev_Node.next = null;

        prev_Node.next = newNode;

        newNode.next = next_Node;
        size ++;

    }

    public E remove() {
        Node<E> headNode = this.head;

        if (headNode == null){
            throw new NoSuchElementException();
        }

        E element = headNode.data;

        Node<E> nextNode = head.next;
        head.data = null;
        head.next = null;

        head = nextNode;
        size --;

        if (size == 0){
            tail = null;
        }
        return element;
    }

    @Override
    public E remove(int index) {
        if (index == 0){
            return remove();
        }

        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<E> prevNode = search(index - 1);
        Node<E> removeNode = prevNode.next;
        Node<E> nextNode = removeNode.next;

        E element = removeNode.data;

        prevNode.next = nextNode;

        if (prevNode.next == null){
            tail = prevNode;
        }

        removeNode.next = null;
        removeNode.data = null;
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = this.head;
        boolean hasValue = false;
        Node<E> x = this.head;

        for (; x != null; x = x.next){
            if (value.equals(x.data)){
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        if (x == null){
            return false;
        }

        if (x.equals(head)){
            remove();
            return hasValue;
        } else {
            prevNode.next = x.next;

            if (prevNode.next == null){
                tail = prevNode;
            }
            x.data = null;
            x.next = null;

            size--;
            return hasValue;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> searchNode = search(index);

        searchNode.data = null;
        searchNode.data = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;

        for(Node<E> x = head; x != null; x = x.next){
            if (value.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != null; x = x.next){
            Node<E> nextNode = x.next;

            x.data = null;
            x.next = null;

            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }
}
