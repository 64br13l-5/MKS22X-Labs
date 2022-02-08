public class Challenge{
  public static void main(String[] args){
    int x = 0;
    for(int i = 1; i<=1000; i++){
      x += toWords(i).length();
    }
    System.out.println(x);
  }
  public static String toWords(int num){
    String[] nums = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","","twen","thir","for","fif","six","seven","eigh","nine"};
    if(num >= 1000) return nums[(num / 1000)] + "thousand"+toWords(num-(num/1000)*1000);
    else  if(num >= 100 && num % 100 == 0) return nums[(num / 100)] + "hundred";
    else  if(num >= 100) return nums[(num / 100)] + "hundredand"+toWords(num-(num/100)*100);
    else    if(num >= 20) return nums[(num / 10)+10] + "ty" +toWords(num-(num/10)*10);
    else    if(num == 14) return "fourteen";
    else    if(num > 12) return nums[(num % 10)+10] + "teen";
    else    if(num == 12) return "twelve";
    else    if(num == 11) return "eleven";
    else    if(num >= 1) return nums[(num)];
    return "";
  }
}
