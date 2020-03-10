import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// ------------------------------------------------------------------------
// Solve the following 5 exercises using the five approaches.
// Examples and explanations of the five approaches can be found in Main.java.
// ------------------------------------------------------------------------

public class Exercises {
    private static List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,2,8,8,8));

    // ------------------------------------------------------------------------
    // Exercise I: multiply the elements in the list
    //
    // Thinking point:
    // Take note that there isn't a method using the map-reduce approach. Why?
    // ------------------------------------------------------------------------

    static int mul1 () {
        //for loop approach
        int mulFor=1;
        for(int i=0;i<ints.size();i++){
            int k=ints.get(i);
            mulFor=mulFor*k;
        }
        return mulFor;
    }

    static int mul2 () {
        //foreach approach
        int mulForeach=1;
        for(int k:ints){
            mulForeach=mulForeach*k;
        }
        return mulForeach;
    }

    static int mul3 () {
        //iterator approach
        ListIterator<Integer> iterator=ints.listIterator();
        int mulIterator=1;
        while(iterator.hasNext()){
            int k=iterator.next();
            mulIterator =mulIterator*k;
        }
        return mulIterator;
    }

    static int mul5 () {
	//reduce approach
        int mulReduce=ints.stream().reduce(1,(mul,k)->mul*k);
        return mulReduce;
    }

    // ------------------------------------------------------------------------
    // Exercise II: check if all elements in the list are even
    // ------------------------------------------------------------------------

    static boolean even1 () {
        //for loop approach
        int temp=0;
        for(int i=0;i<ints.size();i++){
            int k=ints.get(i);
            temp+=k%2;
        }
        if(temp==0)return true;
        else return false;
    }

    static boolean even2 () {
        //foreach approach
        int temp=0;
        for(int k:ints){
            temp+=k%2;
        }
        if(temp==0)return true;
        else return false;
    }

    static boolean even3 () {
        //iterator approach
        int temp=0;
        ListIterator<Integer> iterator=ints.listIterator();
        while(iterator.hasNext()){
            int k=iterator.next();
            temp+=k%2;
        }
        if(temp==0)return true;
        else return false;

    }

    static boolean even4 () {
	//map-reduce approach
        int temp=ints.stream().map(k->(k%2)).reduce(0,(sum,k)->sum+k);
        if (temp==0) return true;
        else return false;
    }

    static boolean even5 () {
	//reduce approach
        //int sumReduce = ints.stream().reduce(0, (sum,k) -> sum + k*k);
        int temp=ints.stream().reduce(0,(sum,k)->sum+k%2);
        if (temp==0) return true;
        else return false;
    }

    // ------------------------------------------------------------------------
    // Exercise III: compute the maximum number in the list
    //
    // Thinking point:
    // Take note that there isn't a method using the map-reduce approach. Why?
    // ------------------------------------------------------------------------

    static int max1 () {
        //for loop approach

        int maxFor=ints.get(0);
        for (int i=0; i<ints.size(); i++) {
            int k = ints.get(i);
            if(k>maxFor)
            maxFor=k;
        }
        return maxFor;
    }

    static int max2 () {
        //foreach approach
        int maxForeach = ints.get(0);
        for (int k : ints) {
            if(k>maxForeach) maxForeach = k;
        }
        return maxForeach;
    }

    static int max3 () {
        //iterator approach
        ListIterator<Integer> iterator = ints.listIterator();
        int maxIterator = ints.get(0);
        while (iterator.hasNext()) {
            int k = iterator.next();
            if(k>maxIterator) maxIterator = k;
        }

        return maxIterator;
    }

    static int max5 () {
	//reduce approach

        int maxReduce = ints.stream().reduce(ints.get(0), (max,k) ->  k>max? k : max);
        return maxReduce;
    }

    // ------------------------------------------------------------------------
    // Exercise IV: count occurrences of c in the list
    // ------------------------------------------------------------------------

    static int count1 (int c) {
        //for loop approach
        int countFor = 0;
        for (int i=0; i<ints.size(); i++) {
            int k = ints.get(i);
            if(k==c)countFor++;
        }

        return countFor;
    }

    static int count2 (int c) {
        //foreach approach
        int countForeach = 0;
        for (int k : ints) {
            if(k==c)countForeach++;
        }
        return countForeach;
    }

    static int count3 (int c) {
        //iterator approach
        ListIterator<Integer> iterator = ints.listIterator();
        int countIterator = 0;
        while (iterator.hasNext()) {
            int k = iterator.next();
            if(k==c)countIterator++;
        }
        return countIterator;
    }

    static int count4 (int c) {
	//map-reduce approach
        int countMapreduce = ints.stream().map(k -> k==c? 1:0).reduce(0, (count,k) -> count+ k);
        return 0;
    }

    static int count5 (int c) {
	//reduce approach
        int countReduce = ints.stream().reduce(0, (count,k) -> k==c? count + 1:count);
        return 0;
    }

    // ------------------------------------------------------------------------
    // Exercise V: triplicate each element in the list
    //
    // Thinking point:
    // Take note that there isn't a solution for this using the reduce approach. Why?
    // ------------------------------------------------------------------------
    
    static List<Integer> trip1 () {
        //for loop approach
        return new List<Integer>();
    }

    static List<Integer> trip2 () {
        //foreach approach
        return new List<Integer>();
    }

    static List<Integer> trip3 () {
        //iterator approach
        return new List<Integer>();
    }

    static List<Integer> trip4 () {
	//map-reduce approach
        List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,2,8,8,8));
        List<Integer> trips = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,2,8,8,8));
        return new List<Integer>();
    }

}
