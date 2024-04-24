/*
    Name: Sanjit Sathish
    PID:  A17804789
 */

import java.util.NoSuchElementException;

/**
 * TODO
 *
 * @author Sanjit
 * @since 2024
 */

public class CharQueue {
    private char[] circularArray;
    private int length;
    private int front;
    private int rear;

    public CharQueue() {
        circularArray = new char[5];
        length = 0;
        front = -1;
        rear = -1;
    }

    public CharQueue(int capacity) {
        if (capacity < 1){
            throw new IllegalArgumentException();
        }
        circularArray = new char[capacity];
        length = 0;
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        if (circularArray.length == 0){
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return length;
    }

    public void clear() {
        this.circularArray = new char[circularArray.length];
    }


    public void enqueue(char elem) {
        if (length == circularArray.length){
            char[] doubled = new char[length*2];
            for (int i = 0; i < length; i++){
                //edit this part of the code
                doubled[i] = circularArray[front];
            }
            circularArray = doubled;
        }
        if (front == -1){
            front = 0;
        }

        rear = (rear+1)%length;
        circularArray[rear] = elem;
    }

    public char peek() {
        if (length == 0){
            throw new NoSuchElementException();
        } else {
            return circularArray[front];
        }

    }

    public char dequeue() {
        if (length == 0) {
            throw new NoSuchElementException();
        } else {
            if (front == rear){
                front = -1;
                rear = -1;
            }

            char elem = circularArray[front];
            front = (front + 1) % 2;
            return elem;
        }
    }
}
