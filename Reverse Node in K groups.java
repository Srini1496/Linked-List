/*
LeetCode : 25
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode temp=head;
        ListNode prev=null;
        int length=len(temp);
        temp=head;
        while(temp!=null){
           if(length<k)
               break;
           if(prev==null){
               head=rev(temp,k);
               //System.out.println(head.next.val);
           }else{
              
               prev.next=rev(temp,k);
           }
           prev=temp;
           temp=prev.next;
           length-=k;
        }
        return head;
    }
    public int len(ListNode node){
        if(node==null)
            return 0;
        return 1+len(node.next);
    }
    public ListNode rev(ListNode head,int ptr){
        ListNode prev=null;
        ListNode node=head;
        ListNode next=node.next;
        
        while(ptr!=0 && node!=null){
            node.next=prev;
            prev=node;
            node=next;
           if(node!=null)
                next=node.next;
            ptr--;
        }
        //if(next==null)
            //return prev;
        head.next=node;
        return prev;
    }
}
