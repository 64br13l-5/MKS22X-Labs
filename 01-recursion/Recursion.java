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
  public static void printNoDoubleLetterWords(int length,char[] letters){
              printNoDoubleLetterWords(length,"",letters);
          }


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

public static String reverse(String s){
            if(s.length() == 0) return "";
            return reverse(s.substring(1)) +s.charAt(0);}

public static double sqrt(double n){
    return sqrt(n, 1);
                  //Hint: This is a wrapper method.
}

public static double sqrt(double n,double guess){
  if((Math.abs(n-(guess*guess)) /n ) < 0.0001) return guess;
  return sqrt(n, ( n / guess + guess) / 2);
}

public static long countNoDoubleLetterWords(int length,String word){
  if(length == word.length()){
    return 1l;
  }
  for(char c = 'a'; c <= 'z'; c++){
  if((word.length() == 0) || (word.charAt(word.length()-1) != c ))
  return countNoDoubleLetterWords(length,word + (c));
}
return 0l;
}

public static void main(String[] args){
    // char[] x=  {'a','3','i'};
    // printNoDoubleLetterWords(3,"",x );
    // printAllWords(2);
    //   char[] y=   {'a','b','c'};
    // printNoDoubleLetterWords(2,y);
    // printNoDoubleLetterWords(3,y);
    //System.out.println(reverse("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
    System.out.println(countNoDoubleLetterWords(2,""));
  }
}
