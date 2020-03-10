
class EmptyListE extends Exception {}

abstract class List<E> {
    abstract boolean isEmpty ();
    abstract boolean isSingleton();
    abstract E getFirst() throws EmptyListE;
    abstract List<E> getRest() throws EmptyListE;
    abstract E get (int index) throws EmptyListE;
    abstract int length ();
    abstract List<E> append (List<E> other);
    abstract boolean contains (E elem);
}

class EmptyL<E> extends List<E> {

    boolean isEmpty(){
        return true;
    }

    boolean isSingleton(){
        return false;
    }

    E getFirst() throws EmptyListE{
        throw new EmptyListE();
    }

    List<E> getRest() throws EmptyListE{
        throw new EmptyListE();
    }

    E get (int index) throws EmptyListE{
        throw new EmptyListE();
    }

    int length(){
        return 0;
    }

    List<E> append(List<E> other) {
        return other;
    }

    boolean contains(E elem) {
        return false;
    }
} // to complete

class NodeL<E> extends List<E> {

    private E first;
    private List<E> rest=new EmptyL();

    NodeL(E first, List<E> rest){
        this.first=first;
        this.rest=rest;
    }

    boolean isEmpty(){
        return false;
    }

    boolean isSingleton() {
 //      if(rest.isEmpty()){
 //           return true;
 //       }
 //       else {
 //           return false;
 //       }

        return rest.isEmpty();
        }


    E getFirst() throws EmptyListE{
        return first;
    }

    List<E> getRest() throws EmptyListE{
        return rest;
    }

    E get(int index) throws EmptyListE{
 //       List<E> list=this;
 //       for(int temp=0; temp<index; temp++){
 //           list=list.getRest();
 //       }
 //       return list.getFirst();
        if (index==0) return first;
        else return rest.get(index-1);

    }

   int length () {
//       List<E> list=this;
//       int length=0;
//       for(int temp=0;!list.isEmpty();temp++){
//            try{list=list.getRest();}
//            catch(EmptyListE e){}
//            length++;
//        }
//       return length;
       return 1 + rest.length();
   }

    List<E> append (List<E> other){
 //       try {
 //           for (int pointer = this.length() - 1; pointer >= 0; pointer--) {
 //               other = new NodeL(this.get(pointer), other);
 //           }
 //       }catch (EmptyListE e){}
 //       return other;

        return new NodeL<>(first,rest.append(other));
    }

    boolean contains(E elem) {
        boolean con=false;
        try {
            for (int pointer = 0; pointer < this.length(); pointer++) {
                if (this.get(pointer) == elem) {
                    con = true;
                    break;
                }
            }
        }catch(EmptyListE e){}
        return con;

    }
} // to complete
