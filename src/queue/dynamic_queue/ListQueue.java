package queue.dynamic_queue;

public class ListQueue <T>{
    Node<T> front = null;
    Node<T> rear = null;

    public boolean isEmpty(){
        return front == null;
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (isEmpty())
            front = newNode;
        else
            rear.next = newNode;

        rear = newNode;
    }

    public T dequeue(){
        if (isEmpty()){
            System.out.println("큐가 비었습니다.");
            return null;
        }

        T data = front.data;

        if (front == rear){
            front = null;
            rear = null;
        } else {
            front = front.next;
        }

        return data;
    }

    public T peek(){
        return front.data;
    }

    public static void main(String[] args) {
        ListQueue<Integer> listQueue = new ListQueue<>();

        for (int i = 0; i < 10; i++){
            listQueue.enqueue(i);
        }

        System.out.println("listQueue.peek() = " + listQueue.peek());


        listQueue.dequeue();
        listQueue.dequeue();
        listQueue.dequeue();
        listQueue.dequeue();

        System.out.println("listQueue.peek() = " + listQueue.peek());



    }
}
