public class lab1 {
    public static int getElementIndex(int[] list, int e) {
        int i = -1;
        for (int x = 0; x < list.length; x++) {
            if ( list[x]==e){
                i= x;
            }
        }
        return i;
    }

    public static int getSubseqIndex(int[] list, int[] e) {
        int j=-1;
        boolean state=true;
        for (int y = 0; y < list.length; y++){
            if (list[y]==e[0]){
                j=y;
                state=true;
                for (int z=1;z< e.length; z++){
                    if(y+z>=list.length){state=false;break;}
                    if(list[y+z]!=e[z]){state=false;
                    break;}
                    else{state=true;}
                }
            }
        }
        if (state=false)
            return -1;
        else return j;
    }

}
