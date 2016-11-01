/**
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    class Node {
        private int size;
        private int lower;
        private int upper;
        
        public Node(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int largest = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        findLargestBST(root);
        return largest;
    }
    
    private Node findLargestBST(TreeNode root) {
        if (root == null)   {
            return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Node left = findLargestBST(root.left);
        Node right = findLargestBST(root.right);
        if (left.size == -1 || right.size == -1 || root.val < left.upper || root.val > right.lower) {
            return new Node(-1, root.val, root.val);    //lower and upper values do not matter
        }   else {
            int size = left.size + right.size + 1;
            largest = Math.max(size, largest);
            return new Node(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
        }
    }
}
