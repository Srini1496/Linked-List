/*
Leet Code : 82
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode prev=null;
        ListNode start=head;
        ListNode end=head.next;
        boolean flag=false;
        while(start!=null && end!=null){
            if(start.val==end.val){
                end=end.next;
                flag=true;
            }else{
                if(flag){
                    if(prev==null){
                        head=end;
                        start=head;
                        end=head.next;
                        flag=false;
                    }else{
                        prev.next=end;
                        start=end;
                        end=end.next;
                        flag=false;
                    }
                    
                }else{
                    prev=start;
                    start=start.next;
                    end=end.next;
                }
            }
        }
        if(prev==null && flag==true)
            return null;
        else if(flag==true){
            prev.next=null;
        }
        return head;
    }
}
