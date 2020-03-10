import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;

class LineWrap {
  private int lineWidth;

  LineWrap (int lineWidth) {
      this.lineWidth = lineWidth;
  }

  //-------------------------------------------------------------------------
  /**
   * The greedy implementation keeps consuming words from the given list
   * of words while keeping track of how much space is left on the current line.
   * If the current word with a preceding space would fit on the current line, the
   * algorithm continues with the remaining words and an adjusted space.
   * If the word preceded by a space does not fit on the current line, a new line
   * is inserted instead and the algorithm continues with the rest of the words and
   * an adjusted space.
  */
  String greedy (List<String> words, int space) throws NoSuchElementE {
      String wordsWrap="";
      try
      {
          String wf = words.getFirst();
          if (wf.length() < space)
          {
              space = space - 1 - wf.length();
              wordsWrap = wordsWrap + " " + wf;
          }
          else
          {
              space = lineWidth - wf.length();
              wordsWrap = wordsWrap + "\n" + wf;
          }
          wordsWrap=wordsWrap+greedy(words.getRest(),space);
      }
      catch (NoSuchElementE e){return"";}
      return wordsWrap;
  }

  /**
   * A simple way of running the greedy algorithm
   */
  static String runGreedy (String s, int lineWidth) throws NoSuchElementE {
        List<String> words = List.fromArray(s.split("\\s"));
        LineWrap wrap = new LineWrap(lineWidth);
        String w = words.getFirst();
        String para = w + wrap.greedy(words.getRest(), lineWidth - w.length());
        return para;
    }

  //-------------------------------------------------------------------------

  /** A hash table for use with the top down dynamic programming solution */
  static Map<Pair<List<String>,Integer>,Pair<String,Integer>> hash = new HashMap<>();


  /**
   * The greedy algorithm always adds words to the current line as long as they
   * would fit. The dynamic programming algorithm instead considers two options
   * for each word: add it to the current line, or insert a new line before
   * the word. For each possibility, an estimate of "badness" is calculated
   * and the best option is chosen. The "badness" of a solution is the sum
   * of the cubes of the amount of space left on each line (except the last line).
   * For example, if the line width is 6 and we have the following text:
   *
   * 1234
   * 12 45
   * 123
   * 12
   *
   * then we calculate the badness as follows: the first line has 2 unused spaces
   * at the end, the next line has 1, and the third has 3. The final line is perfect
   * by definition. So the "badness" estimate is:
   * 2^3 + 1^3 + 3^3 = 8 + 1 + 27 = 36
   *
   * In contrast if the text was:
   *
   * 1234
   * 12 45
   * 123 12
   *
   * the "badness" would be: 2^3 + 1^3 = 8 + 1 = 9
   *
   * so we prefer the second arrangement.
   *
   * I strongly suggest you first write a plain recursive solution and test it on the small
   * example (test1). Once that words properly, you can add the hash table management to
   * get your final dynamic programming solution. Without the hash table, the algorithm
   * will really not work on even a moderate size paragraph.
  */
  Pair<String,Integer> dpTD(List<String> words, int space) {
/*      String wordsWrap="";
      int badness=0,badnessStay=0,badnessNew=0;
      if (hash.containsKey(new Pair<List<String>,Integer>(words,space)))
      {
          return hash.get(new Pair<List<String>,Integer>(words,space));
      }
      else{
      try{

              String wf = words.getFirst();
              if (wf.length() < space)
              {
                  badnessStay=dpTD(words.getRest(),space-1 - wf.length()).getSnd();
                  badnessNew=space*space*space+dpTD(words.getRest(),lineWidth - wf.length()).getSnd();
                  if(badnessStay<=badnessNew){
                      wordsWrap=wordsWrap+" "+wf;
                      space=space-1 - wf.length();
                      badness=badness+badnessStay;
                  }
                  else {
                      wordsWrap=wordsWrap+"\n"+wf;
                      space=lineWidth-wf.length();
                      badness=badness+badnessNew;
                  }


              }
              else {
                  wordsWrap = wordsWrap + "\n" + wf;
                  badness=badness+space*space*space+dpTD(words.getRest(),lineWidth - wf.length()).getSnd();
                  space = lineWidth - wf.length();
              }
              wordsWrap=wordsWrap+dpTD(words.getRest(),space).getFst();
      }
      catch (NoSuchElementE e){}
      hash.put(new Pair<List<String>,Integer>(words,space),new Pair<String,Integer>(wordsWrap,badness));

      return new Pair<String,Integer>(wordsWrap,badness);}*/


      String wordsWrap="";
      int badness=0,badnessStay=0,badnessNew=0;
      int initialSpace=space;
      if (hash.containsKey(new Pair<List<String>,Integer>(words,space)))
      {
          return hash.get(new Pair<List<String>,Integer>(words,space));
      }
      else
      {
          try
          {

              String wf = words.getFirst();
              if (wf.length() < space)
              {
                  badnessStay=dpTD(words.getRest(),space - 1 - wf.length()).getSnd();
                  badnessNew=space*space*space+dpTD(words.getRest(),lineWidth - wf.length()).getSnd();
                  if(badnessStay<badnessNew)
                  {
                      wordsWrap=wordsWrap+" "+wf;
                      space=space - 1 - wf.length();
                      badness=badness+badnessStay;
                  }
                  else
                  {
                      wordsWrap=wordsWrap+"\n"+wf;
                      space=lineWidth-wf.length();
                      badness=badness+badnessNew;
                  }

              }
              else
              {
                  wordsWrap =wordsWrap+ "\n" + wf;
                  badness=badness+space*space*space+dpTD(words.getRest(),lineWidth - wf.length()).getSnd();
                  space = lineWidth - wf.length();
              }
              wordsWrap=wordsWrap+dpTD(words.getRest(),space).getFst();
              hash.put(new Pair<List<String>,Integer>(words,initialSpace),new Pair<String,Integer>(wordsWrap,badness));
          }
          catch (NoSuchElementE e){return new Pair<String,Integer>("",0);}

          return new Pair<String,Integer>(wordsWrap,badness);
      }

  }


