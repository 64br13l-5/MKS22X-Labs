public  class Recursion4Real{
  public static void main (String[] args){

            String[][]wordlists = {
              {"The dog", "The pro skater"},
              {"plays" , "empathises with" },
              {"chess", "ball", "the voiceless masses"}
            };
            permute(wordlists,"",0);

}
/////////////////////////////////////////////////////////////////////////
  public static boolean groupSum(int start, int[] nums, int target) {
  if(start == nums.length)return target==0;
  return (groupSum(start+1,nums,target-nums[start]) ||  groupSum(start+1,nums,target));
}
/////////////////////////////////////////////////////////////////////////
public static boolean groupSum6(int start, int[] nums, int target) {
if(start == nums.length)return target ==0;
if(nums[start] == 6)return (groupSum6(start+1,nums,target-nums[start]));
return (groupSum6(start+1,nums,target-nums[start]) ||  groupSum6(start+1,nums,target));
}
/////////////////////////////////////////////////////////////////////////
public static   boolean groupNoAdj(int start, int[] nums, int target) {
  if(start == nums.length)return target==0;
  if(start == nums.length-1) return (groupNoAdj(start+1,nums,target-nums[start]) ||  groupNoAdj(start+1,nums,target));
  return (groupNoAdj(start+2,nums,target-nums[start]) ||  groupNoAdj(start+1,nums,target));
}
/////////////////////////////////////////////////////////////////////////
public static boolean splitArray(int[] nums) {
  return splitArray(0,0,0,nums);
}
public static boolean splitArray(int i, int t1, int t2, int[] nums){
if(i == nums.length)return t1 == t2;
if(splitArray(i+1,t1-nums[i],t2,nums) ||  splitArray(i+1,t1,t2-nums[i],nums)){
return true;
}
return false;
}
/////////////////////////////////////////////////////////////////////////
public boolean splitOdd10(int[] nums) {
  return splitOdd10(0,0,0,nums);
}
public  boolean splitOdd10(int i, int t1, int t2, int[] nums){
if(nums.length ==1 ) return (nums[i] % 2 != 0 || nums[i] == 10);
if(i == nums.length)return (t1 == 10 && t2 % 2 != 0) || (t2 == 10 && t1 % 2 != 0);
if(splitOdd10(i+1,t1+nums[i],t2,nums) ||  splitOdd10(i+1,t1,t2+nums[i],nums)){
return true;
}
return false;
}
/////////////////////////////////////////////////////////////////////////
public  boolean split53(int[] nums) {
  return split53(0,0,0,nums);
}
public  boolean split53(int i, int t1, int t2, int[] nums){
if(i == nums.length)return t1 == t2;
if(nums[i]% 5 ==0 ){if(split53(i+1,t1-nums[i],t2,nums)) return true;}
else if(nums[i]% 3 ==0 ){if(split53(i+1,t1,t2-nums[i],nums)) return true;}
else if(split53(i+1,t1-nums[i],t2,nums) ||  split53(i+1,t1,t2-nums[i],nums)){
return true;
}
return false;
}
/////////////////////////////////////////////////////////////////////////
public static boolean groupSum5(int start, int[] nums, int target) {
//just PartialSum

if(start == nums.length)return target ==0;
if(nums[start] %5 == 0){
  if(start != nums.length-1 && nums[start+1] == 1)
  return (groupSum5(start+2,nums,target-nums[start]));
  return(groupSum5(start+1,nums,target-nums[start]));
}
return (groupSum5(start+1,nums,target-nums[start]) ||  groupSum5(start+1,nums,target));
}
/////////////////////////////////////////////////////////////////////////
public static boolean groupSumClump(int start, int[] nums, int target) {
  if(start == nums.length)return target ==0;
    if(start != nums.length-1){
      int i = start;
      while(i < nums.length && nums[i] == nums[start])i++;
    return  (groupSumClump(i,nums,target-nums[start]*(i-start)) ||  groupSumClump(i,nums,target));
    }
  return (groupSumClump(start+1,nums,target-nums[start]) ||  groupSumClump(start+1,nums,target));
}
/////////////////////////////////////////////////////////////////////////
public static void permute(String[][]lists, String sentence, int current){
  if(current == lists.length) System.out.println(sentence);
  else{
  for(int i  =0; i< lists[current].length; i++){
    permute(lists, sentence +" " +lists[current][i],current+1);
  }
}


         }
}
