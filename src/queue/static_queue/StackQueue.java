package queue.static_queue;

import java.util.Arrays;

public class StackQueue {
    int front;
    int rear;

    int DEFAULT_VAL = 0;
    int DEFAULT_ARRAY_SIZE = 10;

    Object[] queue;

    public StackQueue() {
        this.front = DEFAULT_VAL;
        this.rear = DEFAULT_VAL;
        this.queue = new Object[DEFAULT_ARRAY_SIZE];
    }

    public boolean isFull(){
        return front == rear && queue[front] != null;
    }
    public boolean isEmpty(){
        return front == rear && queue[front] == null;
    }

    public void enqueue(Object value){
        if (isFull()){
            System.out.println("큐에 더 이상 데이터를 저장할 공간이 없습니다.");
            return;

        }
        queue[rear++] = value;
        rear = rear % queue.length;
    }

    public Object dequeue() {
        if (isEmpty()){
            System.out.println("큐가 비어있습니다.");
        }

        Object dequeuedData = queue[front];

        queue[front++] = null;

        front = front % queue.length;

        return dequeuedData;
    }

    public Object peek(){
        return queue[front];
    }

    @Override
    public String toString() {
        return "StackQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    public static void main(String[] args) {

        StackQueue queue = new StackQueue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);


        System.out.println("queue.toString() = " + queue.toString());

        queue.dequeue();
        queue.dequeue();

        System.out.println("queue.toString() = " + queue.toString());
        System.out.println("queue.peek() = " + queue.peek());

    }


}
