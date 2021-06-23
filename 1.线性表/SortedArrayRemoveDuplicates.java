/**
 * 有序数组删除重复的元素，并返回新的长度
 * 空间复杂度O(1)
 * 时间复杂度O(n)
 * 主体思路： 通过两个指针（索引），每次选择与慢索引不等的元素赋值给慢索引下一元素；快索引走完慢索引对应的下一位置为精简数组长度
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = 1;
        while(j != nums.length){
            if(nums[j]!=nums[i]){
                nums[i+1] = nums[j];
                j++;i++;
            }else{
                j++;
            }
        }
        return i+1;
    }
}