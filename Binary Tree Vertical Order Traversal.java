/*Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]*/

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)   return res;

        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> cols = new LinkedList<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int col = 0;
        int min = 0, max = 0;
        nodes.offer(root);
        cols.offer(col);
        
        while(!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            col = cols.poll();
            if(!map.containsKey(col)) {
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(cur.val);
                map.put(col, tempList);
            }   else {
                map.get(col).add(cur.val);
            }
            
            if (cur.left != null) {
                nodes.offer(cur.left);
                cols.offer(col - 1);
                min = Math.min(col - 1, min);
            }
            if (cur.right != null) {
                nodes.offer(cur.right);
                cols.offer(col + 1);
                max = Math.max(col + 1, max);
            }
        }
        
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
