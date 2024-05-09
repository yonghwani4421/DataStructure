package stack;

import java.util.ArrayList;

public class ArrayListStack <E> {


    private ArrayList<E> list;
    private int top;

    public ArrayListStack() {
        list = new ArrayList<E>();
        top = -1;
    }


    public boolean isFull(){
        return top == list.size() - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public E push(E value) {
        list.add(value);
        top ++;
        return value;
    }

    public E pop() {
        E value = list.get(top);
        list.remove(top--);
        return value;
    }

    public E peek(){
        return list.get(top);
    }

    public int search(E value){
        int result = list.lastIndexOf(value);

        if (result != -1){
            return top - result + 1;
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return "ArrayListStack{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        ArrayListStack stack = new ArrayListStack();


        stack.push(1);
        stack.push(2);

        stack.pop();


        System.out.println("stack = " + stack.toString());

    }


}
