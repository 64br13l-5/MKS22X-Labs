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
}
