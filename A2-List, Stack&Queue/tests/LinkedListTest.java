import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> empty,one,many;
    private Random rand;
    private int len;

    @Before
    public void setUp() throws Exception {
        one=new LinkedList<>();
        one.addFirst(3);
        empty=new LinkedList<>();

        rand = new Random(1);
        len = 4999;
        many = new LinkedList<>();
        for (int i=0; i<len; i++) {
            many.addFirst(rand.nextInt());
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
        many.clear();
        assertEquals(0,one.size());
        assertEquals(0,many.size());
    }

    @Test(timeout = 1)
    public void clearT() {
        for(int t=0;t<100;t++){
            many.clear();
        }
    }

    @Test
    public void size() {
        assertEquals(1,one.size());
        assertEquals(0,empty.size());
        assertEquals(4999,many.size());
    }

    @Test
    public void addFirst()throws NoSuchElementE {
        one.addFirst(190);
        many.addFirst(187);
        assertEquals((Integer) 190,one.getFirst());
        assertEquals((Integer) 187,many.getFirst());
    }

    @Test(timeout=1)
    public void addFirstT(){
        for(int t=0;t<100;t++){
            many.addFirst(rand.nextInt());
        }
    }

    @Test
    public void addLast() throws NoSuchElementE{
        one.addLast(190);
        assertEquals((Integer) 190,one.getLast());
        many.addLast(187);
        assertEquals((Integer)187,many.getLast());
    }

    @Test(timeout=10)
    public void addLastT(){
        for(int t=0;t<10;t++){
            many.addLast(rand.nextInt());
        }
    }

    @Test
    public void getFirst() throws NoSuchElementE{
        assertEquals((Integer)3,one.getFirst());
        many.getFirst();
        assertEquals(4999,many.size());
    }

    @Test(expected = NoSuchElementE.class)
    public void getFirstE()throws NoSuchElementE{
        empty.getFirst();
    }

    @Test(timeout = 1)
    public void getFirstT() throws NoSuchElementE{
        for(int t=0;t<100;t++) {
            many.getFirst();
        }
    }

    @Test
    public void getLast() throws NoSuchElementE{
        assertEquals((Integer) 3,one.getLast());
        assertEquals(1,one.size());
    }

    @Test(expected = NoSuchElementE.class)
    public void getLastE() throws NoSuchElementE{
        empty.getLast();
    }

    @Test(timeout = 10)
    public void getLastT() throws NoSuchElementE{
        for(int t=0;t<10;t++){
            many.getLast();
        }
    }

    @Test
    public void removeFirst() throws NoSuchElementE{
        assertEquals((Integer) 3,one.removeFirst());
        assertEquals(0,one.size());
    }

    @Test(expected=NoSuchElementE.class)
    public void removeFirstE() throws NoSuchElementE{
        empty.removeFirst();
    }

    @Test(timeout = 1)
    public void removeFirstT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.removeFirst();
        }
    }
}