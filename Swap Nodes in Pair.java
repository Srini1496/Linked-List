/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=length(head);
        ListNode[] arr = new ListNode[k];
        ListNode temp=head;    
        int rem=len%k;
        int i=0;
        while(i<k){
            arr[i]=temp;
            int total=(len/k);
             if(rem!=0){
                rem--;
                total++;
            }
            ListNode tail=temp;
            for(int j=1;j<total;j++){
                tail=tail.next;
            }
            if(temp!=null){                    
                temp=tail.next;
                tail.next=null;
            }
            i++;
        }
        return arr;
    }
    public int length(ListNode node){
        if(node==null)
            return 0;
        return 1+length(node.next);
    }
}
