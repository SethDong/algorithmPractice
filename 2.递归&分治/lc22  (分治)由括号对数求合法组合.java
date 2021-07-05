/**
 * 分治法
 * （a）b：a、b分别为子问题， 
 * 核心就是（a）这样的划分将A和B完全割裂开来了
 */

class Solution {
    public List<String> generateParenthesis(int n) {
     
        List<String> res = new ArrayList<>();
        if (n==0){ res.add("");return res;}
        if(this.h.containsKey(n)){
            return this.h.get(n);
        }
        for(int k =1; k<=n; k++){
            // 两子问题递归
            List<String> resultA = generateParenthesis(k-1);
            List<String> resultB = generateParenthesis(n-k);
            
            for(String a : resultA){
                for(String b : resultB){
                    res.add("("+a+")" + b);
                }
            }
        }
        h.put(n,res);
        return res;
    }

    // 记忆化，防止递归重复计算
    private HashMap<Integer, List<String>> h = new HashMap<Integer,List<String>>();
}