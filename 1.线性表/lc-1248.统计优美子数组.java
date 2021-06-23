lc-1248.统计优美子数组
/* 
优美子数组的问题，转换为 有多少个 S[s~e] = S[e] - k;
  1.将原数组变为模二运算余数的数组
  2.求前缀和，并把前缀和，并记录对应原位置的前缀和
  3.关键是： 数组 s~e 一段的和 = S[e] - S[s-1];
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] S = new int[n+1];
        int[] counts = new int[n+1];
        counts[S[0]]++;

        for(int i = 1; i<=n; i++){
            S[i]=S[i-1]+nums[i-1]%2;
            counts[S[i]]++;
        }

        int ans = 0;
        for(int i = 1; i<=n;i++){
            if(S[i]-k>=0){
                ans += counts[S[i]-k];
            }
        }
        return ans;
    }
}