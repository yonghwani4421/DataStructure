package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @AUTHOR dyd71
 * @DATE 2024-06-04
 * @PARAM
 * @VERSION 1.0
 */
public class Stack<E> implements StackInterface<E>{

    private static final int DEFALULT_CAPCITY = 10;
    private static final  Object[] EMPTY_ARRAY = {};

    private Object[] array;
    private int size;

    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }
    public Stack(int capcity){
        this.array = new Object[capcity];
        this.size = 0;
    }

    private void resize(){
        // 빈 배열인 경우 DEFAULT_CAPCITY 지정
        if (Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFALULT_CAPCITY];
            return;
        }

        int arrayCapcity = array.length;

        // 용적이 가득찬 경우
        if (size == arrayCapcity){
            int newSize = arrayCapcity*2;
            array = Arrays.copyOf(array, newSize);
            return;
        }

        // 용적의 절반 미만으로 요소가 차지하는 경우
        if (size < (arrayCapcity / 2)){
            int newCapcity = arrayCapcity / 2;

            array = Arrays.copyOf(array, Math.max(DEFALULT_CAPCITY, newCapcity));
            return;
        }
    }

    @Override
    public E push(E item) {
        if (size == array.length){
            resize();
        }
        array[size] = item;
        size++;

        return item;
    }

    @Override
    public E pop() {
        if (size == 0){
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E element = (E) array[size - 1];
        array[size-1] = null;
        size--;
        resize();

        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return (E) array[size - 1];
    }

    @Override
    public int search(Object value) {

        /**
         * value 가 null인 경우 nullpointException 발생하여 따로 계산해준다.
         */
        if (value == null){
             for (int idx = size - 1; idx >= 0; idx--){
                 if (array[idx] == null){
                     return size - idx;
                 }
            }
        } else {
            for (int idx = size - 1; idx >= 0; idx--){
                if (array[idx].equals(value)){
                    return size - idx;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}
