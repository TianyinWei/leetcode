/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
*/

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0 || preorder.length == 1)   return true;
        Stack<Integer> nums = new Stack<Integer>();
        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            while(!nums.isEmpty() && num > nums.peek()) {
                min = nums.pop();
            }
            nums.push(num);
        }
        return true;
    }
}
