import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> d,many;
    private Random rand;
    private int len;

    @Before
    public void setUp() throws Exception {
        d = new DynamicArray<>(5);
        many = new DynamicArray<>(5);
        rand=new Random(17);
        len=4999;
        for(int i=0;i<len;i++){many.addFirst(rand.nextInt());}

    }

    @After
    public void tearDown() throws Exception {
        d = null;
        many=null;
        rand=null;
        len=0;
    }

    //
    //
    //
    //Test for Deque methods
    //
    //
    //

    @Test
    public void clear() {
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        assertEquals(3, d.size());
        d.clear();
        assertEquals(0,d.size());
        assertEquals(5,d.getCapacity());
        //test for clear of deque, stack and queue
    }

    @Test(expected = NoSuchElementE.class)
    public void clearEmpty() throws NoSuchElementE{
        assertEquals(0, d.size());
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        assertEquals(3, d.size());
        d.clear();
        assertEquals(0,d.size());
        assertEquals(5,d.getCapacity());
        d.getLast();
    }

    @Test(timeout = 1)
    public void clearT(){
        for(int t=0;t<100;t++){many.clear();}
        //complexity test for clear of deque, stack and queue
    }


    @Test
    public void size() {
        assertEquals(0, d.size());
        assertEquals(4999,many.size());
    }

    @Test(timeout = 1)
    public void sizeT(){
        for(int t=0;t<100;t++){many.size();};
    }

    @Test
    public void dequeNoResize() throws NoSuchElementE {
        assertEquals(0, d.size());
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        assertEquals(3, d.size());
        assertEquals(3, (int) d.getFirst());
        assertEquals(3, (int) d.removeFirst());
        assertEquals(1, (int) d.getLast());
        assertEquals(1, (int) d.removeLast());
        assertEquals(2, (int) d.removeLast());
        assertEquals(0, d.size());
        d.addLast(1);
        d.addLast(2);
        d.addFirst(3);
        d.addLast(4);
        d.addFirst(5);
        assertEquals(5, d.size());
        assertEquals(5, (int) d.removeFirst());
        assertEquals(3, (int) d.removeFirst());
        assertEquals(1, (int) d.removeFirst());
        assertEquals(2, (int) d.removeFirst());
        assertEquals(4, (int) d.removeFirst());
        //addFirst, addLast, getFirst, getLast, removeFirst and removeLast for Deque also checked
    }

    @Test
    public void dequeResize() throws NoSuchElementE {
        d.addLast(1);
        d.addLast(2);
        d.addFirst(3);
        d.addLast(4);
        d.addFirst(5);
        d.addFirst(6);
        assertEquals(10, d.getCapacity());
        assertEquals(8,d.getFront());
        assertEquals(5,d.getBack());
        assertEquals(6,d.size());
        assertEquals(6, (int) d.removeFirst());
        assertEquals(5, (int) d.removeFirst());
        assertEquals(3, (int) d.removeFirst());
        assertEquals(1, (int) d.removeFirst());
        assertEquals(2, (int) d.getFirst());
        assertEquals(2, (int) d.removeFirst());
        assertEquals(4, (int) d.getLast());
        assertEquals(4, (int) d.removeLast());
        //pointer Front and back,capacity for Deque also checked
    }

    @Test(timeout=1)
    public void addFirstT(){
        for(int t=0;t<100;t++){
            many.addFirst(rand.nextInt());
        }
        //complexity test for deque addFirst, stack push
    }

    @Test(timeout=1)
    public void addLastT(){
        for(int t=0;t<100;t++){
            many.addLast(rand.nextInt());
        }
        //complexity test for deque addLast, queue offer
    }

    @Test(timeout=1)
    public void getFirstT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.getFirst();
        }
        //complexity test for deque getFirst, stack peek and queue poll
    }

    @Test(timeout=1)
    public void getLastT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.getLast();
        }
    }

    @Test(timeout=1)
    public void removeFirstT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.removeFirst();
        }
        //complexity test for deque removeFirst, stack pop and queue remove
    }

    @Test(timeout=1)
    public void removeLastT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.removeLast();
        }
    }

    @Test(expected = NoSuchElementE.class)
    public void getFirstE() throws NoSuchElementE{
        d.getFirst();
    }

    @Test(expected = NoSuchElementE.class)
    public void getLastE() throws NoSuchElementE{
        d.getLast();
    }

    @Test(expected = NoSuchElementE.class)
    public void removeFirstE() throws NoSuchElementE{
        d.removeFirst();
    }

    @Test(expected = NoSuchElementE.class)
    public void removeLastE() throws NoSuchElementE{
        d.removeLast();
    }

    //
    //
    //
    //Test for Stack methods
    //
    //
    //

    @Test
    public void stackNoResize() throws NoSuchElementE {
        assertEquals(0, d.size());
        d.push(1);
        d.push(2);
        d.push(3);
        assertEquals(3, d.size());
        assertEquals(3, (int) d.peek());
        assertEquals(3, (int) d.pop());
        assertEquals(2, (int) d.peek());
        assertEquals(2, (int) d.pop());
        assertEquals(1, (int) d.pop());
        assertEquals(0, d.size());
        //push,peek and pop of stack also checked
    }

    @Test
    public void stackResize() throws NoSuchElementE {
        d.push(1);
        d.push(2);
        d.push(3);
        d.push(4);
        d.push(5);
        d.push(6);
        assertEquals(6,d.size());
        assertEquals(6, (int) d.pop());
        assertEquals(5, (int) d.pop());
        assertEquals(4, (int) d.pop());
        assertEquals(3, (int) d.pop());
        assertEquals(2, (int) d.pop());
        assertEquals(1, (int) d.pop());
        assertEquals(0,d.size());
    }


    @Test(expected = NoSuchElementE.class)
    public void peekE() throws NoSuchElementE{
        d.peek();
    }

    @Test(expected = NoSuchElementE.class)
    public void popE() throws NoSuchElementE{
        d.pop();
    }

    //
    //
    //
    //Test for Queue methods
    //
    //
    //

    @Test
    public void queueNoResize() throws NoSuchElementE {
        assertEquals(0, d.size());
        d.offer(3);
        d.offer(2);
        d.offer(1);
        assertEquals(3, d.size());
        assertEquals(3, (int) d.poll());
        assertEquals(3, (int) d.remove());
        assertEquals(2, (int) d.poll());
        assertEquals(2, (int) d.remove());
        assertEquals(1, (int) d.remove());
        assertEquals(0, d.size());
        //offer,poll and remove of stack also checked
    }

    @Test
    public void queueResize() throws NoSuchElementE {
        d.offer(6);
        d.offer(5);
        d.offer(4);
        d.offer(3);
        d.offer(2);
        d.offer(1);
        assertEquals(6,d.size());
        assertEquals(6, (int) d.remove());
        assertEquals(5, (int) d.remove());
        assertEquals(4, (int) d.remove());
        assertEquals(3, (int) d.remove());
        assertEquals(2, (int) d.remove());
        assertEquals(1, (int) d.remove());
        assertEquals(0,d.size());
    }


    @Test(expected = NoSuchElementE.class)
    public void pollE() throws NoSuchElementE{
        d.poll();
    }

    @Test(expected = NoSuchElementE.class)
    public void removeE() throws NoSuchElementE{
        d.remove();
    }





}
