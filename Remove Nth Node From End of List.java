/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        ListNode start=root;
        ListNode end=root;
        end.next=head;
        for(int i=0;i<n+1;i++){
            end=end.next;
        }
       
        while(end!=null){
            start=start.next;
            end=end.next;
        }
        start.next=start.next.next;
        return root.next;
    }
}
