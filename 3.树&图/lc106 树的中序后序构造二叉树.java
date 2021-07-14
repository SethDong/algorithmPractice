/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private HashMap<Integer,Integer> inorderMap;
    private int[] postorder;
    private int[] inorder;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.inorderMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length; i++){
            this.inorderMap.put(inorder[i],i);
        }
        // why need this param in constractor?
        postIndex = postorder.length-1;
        
        return build(0,inorder.length-1);
    }

    private TreeNode build(int startIndex, int endIndex){
        if(startIndex > endIndex){
            return null;
        }
        
        int rootVal = this.postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        // get left/right tree
        int index = this.inorderMap.get(rootVal);
        postIndex--;
        // first right subTree, then left tree. becuase the algorithm's order follow the contrary of postorder 
        root.right = build(index+1, endIndex);
        root.left = build(startIndex, index-1);
        return root;
    }

   
}