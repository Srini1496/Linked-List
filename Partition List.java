/*
Leet Code 86
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

 

Example 1:


Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/

//Simple mmethod create two linked list and merge them

//below solutoin is O(1) space
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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        
        ListNode node=head;
        ListNode high=head;
        ListNode highPrev=null;
        
        while(high!=null){
            if(high.val>=x)
                break;
            
            highPrev=high;
            high=high.next;
        }
        
        if(high==null)
            return head;
        ListNode prev=high;
        ListNode temp=high.next;
      
        
        while(temp!=null){
            if(temp.val<x){
                if(highPrev==null){
                    highPrev=temp;
                    ListNode c=temp.next;
                    
                    temp.next=high;
                    prev.next=c;
                    
                    head=highPrev;
                    
                    
                    temp=c;
                }else{
                    
                    ListNode a=highPrev.next;
                    highPrev.next=temp;

                    prev.next=temp.next;
                    temp.next=a;

                    highPrev=highPrev.next;
                    temp=prev.next;                
                
                }
            }else{
                prev=temp;
                temp=temp.next;
            }
        }
        
        return head;
    }
}
