package queue.link;

/**
 * @AUTHOR dyd71
 * @DATE 2024-06-11
 * @PARAM
 * @VERSION 1.0
 */
public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
