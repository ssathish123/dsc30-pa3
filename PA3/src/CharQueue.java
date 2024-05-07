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

    /**
     * This creates a CHarQueue object. The default size
     * of the circular array is 5.
     */
    public CharQueue() {
        circularArray = new char[5];
        length = 0;
        front = 0;
        rear = 0;
    }
    /**
     * This creates a CHarQueue object.
     * @param capacity determines the size of capaciy
     */
    public CharQueue(int capacity) throws IllegalArgumentException{
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        circularArray = new char[capacity];
        length = 0;
        front = 0;
        rear = 0;
    }

    /**
     * This checks if the queue is empty. It will return true
     * if it is empty
     * @param: None
     *
     */
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This returns the size of the queue. It will return
     * the length variable.
     * @param: None
     */
    public int size() {
        return length;
    }

    /**
     * This method clears the queue. It returns the
     * queue to all of its default settings.
     * @param: None
     */
    public void clear() {
        circularArray = new char[circularArray.length];
        length = 0;
        front = 0;
        rear = 0;
    }

    /**
     * This method enqueus and adds an element to the front
     * of the queue. It updates the length and rear variables
     * to match the enqueue.
     * @param elem : This is the element that wants to be added.
     */
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

    /**
     * This returns the element at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     * @return circularArray[front] gives the first element.
     */
    public char peek() throws NoSuchElementException{
        if (length == 0) {
            throw new NoSuchElementException();
        } else {
            return circularArray[front];
        }

    }
    /**
     * This method removes an element from the front of the
     * queue and it returns it. It changes the front pointer.
     * @throws NoSuchElementException if the queue is empty.
     * @return the dequeeud element
     */
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
