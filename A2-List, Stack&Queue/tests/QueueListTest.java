import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class QueueListTest {
    private QueueList<Integer> empty,one,many;
    private Random rand;
    private int len;

    @Before
    public void setUp() throws Exception {
        empty=new QueueList();
        one=new QueueList();
        one.offer(634);
        rand=new Random(8);
        many=new QueueList();
        len=4999;
        for(int i=0;i<len;i++){
            many.offer(rand.nextInt());
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

    @Test
    public void offer() throws NoSuchElementE {
        one.offer(970);
        one.remove();
        assertEquals((Integer) 970,one.poll());
    }

    @Test(timeout=10)
    public void offerT(){
        for(int t=0;t<10;t++){
            many.offer(rand.nextInt());
        }
    }

    @Test
    public void poll() throws NoSuchElementE{
        assertEquals((Integer) 634,one.poll());
        assertEquals(1,one.size());
    }

    @Test(expected = NoSuchElementE.class)
    public void pollE() throws NoSuchElementE{
        empty.poll();
    }

    @Test(timeout = 1)
    public void pollT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.poll();
        }
    }

    @Test
    public void remove() throws NoSuchElementE{
        assertEquals((Integer) 634,one.remove());
        assertEquals(0,one.size());
    }

    @Test(expected =NoSuchElementE.class)
    public void removeE() throws NoSuchElementE{
        empty.remove();
    }

    @Test(timeout = 1)
    public void removeT() throws NoSuchElementE{
        for(int t=0;t<100;t++){
            many.remove();
        }
    }

    @Test
    public void size() {
        assertEquals(0,empty.size());
        assertEquals(1,one.size());
        assertEquals(4999,many.size());
    }
}