  /**
   * A simple way of running the dynamic programming algorithm
   */
  static String runDP (String s, int lineWidth) throws NoSuchElementE {
      //hash = new WeakHashMap<>();
      List<String> words = List.fromArray(s.split("\\s"));
      LineWrap wrap = new LineWrap(lineWidth);
      String w = words.getFirst();
      Pair<String, Integer> sub = wrap.dpTD(words.getRest(), lineWidth - w.length());
      String para = w + sub.getFst();
      System.out.printf("%s\n",sub.getSnd());
      return para;
  }

    //-------------------------------------------------------------------------

  /**
   * Here you are to implement the dynamic programming algorithm in a bottom-up fashion.
   * You should still use a hash table as shown below but its management is done
   * "manually" not implicitly when entering / exiting recursive calls.
   */
  static String dpBU (String s, int lineWidth) {
      Map<Pair<Integer,Integer>,Pair<String,Integer>> hash = new HashMap<>();
      String[] words=s.split("\\s");
      int n=words.length;
      LineWrap wrap = new LineWrap(lineWidth);
      int space=0,spaceNew=0,spaceStay=0;

      for(int i=0;i<=words[n-1].length();i++)
      {
          hash.put(new Pair(n - 1, i), new Pair("\n" + words[n - 1], i * i * i));
      }
      for(int i=words[n-1].length()+1;i<=lineWidth;i++)
      {
          hash.put(new Pair(n - 1, i), new Pair(" " + words[n - 1], 0));
      }

      for (int wordPointer=n-2; wordPointer>=0; wordPointer--)
      {
          String wordsWrap="";
          int badness=0;
          for(int i=0;i<=words[wordPointer].length();i++)
          {
              space=lineWidth-words[wordPointer].length();
              Pair<String,Integer> hashValue = hash.get(new Pair<>(wordPointer+1,space));
              wordsWrap="\n" + words[wordPointer]+hashValue.getFst();
              badness=i*i*i+hashValue.getSnd();
              hash.put(new Pair(wordPointer, i), new Pair(wordsWrap, badness));
          }
          for(int i=words[wordPointer].length()+1;i<=lineWidth;i++)
          {
              int badnessStay=0, badnessNew=0;
              spaceNew=lineWidth-words[wordPointer].length();
              spaceStay=i-1-words[wordPointer].length();
              Pair<String,Integer> hashValueNew = hash.get(new Pair<>(wordPointer+1,spaceNew));
              Pair<String,Integer> hashValueStay = hash.get(new Pair<>(wordPointer+1,spaceStay));
              badnessNew=i*i*i+hashValueNew.getSnd();
              badnessStay=0+hashValueStay.getSnd();
              if(badnessStay<badnessNew)
              {
                  wordsWrap=" " + words[wordPointer]+hashValueStay.getFst();
                  badness=badnessStay;
                  hash.put(new Pair(wordPointer, i), new Pair(wordsWrap, badness));
              }
              else
              {
                  wordsWrap="\n" + words[wordPointer]+hashValueNew.getFst();
                  badness=badnessNew;
                  hash.put(new Pair(wordPointer, i), new Pair(wordsWrap, badness));
              };
          }

      }
      return words[0]+hash.get(new Pair(1, lineWidth-words[0].length())).getFst();
  }
}
