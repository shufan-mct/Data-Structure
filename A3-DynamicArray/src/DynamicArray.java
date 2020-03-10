import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DynamicArray<E> implements StackI<E>, QueueI<E>, DequeI<E> {
    private Optional<E>[] elements;
    private int capacity, front, back, size;
    //
    // data stored in locations:
    // front+1, front+2, ... back-2, back-1 (all mod capacity)
    //
    // common cases:
    // front points to an empty location
    // back points to an empty location
    // adding to front decreases 'front' by 1
    // adding to back increases 'back' by 1
    // removing does the opposite
    //
    // |-------------------------|
    // | 4 5 6 _ _ _ _ _ _ 1 2 3 |
    // |-------------------------|
    //         /\        /\      /\
    //        back      front  capacity
    //

    @SuppressWarnings("unchecked")
    DynamicArray (int initialCapacity) {
        elements = (Optional<E>[]) Array.newInstance(Optional.class, initialCapacity);
        //create an array, and make sure type<E>
        Arrays.fill(elements, Optional.empty());
        //fill the array
        capacity = initialCapacity;
        front = capacity - 1;
        back = 0;
        size = 0;
    }

    // Complete the definitions of the following methods from the interfaces

    public void clear() {
        @SuppressWarnings("unchecked")
        Optional<E>[] newElements=(Optional<E>[]) Array.newInstance(Optional.class, 4);
        Arrays.fill(newElements,Optional.empty());
        front =3;
        back = 0;
        size = 0;
        capacity=4;
        elements=newElements;
    }

    public int size () {
        return size;
    }

    public void push(E item) {
        if(size==capacity)doublecapacity();
        elements[front]= Optional.of(item);
        front=Math.floorMod(front-1,capacity);
        size++;
    }
    //same as addFirst of deque

    public E peek() throws NoSuchElementE {
        try
        { E peek = elements[Math.floorMod(front + 1, capacity)].get();
            return peek; }
        catch (NoSuchElementException e){throw new NoSuchElementE();}
    }
    //same as getFirst of deque

    public E pop() throws NoSuchElementE {
        if (elements[Math.floorMod(front+1,capacity)].isPresent()) {
            E pop = elements[Math.floorMod(front+1, capacity)].get();
            front = Math.floorMod(front+1, capacity);
            elements[front] = Optional.empty();
            size--;
            return pop;
        }
        else {throw new NoSuchElementE();}
    }
    //same as removeFirst of deque
    //here we use another way to throw exceptions


    public void offer(E elem) {
        if(size==capacity)doublecapacity();
        elements[back]=Optional.of(elem);
        back=Math.floorMod(back+1,capacity);
        size++;
    }
    //same as addLast of deque

    public E poll() throws NoSuchElementE {
        if(elements[Math.floorMod(front+1,capacity)].isPresent())
        { E poll = elements[Math.floorMod(front + 1, capacity)].get();
            return poll; }
        else throw new NoSuchElementE();
    }
    //same as getFirst of deque

    public E remove() throws NoSuchElementE {

        if(elements[Math.floorMod(front+1,capacity)].isPresent())
        {   E remove = elements[Math.floorMod(front+1,capacity)].get();
            front=Math.floorMod(front+1,capacity);
            elements[front]=Optional.empty();
            size--;
            return remove; }
        else throw new NoSuchElementE();
    }
    //same as removeFirst of deque

    public void addFirst(E elem) {
        if (size==capacity) doublecapacity();
        elements[front]=Optional.of(elem);
        front=Math.floorMod(front-1,capacity);
        size++;
    }

    public void addLast(E elem) {
        if (size==capacity) doublecapacity();
        elements[back]=Optional.of(elem);
        back=Math.floorMod(back+1,capacity);
        size++;
    }

    public E getFirst() throws NoSuchElementE {
        try{ E gFirst=elements[Math.floorMod(front+1,capacity)].get();
        return gFirst;}
        catch (NoSuchElementException e){throw new NoSuchElementE();}
    }

    public E getLast() throws NoSuchElementE {
        try{E gLast=elements[Math.floorMod(back-1,capacity)].get();
        return gLast;}
        catch (NoSuchElementException e){throw new NoSuchElementE();}
    }

    public E removeFirst() throws NoSuchElementE {
        try{
        E rFirst= elements[Math.floorMod(front+1,capacity)].get();
        //notice the code order here. if exception happens, the front pointer shouldn't move
        front=Math.floorMod(front+1,capacity);
        elements[front]=Optional.empty();
        size--;
        return rFirst;}
        catch(NoSuchElementException e){throw new NoSuchElementE();}
    }

    public E removeLast() throws NoSuchElementE {
        try{ E rLast= elements[Math.floorMod(back-1,capacity)].get();
            back=Math.floorMod(back-1,capacity);
        elements[back]=Optional.empty();
        size--;
        return rLast;}
        catch (NoSuchElementException e){throw new NoSuchElementE();}
    }

    void doublecapacity(){
        //newElements
        //fill
        //copy old elements to new elements

        //loop from i=0; to capacity-1
        //newElements[i]=old elements front+1+i

        //set back and front
        //capacity=2 capacities
        @SuppressWarnings("unchecked")
        Optional<E>[] newElements = (Optional<E>[]) Array.newInstance(Optional.class,2*capacity);
        Arrays.fill(newElements,Optional.empty());

        for(int i=0;i<capacity;i++){
            newElements[i]=elements[Math.floorMod(front+1+i,capacity)];
        }
        front=capacity*2-1;
        back=capacity;
        capacity=capacity*2;
        elements=newElements;
    }

    //stack/queue: delegate to deque


    // the following methods are used for debugging and testing;
    // please do not edit them

    Optional<E>[] getElements () { return elements; }

    int getCapacity () { return capacity; }

    int getFront () { return front; }

    int getBack () { return back; }

}
