import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class QueueTwoStacksTest {
    //    private QueueTwoStacks<Integer> emptyQ,onefQ,onebQ,manyQ;
//    private StackList<Integer> emptySL1,emptySL2,emptySL3,emptySL4,onefSL,onebSL,manySL1,manySL2;
    private QueueTwoStacks<Integer> empty, one, many;
    //    private Random rand1,rand2;
    private int len;
    private Random rand;

    @Before
    public void setUp() throws Exception {
        len = 2500;
//        rand1=new Random(6);
        rand = new Random(6);
//        rand2=new Random(8);
//        emptySL1=new StackList<Integer>();
//        emptySL2=new StackList<Integer>();
//        emptySL3=new StackList<Integer>();
//        emptySL4=new StackList<Integer>();
//        onefSL=new StackList<Integer>();
//        onefSL.push(402);
//        onebSL=new StackList<Integer>();
//        onebSL.push(694);
//        manySL1=new StackList<Integer>();
//        for(int i=0;i<len;i++){
//            manySL1.push(rand1.nextInt());
//        }
//        manySL2=new StackList<Integer>();
//        for(int i=0;i<len;i++){
//            manySL2.push(rand2.nextInt());
//        }
//
//        emptyQ=new QueueTwoStacks<Integer>(emptySL1,emptySL2);
        empty = new QueueTwoStacks<Integer>();
//        onefQ=new QueueTwoStacks<Integer>(onefSL,emptySL3);
        one = new QueueTwoStacks<Integer>();
        one.offer(81);
        many = new QueueTwoStacks<Integer>();
        for (int t = 0; t < len; t++) {
            many.offer(rand.nextInt());
        }
//        onebQ=new QueueTwoStacks<Integer>(emptySL4,onebSL);
//        manyQ=new QueueTwoStacks<Integer>(manySL1,manySL2);

    }

    @After
    public void tearDown() throws Exception {
        len = 0;
        empty = null;
        one = null;
        many = null;
        rand = null;
/*        rand1=null;
        rand2=null;
        emptySL1=null;
        emptySL2=null;
        emptySL3=null;
        emptySL4=null;
        onefSL=null;
        onebSL=null;
        manySL1=null;
        manySL2=null;
        emptyQ=null;
        onefQ=null;
        onebQ=null;
        manyQ=null;*/
    }

    @Test
    public void clear() {
/*        assertEquals(1,onefQ.size());
        assertEquals(1,onebQ.size());
        assertEquals(5000,manyQ.size());
        onefQ.clear();
        onebQ.clear();
        manyQ.clear();
        assertEquals(0,onefQ.size());
        assertEquals(0,onebQ.size());
        assertEquals(0,manyQ.size());*/
        assertEquals(1, one.size());
        assertEquals(2500, many.size());
        one.clear();
        many.clear();
        assertEquals(0, one.size());
        assertEquals(0, many.size());
    }

    @Test
    public void offer() throws NoSuchElementE {
//        onefQ.offer(713);
//        onefQ.remove();
//        assertEquals((Integer) 713,onefQ.poll());
//        onebQ.offer(583);
//        onebQ.remove();
//        assertEquals((Integer) 583,onebQ.poll());

        one.offer(713);
        one.remove();
        assertEquals((Integer) 713, one.poll());
    }

    @Test(timeout = 1)
    public void offerT() {
/*        for(int t=0;t<100;t++){
            manyQ.offer(rand1.nextInt());
        }*/
        for (int t = 0; t < 100; t++) {
            many.offer(rand.nextInt());
        }
    }

    @Test
    public void poll() throws NoSuchElementE {
/*        assertEquals((Integer) 402,onefQ.poll());
        assertEquals((Integer) 694,onebQ.poll());
        assertEquals(1,onefQ.size());
        assertEquals(1,onebQ.size());*/
        assertEquals((Integer) 81, one.poll());
        assertEquals(1, one.size());
    }

    @Test(expected = NoSuchElementE.class)
    public void pollE1() throws NoSuchElementE {
        /*        emptyQ.poll();*/
        empty.poll();
    }

/*    @Test(expected = NoSuchElementE.class)
    public void pollE2() throws NoSuchElementE{*//*
        onefQ.remove();
        onefQ.poll();*//*
    }*/

    @Test(timeout = 1)
    public void pollT() throws NoSuchElementE {

/*        for(int t=0;t<100;t++) {
            manyQ.poll();
        }*/
        for (int t = 0; t < 100; t++) {
            many.poll();
        }
    }


    @Test
    public void remove() throws NoSuchElementE {/*
        assertEquals((Integer) 402,onefQ.remove());
        assertEquals((Integer) 694,onebQ.remove());
        assertEquals(0,onefQ.size());
        assertEquals(0,onebQ.size());*/
        assertEquals((Integer) 81, one.remove());
        assertEquals(0, one.size());
    }

    @Test(expected = NoSuchElementE.class)
    public void removeE() throws NoSuchElementE {
        /*        emptyQ.remove();*/
        empty.remove();
    }

    @Test(timeout = 1)
    public void removeT() throws NoSuchElementE {
        /*        for(int t=0;t<100;t++){
            manyQ.remove();}*/
        for (int t = 0; t < 100; t++) {
            many.remove();
        }
    }


    @Test
    public void size() {
/*        assertEquals(0,emptyQ.size());
        assertEquals(1,onefQ.size());
        assertEquals(1,onebQ.size());
        assertEquals(5000,manyQ.size());*/
        assertEquals(0,empty.size());
        assertEquals(1,one.size());
        assertEquals(2500,many.size());
    }
}
