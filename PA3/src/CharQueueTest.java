import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CharQueueTest {

    @Test
    public void constructor(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CharQueue test = new CharQueue(0);
        });
    }

    @Test
    public void isEmptyTest(){
        CharQueue test = new CharQueue();
        assertEquals(true, test.isEmpty());
        test.enqueue('a');
        assertEquals(false, test.isEmpty());
        test.dequeue();
        assertEquals(true, test.isEmpty());
    }

    @Test
    public void sizeTest(){
        CharQueue test = new CharQueue();
        assertEquals(0, test.size());
        test.enqueue('a');
        assertEquals(1, test.size());
        test.dequeue();
        assertEquals(0, test.size());
    }

    @Test
    public void clearTest(){
        CharQueue test = new CharQueue();
        test.enqueue('a');
        test.clear();
        assertEquals(0, test.size());
        test.clear();
        assertEquals(0, test.size());
        test.enqueue('a');
        test.enqueue('b');
        test.enqueue('c');
        test.clear();
        assertEquals(0, test.size());
    }

    @Test
    public void enqueueTest(){
        CharQueue test = new CharQueue();
        test.enqueue('a');
        assertEquals('a', test.peek());
        test.enqueue('b');
        assertEquals('b', test.peek());
        test.enqueue('c');
        assertEquals('c', test.peek());
    }

    @Test
    public void peekTest(){
        CharQueue test = new CharQueue();
        test.enqueue('a');
        test.enqueue('b');
        test.enqueue('c');
        assertEquals('a', test.peek());
        test.dequeue();
        assertEquals('b', test.peek());
        test.dequeue();
        assertEquals('c', test.peek());
        test.dequeue();
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            test.peek();
        });

    }

    @Test
    public void dequeueTest(){
        CharQueue test = new CharQueue();
        test.enqueue('a');
        test.enqueue('b');
        char elem = test.dequeue();
        assertEquals('a', test.peek());
        assertEquals('b', elem);
        assertEquals('a', test.dequeue());

    }

}