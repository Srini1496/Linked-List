/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 

Follow up: Could you solve it without reversing the input lists?
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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=length(l1);
        int len2=length(l2);
        //Find Difference
        int diff=Math.abs(len1-len2);
        //make sure l1 is always the node with max length
        
        if(len1<len2){
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        
        findSum(l1,l2,diff);
        if(carry!=0){
            ListNode node=new ListNode(carry);
            node.next=l1;
            l1=node;
        }
        return l1;
    }
    public int carry=0;
    public void findSum(ListNode l1,ListNode l2,int diff){
        if(l1==null && l2 ==null)
            return;
        
        if(diff>0 && l1!=null)
            findSum(l1.next,l2,diff-1);
        
        else if(l1!=null && l2 !=null){
            findSum(l1.next,l2.next,diff);
        }
        
        int add=l1.val+carry+(diff>0?0:l2.val);
        if(add>9){
            carry=add/10;
            add=add%10;
        }else{
            carry=0;
        }
        l1.val=add;
    }
    public int length(ListNode node){
        if(node==null)
            return 0;
        return 1+length(node.next);
    }
}
