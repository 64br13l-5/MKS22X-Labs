public  class Recursion4Real{
  public static void main (String[] args){
    int[] arr = {2,2};
    System.out.println(splitArray(arr));
  }
  public static boolean groupSum(int start, int[] nums, int target) {
  if(start == nums.length)return target==0;
  return (groupSum(start+1,nums,target-nums[start]) ||  groupSum(start+1,nums,target));
}
public static boolean groupSum6(int start, int[] nums, int target) {
//just PartialSum

if(start == nums.length)return target ==0;
if(nums[start] == 6)return (groupSum6(start+1,nums,target-nums[start]));
return (groupSum6(start+1,nums,target-nums[start]) ||  groupSum6(start+1,nums,target));
}
public static   boolean groupNoAdj(int start, int[] nums, int target) {
  if(start == nums.length)return target==0;
  if(start == nums.length-1) return (groupNoAdj(start+1,nums,target-nums[start]) ||  groupNoAdj(start+1,nums,target));
  return (groupNoAdj(start+2,nums,target-nums[start]) ||  groupNoAdj(start+1,nums,target));
}

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
}
