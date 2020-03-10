import org.junit.Test;

import static org.junit.Assert.*;

public class lab1Test {

    @Test
    public void getElementIndex() {
        int[] a={1,2,3,4,5,6};
        assert lab1.getElementIndex(a, 2)==1;
    }

    @Test
    public void getSubseqIndex() {
        int[] b={1,2,3,4,5,6};
        int[] c={2,3};
        assert lab1.getSubseqIndex(b,c)==1;

        int[] d={6,2,3,8,0,6};
        int[] e={2,3};
        assert lab1.getSubseqIndex(d,e)==1;
    }


}