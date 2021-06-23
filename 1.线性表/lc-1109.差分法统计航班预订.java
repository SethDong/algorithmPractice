/**
 利用 差分数组记录影响，并整合后，通过差分逆运算（前缀和）来恢复
      这样可以把m*n 降低到O（n）
 */

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+2];//因为0~n+1
        for(int i = 0; i < bookings.length;i++){
            diff[bookings[i][0]-1] += bookings[i][2];
            diff[bookings[i][1]] -= bookings[i][2];
        }
        int S[] = new int[n+1];
        for(int i = 1; i<=n;i++){
            S[i] = diff[i-1]+S[i-1];
        }
        int[] arry = new int[n];
        for(int i = 1;i<=n;i++){
            arry[i-1] = S[i];
        }
        
        return arry;
    }
}