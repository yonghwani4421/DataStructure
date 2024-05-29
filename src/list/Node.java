package list;

class Node<E> {
    E data;
    Node<E> next; // 다음 노드 객체를 가리키는 랜퍼런스 상수

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
