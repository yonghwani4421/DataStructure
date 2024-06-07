package queue.array;

import queue.Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    private void resize(int newCapacity){
        int arrayCapacity = array.length;

        Object[] newArray = new Object[newCapacity];

        for (int i = 1, j = front + 1; i <= size; i++, j++){
            newArray[i] = array[j % arrayCapacity];
        }

        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E e) {
        if ((rear + 1) % array.length == front){
            resize(array.length * 2);
        }

        rear = (rear + 1) % array.length;

        array[rear] = e;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if (size == 0){
            return null;
        }
        front = (front + 1) % array.length;
        @SuppressWarnings("unchecked")
        E item = (E) array[front];

        array[front] = null;
        size--;

        // 사이즈 재설정
        if (array.length > DEFAULT_CAPACITY && size < (array.length / 4)){
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }
    public E remove(){
        E item = poll();

        if (item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public E peek() {
        if (size == 0){
            return null;
        }
        @SuppressWarnings("unchecked")
        E item = (E) array[(front + 1)% array.length];

        return item;
    }
    public E element(){
        E item = peek();
        if (item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object value){
        int start = (front + 1) % array.length;

        for (int i = 0, idx = start; i < size; i++, idx = (idx + 1) % array.length){
            if (array[idx].equals(value)){
                return true;
            }
        }

        return false;
    }

}
