/**
 * 分治的思想：分治就是把问题划分为互为补集的若干子问题，通过解决子问题，再合并的过程
 * 本题 将问题分为 n为奇数和偶数两种情况，然后递归解决，递归终止条件为n=1
 * 分治的难点就在于 如何划分子问题
 */

class Solution {
    public double myPow(double x, long n) {
       // 递归边界
        if(n == 0){
            return 1;
        }

        // 子问题1 n<0
        if (n < 0){
            return 1/myPow(x,-n);
        }
        double temp = myPow(x,n/2);
        // 子问题2 n为奇数
        if(n % 2 == 1){
            return temp * temp * x;
        }else{ // 子问题3 n为偶数
            return temp * temp;
        }
    }

 
}