package deque.static_deque;

import queue.dynamic_queue.ListQueue;

public class ArrayDeque <E> extends ListQueue<E> {

    private static final int DEFAULT_CAPACITY = 64;

    private Object[] array;

    private int size;

    private int front;

    private int rear;

    public ArrayDeque() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayDeque(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }


}
