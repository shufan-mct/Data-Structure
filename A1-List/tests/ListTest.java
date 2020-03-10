import org.junit.Test;

import static org.junit.Assert.*;

public class ListTest {
    List<Integer> a=new EmptyL();
    List<Integer> b=new NodeL(9,a);
    List<Integer> c=new NodeL(1,b);
    List<Integer> d=new NodeL(7, c);
    List<Integer> e=new NodeL(6, d);

    @Test
    public void isEmpty() {
        assert a.isEmpty()==true;
        assert b.isEmpty()==false;
    }

    @Test
    public void isSingleton() {
        assert a.isSingleton()==false;
        assert b.isSingleton()==true;
        assert c.isSingleton()==false;
    }

    @Test
    public void getFirst() throws EmptyListE{
        assert b.getFirst()==9;
        assert c.getFirst()==1;
        assert d.getFirst()==7;
    }

    @Test(expected = EmptyListE.class)
    public void getFirst1() throws Exception {
        assertEquals(new EmptyListE(),a.getFirst());
    }

    @Test
    public void getRest() throws EmptyListE{
        assert d.getRest()==c;
        assert e.getRest()==d;
    }

    @Test(expected = EmptyListE.class)
    public void getRest1() throws Exception {
        assertEquals(new EmptyListE(), a.getRest());
    }

    @Test
    public void get() throws EmptyListE{
        assert c.get(0)==1;
        assert e.get(3)==9;
    }

    @Test(expected = EmptyListE.class)
    public void get1() throws Exception {
        assertEquals(new EmptyListE(),a.get(5));
    }

    @Test
    public void length() {
        assertEquals(0, a.length());
        assert a.length()==0;
        assert b.length()==1;
        assert d.length()==3;
    }

    @Test
    public void append() throws EmptyListE{
        List<Integer> f= new NodeL(7,a);
        List<Integer> g= new NodeL(6,f);
        List<Integer> h= g.append(c);
        assert h.get(0)==6;
        assert h.get(1)==7;
        assert h.get(2)==1;
        assert h.get(3)==9;
    }

    @Test
    public void contains() {
        assert a.contains(5)==false;
        assert c.contains(1)==true;
        assert d.contains(6)==false;
    }
}