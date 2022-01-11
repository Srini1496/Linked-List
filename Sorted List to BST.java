/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        return constructTree(head,null);
    }
    public TreeNode constructTree(ListNode head,ListNode tail){
        if(head==tail)
            return null;
        //Find the middle element
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=tail && fast.next!=tail){
            slow=slow.next;
            fast=fast.next.next;
        }
        //After the above process slow will always point to the middle node
        
        TreeNode root=new TreeNode(slow.val);
        root.left=constructTree(head,slow);
        root.right=constructTree(slow.next,tail);
        
        return root;
    }
}
