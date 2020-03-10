import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    // create a test that ensures that each elementary statement of m is executed at least once
    public void m1() {
        assertEquals(50,Main.m(20,10));
    }

    @Test
    // create a test that ensures that each branch of m is executed at least once
    public void m2() {
	// below is an example of a test for m2
	// step through it and take note of what parts of the program is hits and doesn't hit
	// take note that this example test alone doesn't cover everything it should

        assertEquals(50,Main.m(20,10));
        //y<20 && x even

        assertEquals(20,Main.m(20,20));
        //y==20 && x even

    }

    @Test
    // create a test that ensures that each branch of m is executed at least once
    // and each condition is exercised at least once
    public void m3() {        
	// below is an example of a test for m3  
	// step through it and take note of what parts of the program is hits and doesn't hit
	// take note that this example test alone doesn't cover everything it should
	    assertEquals(-8,Main.m(21,10));
	    //y<20 && x odd

        assertEquals(50,Main.m(20,10));
        //y<20 && x even

        assertEquals(2,Main.m(1,20));
        //y>=20 && x odd

        assertEquals(20,Main.m(20,20));
        //y>=20 && x even
    }

    @Test
    // create a test that ensures that each path from start to end is executed at least once
    public void m4() {
	// below is an example of a test for m4  
	// step through it and take note of what parts of the program is hits and doesn't hit
	// take note that this example test alone doesn't cover everything it should
        assertEquals(0,Main.m(5,10));
        //skip loop && y<20 && x odd

        assertEquals(50,Main.m(10,10));

        assertEquals(50,Main.m(20,10));
        //

        assertEquals(20,Main.m(20,20));

	
    }


}
