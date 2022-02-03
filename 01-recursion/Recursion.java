public class Recursion{
  public static void printAllWords(int size, String ans){


    if(size == ans.length()){
    System.out.println(ans);
    }
    else{
    for(char c = 'a'; c <= 'e'; c++)
    printAllWords(size,ans + (c));
    }
  }
  public static void printAllWords(int size){
    printAllWords(size, "");
  }
  /*Print all words that are made of the characters in the array of letters.
          *There may not be consecutive equal letters, so:
          *aax is not allowed, but axa is allowed.
          *@param length : the length of the words that are to be printed
          *@param letters: the letters you should be using,
          *@precondition: letters contains at least 2 characters, and has no duplicates.
          */
public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
}

          /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
          *aax is not allowed, but axa is allowed.
          *@param length : either how many more letters need to be
          *@param word   : the partial word so far.
          *@param letters: the letters you should be using
          */
public static void printNoDoubleLetterWords(int length,String word,char[]letters){
  if(length == word.length()){
  System.out.println(word);
  }
  else{
  for(char c : letters){
  if((word.length() == 0) || (word.charAt(word.length()-1) != c ))
  printNoDoubleLetterWords(length,word + (c),letters);
}
  }
}
  public static void main(String[] args){
    char[] x=  {'a','3','i'};
    printNoDoubleLetterWords(3,"",x );

  }
}
