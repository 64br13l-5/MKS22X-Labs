  import java.util.*;
    public class Calculator{
      /*Evaluate a postfix expression stored in s.
      *Assume valid postfix notation, of ints doubles and operators separated by spaces.
      *Valid operators are + - / * and % (remainder not modulo)
      *All results are doubles even if the operands are both int.
      *@throws IllegalArgumentException when there are too many or too few operands.
      *        Use the string parameter of your exception to indicate what happened.
      *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
      */
      public static double eval(String s){
        Deque<Double> d = new  ArrayDeque<>();
        Scanner input = new Scanner(s);
        while(input.hasNext()) {
          var x = input.next();
          try{d.addLast(Double.parseDouble(x));}
          catch(Exception e) {
            if(d.size() < 2) throw new IllegalArgumentException("too few operands");
            var a = d.removeLast();
            var b = d.removeLast();
            switch(x) {
            case "*": d.addLast(b * a);
                  break;
            case "+": d.addLast(b + a);
                  break;
            case "/":d.addLast(b / a);
                  break;
            case "-":d.addLast(b - a);
                  break;
            }
          }
      }
        if(d.size() > 1) throw new IllegalArgumentException("too many operands");
        if(d.size() < 1) throw new IllegalArgumentException("too few operands");
        return d.getLast();
      }
      public static void main(String[] args){

      }
    }
