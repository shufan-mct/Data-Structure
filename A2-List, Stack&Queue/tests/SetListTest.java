import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SetListTest {
    private int len;
    private Random rand;
    private SetList<Integer> empty,one,many;

    @Before
    public void setUp() throws Exception {
        empty=new SetList();
        one=new SetList<>();
        one.add(75);
        many=new SetList<>();
        len=4999;
        rand=new Random(5);
        for(int i=0;i<len;i++){
            many.add(rand.nextInt());
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
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());
        one.clear();
        many.clear();
        assertTrue(one.isEmpty());
        assertTrue(many.isEmpty());
    }

    @Test
    public void isEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(one.isEmpty());
        assertFalse(many.isEmpty());
    }

    @Test
    public void add() {
        assertEquals(1,one.size());
        one.add(92);
        assertTrue(one.contains(92));
        assertEquals(2,one.size());
        one.add(75);
        assertEquals(2,one.size());
    }

    @Test(timeout = 10)
    public void addT(){
        for(int t=0;t<10;t++){
            many.add(rand.nextInt());
        }
    }

    @Test
    public void contains() {
        assertFalse(one.contains(92));
        assertTrue(one.contains(75));
    }

    @Test(timeout = 10)
    public void containsT(){
        for(int t=0;t<10;t++){
            many.contains(rand.nextInt());
        }
    }

    @Test
    public void size() {
        assertEquals(0,empty.size());
        assertEquals(1,one.size());
        assertEquals(4999,many.size());
    }
}