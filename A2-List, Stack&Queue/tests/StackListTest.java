import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StackListTest {
    private StackList<Integer> empty,one,many;
    private Random rand;
    private int len;

    @Before
    public void setUp() throws Exception {
        one=new StackList();
        one.push(3);
        empty=new StackList();

        rand = new Random(1);
        len = 4999;
        many = new StackList();
        for (int i=0; i<len; i++) {
            many.push(rand.nextInt());
        }
    }

    @After
    public void tearDown() throws Exception {
        one=null;
        empty=null;
        rand = null;
        len=0;
        many=null;
    }

    @Test
    public void clear() {
        one.clear();
        assertTrue(one.empty());
    }

    @Test(timeout=1)
    public void clearT() {
        for(int t=0;t<100;t++){
        many.clear();}
    }

    @Test
    public void empty() {
        assertFalse(one.empty());
        assertTrue(empty.empty());
    }

    @Test(timeout=1)
    public void emptyT() {
        for(int t=0;t<100;t++){
        many.empty();}
    }

    @Test
    public void peek() throws NoSuchElementE {
        assertEquals((Integer) 3,one.peek());
        assertFalse(one.empty());
    }

    @Test(expected=NoSuchElementE.class)
    public void peekE() throws NoSuchElementE {
        empty.peek();
    }

    @Test(timeout=1)
    public void peekT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.peek();}
    }

    @Test
    public void pop() throws NoSuchElementE{
        assertEquals((Integer)3,one.pop());
        assertTrue(one.empty());
    }

    @Test(expected=NoSuchElementE.class)
    public void popE() throws NoSuchElementE {
        empty.pop();
    }

    @Test(timeout=1)
    public void popT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.pop();}
    }

    @Test
    public void push() throws NoSuchElementE{
        one.push(5);
        assertEquals((Integer)5,one.peek());
    }

    @Test(timeout=1)
    public void pushT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.push(rand.nextInt());}
    }


    @Test
    public void size() {
       assertEquals(1,one.size());
       assertEquals(4999,many.size());
    }
}