package 打家劫舍III337;

public class Solution {
    public int rob(TreeNode root) {
        int[] temp = dfs(root);
        return Math.max(temp[0], temp[1]);
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftNumber = dfs(root.left);
        int[] rightNumber = dfs(root.right);
        return new int[]{(leftNumber[1] + rightNumber[1]) + root.val, (Math.max(leftNumber[0], leftNumber[1]) + Math.max(rightNumber[0], rightNumber[1]))};
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }
