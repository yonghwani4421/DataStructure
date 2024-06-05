package queue.array;

import queue.Queue;

/**
 * @AUTHOR dyd71
 * @DATE 2024-06-05
 * @PARAM
 * @VERSION 1.0
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int DEFAULT_CAPACITY = 64;

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
