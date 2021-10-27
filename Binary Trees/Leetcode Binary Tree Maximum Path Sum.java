class Solution {
    
  class Result{
      int data = Integer.MIN_VALUE;
  }
    
    public int maxPathSum(TreeNode root) {

        Result r = new Result();
        r.data = root.val;
        maxPathSumUtil(root,r);
        return r.data;

    }

    private int maxPathSumUtil(TreeNode root, Result result) {
        if (root == null) return 0;
        int left = maxPathSumUtil(root.left,result);
        int right = maxPathSumUtil(root.right,result);
        int max_straight = Math.max(Math.max(left, right) + root.val, root.val);
        int max_edge = Math.max(max_straight, left + right + root.val);
        result.data = Math.max(result.data, max_edge);
        return max_straight;    
    }
}
