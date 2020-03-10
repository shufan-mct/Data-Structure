import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DequeListTest {
    private int len;
    private Random rand;
    private DequeList<Integer> empty,one,many;

    @Before
    public void setUp() throws Exception {
        empty=new DequeList<>();
        one=new DequeList<>();
        one.addFirst(362);
        len=4999;
        rand=new Random(8);
        many=new DequeList<>();
        for(int i=0;i<len;i++){
            many.addFirst(rand.nextInt());
        }
    }

    @After
    public void tearDown() throws Exception {
        empty=null;
        one=null;
        many=null;
        rand=null;
        len=0;
    }

    @Test
    public void clear() {
        assertEquals(1,one.size());
        assertEquals(4999,many.size());
        one.clear();
        many.clear();
        assertEquals(0,one.size());
        assertEquals(0,many.size());
    }

    @Test(timeout = 1)
    public void clearT(){
        for(int t=0;t<100;t++){
            many.clear();
        }
    }

    @Test
    public void addFirst() throws NoSuchElementE{
        empty.addFirst(923);
        assertEquals((Integer) 923,empty.getLast());
    }

    @Test(timeout = 1)
    public void addFirstT(){
        for(int t=0;t<100;t++){
            many.addFirst(rand.nextInt());
        }
    }

    @Test
    public void addLast() throws NoSuchElementE{
        empty.addLast(1);
        assertEquals((Integer) 1,empty.getFirst());
    }

    @Test(timeout = 10)
    public void addLastT() {
        for(int t=0;t<10;t++){
            many.addLast(rand.nextInt());
        }
    }

    @Test
    public void getFirst() throws NoSuchElementE{
        assertEquals((Integer) 362,one.getFirst());
        assertEquals(1,one.size());
    }

    @Test(expected = NoSuchElementE.class)
    public void getFirstE() throws NoSuchElementE{
        empty.getFirst();
    }

    @Test(timeout = 1)
    public void getFirstT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.getFirst();
        }
    }

    @Test
    public void getLast() throws NoSuchElementE{
        assertEquals((Integer) 362,one.getLast());
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
    public void size() {
        assertEquals(0,empty.size());
        assertEquals(1,one.size());
        assertEquals(4999,many.size());
    }
}