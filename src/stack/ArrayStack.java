package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> {

    private int top = -1;
    private Object[] arr;

    private static int DEFAULT_SIZE = 6;



    public ArrayStack(int size) {
        arr = new Object[size];
    }

    public ArrayStack() {
        arr = new Object[DEFAULT_SIZE];
    }


    public boolean isFull(){
        return top == arr.length - 1;
    }

    public boolean isEmpty(){
        return  top == -1;
    }

    private void resize(){
        int arr_capacity = arr.length - 1;

        if (arr_capacity == top){
            int new_capacity = arr.length * 2;

            arr = Arrays.copyOf(arr,new_capacity);
            return;
        }

        if (top < (arr_capacity / 2)){
            int half_capacity = arr.length / 2;

            Arrays.copyOf(arr, Math.max(half_capacity, DEFAULT_SIZE));

            return;
        }

    }

    public E push(E value){
        if (isFull())
            resize();
        top ++;

        arr[top] = value;

        return value;
    }

    public E pop(){
        if (isEmpty())
            throw new EmptyStackException();

        E value = (E) arr[top];

        arr[top] = null;

        top --;

        resize();

        return value;
    }

    public E peek(){
        if (isEmpty())
            throw new EmptyStackException();

        return (E) arr[top];
    }

    public int search(E value){

        for (int i = top; i >= 0; i--){
            if(arr[i].equals(value))
                return top - i + 1;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "stack.ArrayStack{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }


    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();


        stack.push(1);
        stack.push(2);

        stack.pop();


        System.out.println("stack = " + stack.toString());

    }


}

