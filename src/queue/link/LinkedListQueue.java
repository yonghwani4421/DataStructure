package queue.link;

import queue.Queue;

import java.util.NoSuchElementException;

/**
 * @AUTHOR dyd71
 * @DATE 2024-06-11
 * @PARAM
 * @VERSION 1.0
 */
public class LinkedListQueue<E> implements Queue<E> {


    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<>(value);

        if (size == 0){
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;


        return true;
    }


    @Override
    public E poll() {
        if (size == 0){
            return null;
        } else {
            E element = head.data;

            Node<E> next = head.next;
            head.next = null;
            head.data = null;

            head = next;
            size--;
            return element;
        }
    }

    public E remove(){
        E element = poll();

        if (element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public E peek() {
        if (size == 0){
            return null;
        }
        return head.data;
    }

    public E element(){
        E element = peek();

        if (element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean contains(Object value){

        for (Node<E> x = head; x != null; x = x.next){
            if (value.equals(x.data)){
                return true;
            }
        }
        return false;

    }

    public void clear(){
        for (Node<E> x = head; x != null;){
            Node<E> next = x.next;
            x.data = null;
            x.next = null;

            x = next;
        }
        size = 0;
        head = tail = null;
    }
}
