package stack.dynamic_stack;

public class Node <E> {
    public E item;

    public Node<E> next;

    public Node(E item) {
        this.item = item;
        next = null;
    }

    public Node(E item, Node<E> node) {
        this.item = item;
        this.next = node;
    }


}
