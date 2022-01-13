/*
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
       ListNode temp=head;
        int len=length(temp);
        k=k%len;
        if(k==0)
            return head;
        int count =len-k;
        ListNode list=new ListNode();
        ListNode prev=null;
        temp=head;
        while(count!=0){
            prev=temp;
            temp=temp.next;
            count--;
        }
        prev.next=null;
        list.next=temp;
        while(temp.next!=null){
            temp=temp.next;
        }
       
        temp.next=head;
        return list.next;
    }
    public int length(ListNode node){
        if(node==null)
            return 0;
        return 1+length(node.next);
    }
}
