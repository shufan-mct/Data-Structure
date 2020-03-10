import org.junit.Test;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.Random;

import static org.junit.Assert.*;

public class HashTableTest {
    @Test
    //test of insert, delete, search and rehash for separate chaining
    public void hashSeparateChaining () {
        Random r = new Random(1);
        HashFunction hf = new HashUniversal(r,31, 10);
        HashTable ht = new HashSeparateChaining(hf);
        ht.insert(1);
        ht.insert(12);
        assertTrue(ht.search(12));
        ht.delete(12);
        assertFalse(ht.search(12));
        assertTrue(ht.search(1));
        assertFalse(ht.search(2));
        ht.insert(22);
        System.out.println("Before rehashing");
        System.out.println(ht);
        ht.rehash();
        System.out.println("After rehashing");
        System.out.println(ht);
    }
    //should test get capacity, set capacity and to string for separate chaining in later tests

    @Test
    //another test of separate chain hashing table
    public void fig55 () {
        HashFunction hf = new HashMod(10);
        HashTable ht = new HashSeparateChaining(hf);
        ht.insert(0);
        ht.insert(81);
        ht.insert(64);
        ht.insert(49);
        ht.insert(9);
        ht.insert(36);
        ht.insert(25);
        ht.insert(16);
        ht.insert(4);
        ht.insert(1);
        System.out.println("Fig. 5.5");
        System.out.println(ht);
    }

    @Test
    //test of insert for linear probing
    public void fig511 () {
        HashFunction hf = new HashMod(10);
        HashTable ht = new HashLinearProbing(hf);
        ht.insert(89);
        ht.insert(18);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        System.out.println("Fig. 5.11");
        System.out.println(ht);

    }

    @Test
    //test of insert for quad probing
    public void fig513 () {
        HashFunction hf = new HashMod(10);
        HashTable ht = new HashQuadProbing (hf);
        //non linear try position, h+1,+4,+9,+16..
        ht.insert(89);
        ht.insert(18);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        System.out.println("Fig. 5.13");
        System.out.println(ht);
        ht.insert(26);
        ht.insert(72);
        ht.insert(95);
        System.out.println("Before rehashing");
        System.out.println(ht);
        ht.rehash();
        //h(x)=x%23
        System.out.println("After rehashing");
        System.out.println(ht);
    }

    @Test
    //test of insert for hash double
    public void fig518 () {
        HashFunction hf = new HashMod(10);
        HashFunction hf2 = new HashModThen(7, h -> 7 - h);
        HashTable ht = new HashDouble (hf, hf2);
        //h(key)+h'(key,0 attempt)
        ht.insert(89);
        ht.insert(18);
        ht.insert(49);
        //the HashModThan function we wrote takes the mod, here it rehashes which makes it different from the book.
        ht.insert(58);
        ht.insert(69);
        System.out.println("Fig. 5.18");
        System.out.println(ht);
    }

    @Test
    //test of get capacity, set capacity and to string for separate chaining
    public void hashSeparateCap () {
        HashFunction hf = new HashMod(13);
        HashTable ht = new HashSeparateChaining(hf);
        ht.insert(9);
        ht.insert(14);
        ht.insert(22);
        ht.insert(10);
        assertEquals(13,ht.getCapacity());
        System.out.println("Before setting a new bound");
        System.out.println(ht);
        ht.setCapacity(10);
        assertEquals(10,ht.getCapacity());
        System.out.println("After setting a new bound");
        System.out.println(ht);
    }

    @Test
    //test of get capacity, set capacity and to string for linear probing
    public void HashLinearProbingCap(){
        HashFunction hf = new HashMod(10);
        HashTable ht = new HashLinearProbing(hf);
        ht.insert(15);
        ht.insert(28);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        assertEquals(10,ht.getCapacity());
        System.out.println("Before setting a new bound");
        System.out.println(ht);
        ht.setCapacity(20);
        assertEquals(20,ht.getCapacity());
        System.out.println("After setting a new bound");
        System.out.println(ht);
    }

    @Test
    //test of delete, search with deleting for linear probing
    public void HashLinearProbingDel(){
        HashFunction hf = new HashMod(10);
        HashTable ht = new HashLinearProbing(hf);
        ht.insert(15);
        ht.insert(28);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        assertTrue(ht.search(15));
        assertFalse(ht.search(16));
        assertTrue(ht.search(58));
        assertTrue(ht.search(69));
        System.out.println("Before deleting");
        System.out.println(ht);
        ht.delete(58);
        assertFalse(ht.search(58));
        assertTrue(ht.search(69));
        //went through the "x" mark from deleting 58 and found 69
        System.out.println("Search after deleting");
        System.out.println(ht);
    }

    @Test
    //test of rehash manually for linear probing
    public void HashLinearProbingReh1(){
        HashFunction hf = new HashMod(7);
        HashTable ht = new HashLinearProbing(hf);
        assertEquals(7,ht.getCapacity());
        ht.insert(45);
        ht.insert(83);
        ht.insert(75);
        ht.insert(12);
        System.out.println("Before rehash");
        System.out.println(ht);
        ht.rehash();
        assertEquals(17,ht.getCapacity());
        System.out.println("After rehash");
        System.out.println(ht);
    }

    @Test
    //test of rehash automatically for linear probing
    public void HashLinearProbingReh2(){
        HashFunction hf = new HashMod(7);
        HashTable ht = new HashLinearProbing(hf);
        assertEquals(7,ht.getCapacity());
        ht.insert(15);
        ht.insert(28);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        ht.insert(93);
        ht.insert(75);
        assertEquals(7,ht.getCapacity());
        System.out.println("Before rehashing automatically");
        System.out.println(ht);
        ht.insert(62);
        ht.insert(75);
        assertEquals(17,ht.getCapacity());
        ht.insert(20);
        System.out.println("After rehashing automatically");
        System.out.println(ht);
    }

