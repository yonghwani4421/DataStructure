package list.dlink;

/**
 * @AUTHOR dyd71
 * @DATE 2024-06-03
 * @PARAM
 * @VERSION 1.0
 */
public class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
