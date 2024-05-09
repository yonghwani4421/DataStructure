package stack.dynamic_stack;

import java.util.EmptyStackException;

public class LinkedStack<E> {

    private Node<E> topNode;

    public LinkedStack(){
        topNode=null;
    }

    public boolean isEmpty(){
        return topNode == null;
    }

    public E push(E value){
        topNode = new Node<>(value,topNode);
        return value;
    }


    public E pop(){
        E value = null;
        if (isEmpty()){
            throw new EmptyStackException();
        } else {
            value = topNode.item;
            topNode = topNode.next;
        }

        return value;
    }

    public void printAll(){
        Node<E> currNode = topNode;
        while (currNode!=null){
            System.out.println("currNode = " + currNode.item);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();

        stack.push(1);

        stack.push(2);

        stack.pop();

        stack.push(4);
        stack.printAll();


    }


}