    @Test
    //test of get capability, set capability and to string for quad probing
    public void HashQuadProbingCap(){
        HashFunction hf=new HashModThen(7,h->7-h);
        HashTable ht=new HashQuadProbing(hf);
        ht.insert(4);
        ht.insert(9);
        ht.insert(1);
        assertEquals(7,ht.getCapacity());
        System.out.println("Before setting a new bound");
        System.out.println(ht);
        ht.setCapacity(17);
        assertEquals(17,ht.getCapacity());
        System.out.println("After setting a new bound");
        System.out.println(ht);
    }

    @Test
    //test of delete, search with deleting for quad probing
    public void HashQuadProbingDel(){
        HashFunction hf=new HashModThen(7,h->7-h);
        HashTable ht=new HashQuadProbing(hf);
        ht.insert(12);
        ht.insert(64);
        ht.insert(30);
        ht.insert(37);
        assertTrue(ht.search(12));
        assertTrue(ht.search(37));
        assertFalse(ht.search(7));
        System.out.println("Before deleting");
        System.out.println(ht);
        ht.delete(30);
        ht.delete(64);
        ht.delete(12);
        //went through the "x" mark from deleting 30,64,12 and found 37
        assertFalse(ht.search(12));
        assertTrue(ht.search(37));
        assertFalse(ht.search(2));
        System.out.println("Search after deleting");
        System.out.println(ht);
    }

    @Test
    //test of rehash manually for quad probing
    public void HashQuadProbingReh1(){
        HashFunction hf = new HashMod(5);
        HashTable ht = new HashLinearProbing(hf);
        assertEquals(5,ht.getCapacity());
        ht.insert(45);
        ht.insert(83);
        ht.insert(75);
        ht.insert(12);
        System.out.println("Before rehash");
        System.out.println(ht);
        ht.rehash();
        assertEquals(11,ht.getCapacity());
        System.out.println("After rehash");
        System.out.println(ht);
    }

    @Test
    //test of rehash automatically for linear probing
    public void HashQuadProbingReh2(){
        HashFunction hf = new HashMod(7);
        HashTable ht = new HashLinearProbing(hf);
        assertEquals(7,ht.getCapacity());
        ht.insert(17);
        ht.insert(21);
        ht.insert(49);
        ht.insert(58);
        ht.insert(99);
        ht.insert(93);
        ht.insert(70);
        assertEquals(7,ht.getCapacity());
        System.out.println("Before rehashing automatically");
        System.out.println(ht);
        ht.insert(62);
        ht.insert(75);
        assertEquals(17,ht.getCapacity());
        ht.insert(20);
        System.out.println("After rehashing automatically");
        System.out.println(ht);
    }

    @Test
    //test of get capacity and set capacity of hash double
    public void HashDoubleCap(){
        HashFunction hf = new HashMod(10);
        HashFunction hf2 = new HashModThen(7, h -> 8 - h);
        HashTable ht = new HashDouble (hf, hf2);
        ht.insert(78);
        ht.insert(35);
        ht.insert(11);
        ht.insert(7);
        ht.insert(83);
        ht.insert(26);
        assertEquals(10,ht.getCapacity());
        System.out.println("Before setting a new bound");
        System.out.println(ht);
        ht.setCapacity(9);
        assertEquals(9,ht.getCapacity());
        System.out.println("After setting a new bound");
        System.out.println(ht);
    }

    @Test
    //test of delete, search with deleting for linear probing
    public void HashDoubleDel(){
        HashFunction hf=new HashModThen(11,h->11-h);
        HashFunction hf2=new HashMod(5);
        HashTable ht=new HashDouble(hf,hf2);
        ht.insert(15);
        ht.insert(28);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        assertTrue(ht.search(15));
        assertFalse(ht.search(16));
        assertTrue(ht.search(58));
        assertTrue(ht.search(69));
        System.out.println("Before deleting");
        System.out.println(ht);
        ht.delete(58);
        assertFalse(ht.search(58));
        assertTrue(ht.search(69));
        //went through the "x" mark from deleting 58 and found 69
        System.out.println("Search after deleting");
        System.out.println(ht);
    }

    @Test
    //test of rehash manually for hash double
    public void HashDoubleReh1(){
        HashFunction hf = new HashMod(7);
        HashFunction hf2= new HashMod(5);
        HashTable ht = new HashDouble(hf,hf2);
        assertEquals(7,ht.getCapacity());
        ht.insert(45);
        ht.insert(83);
        ht.insert(75);
        ht.insert(12);
        System.out.println("Before rehash");
        System.out.println(ht);
        ht.rehash();
        assertEquals(17,ht.getCapacity());
        System.out.println("After rehash");
        System.out.println(ht);
    }

    @Test
    //test of rehash automatically for hash double
    public void HashDoubleReh2(){
        HashFunction hf = new HashMod(7);
        HashFunction hf2= new HashModThen(3,h->h-3);
        HashTable ht = new HashDouble(hf,hf2);
        assertEquals(7,ht.getCapacity());
        ht.insert(15);
        ht.insert(28);
        ht.insert(49);
        ht.insert(58);
        ht.insert(69);
        ht.insert(76);
        System.out.println("Before rehashing automatically");
        System.out.println(ht);
        ht.insert(3);
        assertEquals(17,ht.getCapacity());
        System.out.println("After rehashing automatically");
        System.out.println(ht);
    }



}