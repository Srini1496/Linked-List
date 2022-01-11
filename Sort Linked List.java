/* Sort Linked List in Ascending order*/
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

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null || head.next==null)
            return head;
    
            ListNode mid=getMiddleNode(head);
            
            ListNode temp=mid.next;
            mid.next=null;
            ListNode a=mergeSort(head);
            ListNode b=mergeSort(temp);
            ListNode merge=mergeList(a,b);
            return merge;
       
    }
    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode node=new ListNode();
        ListNode head=node;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
                head=head.next;
            }else{
                head.next=l2;
                l2=l2.next;
                head=head.next;
            }
        }
     
        head.next=(l1!=null)?l1:l2;
        
        return node.next;
    }
    public ListNode getMiddleNode(ListNode node){
        ListNode slow=node;
        ListNode fast=node;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
