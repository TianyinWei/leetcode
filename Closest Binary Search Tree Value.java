/*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

public class Solution {
    public int closestValue(TreeNode root, double target) {
        double diff = Math.abs(root.val - target);
        int node = root.val;
        while (root != null) {
            if (target == root.val) return root.val;
            if (Math.abs(target-root.val) < diff) {
                node = root.val;
                diff = Math.abs(target-root.val);
            }
            if (target < root.val) {
                root = root.left;
            }   else {
                root = root.right;
            }
            
        }
        
        return node;
    }
}
