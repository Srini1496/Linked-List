/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
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
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            if(prev==null){
                prev = new ListNode(temp.val);
                prev.next=null;
            }else{
                ListNode node = new ListNode(temp.val);
                node.next=prev;
                prev=node;
            }
            temp=temp.next;
        }
        return prev;
    }
}
