public  class Recursion4Real{
  public static void main (String[] args){
    int[] arr = {2,2};
    System.out.println(splitArray(arr));
  }
  public static boolean groupSum(int start, int[] nums, int target) {
  //just PartialSum
  if(nums.length == 0) return target == 0;
  if(nums.length == 1) return target == 0 || target == nums[0];
  if(target-nums[start] == 0 )return true;
  if(start == nums.length-1)return false;
  return (groupSum(start+1,nums,target-nums[start]) ||  groupSum(start+1,nums,target));
}
public static boolean groupSum6(int start, int[] nums, int target) {
//just PartialSum
groupSum6(start,nums,target,false)
}
public static boolean groupSum6(int start, int[] nums, int target,boolean has6) {
//just PartialSum
if(nums.length == 0) return target == 0;
if(nums.length == 1) return target == 0 || target == nums[0];
if(target-nums[start] == 0 && has6)return true;
if(start == nums.length-1)return false;
return (groupSum6(start+1,nums,target-nums[start],nums[start]==6) ||  groupSum6(start+1,nums,target,nums[start]==6));
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
