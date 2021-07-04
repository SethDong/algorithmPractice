/**
 * 通过hashmap去掉内层循环,在第一次遍历时构造map用于查询
 * nums[result] = target - nums[i]
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //nums[result] = target - nums[i]
        int[] result = new int[2];
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}