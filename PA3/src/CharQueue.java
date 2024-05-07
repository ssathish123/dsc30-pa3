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
        front = 0;
        rear = 0;
    }

    public CharQueue(int capacity) throws IllegalArgumentException{
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        circularArray = new char[capacity];
        length = 0;
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return length;
    }

    public void clear() {
        circularArray = new char[circularArray.length];
        length = 0;
        front = 0;
        rear = 0;
    }


    public void enqueue(char elem) {
        if (length == circularArray.length) {
            char[] doubled = new char[length * 2];
            for (int i = 0; i < length; i++) {
                //edit this part of the code
                doubled[i] = circularArray[front];
            }
            circularArray = doubled;
        }

        circularArray[rear] = elem;
        rear = (rear + 1) % circularArray.length;
        length += 1;
    }

    public char peek() throws NoSuchElementException{
        if (length == 0) {
            throw new NoSuchElementException();
        } else {
            return circularArray[front];
        }

    }

    public char dequeue() throws NoSuchElementException{
        if (length == 0) {
            throw new NoSuchElementException();
        }

        char elem = circularArray[front];
        circularArray[front] = '\u0000';

        front = (front + 1) % circularArray.length;
        length -= 1;

        return elem;

    }
}
