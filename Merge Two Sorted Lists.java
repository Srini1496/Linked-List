/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/
class Solution {
    public static ListNode mergedList;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1;
        ListNode temp2=list2;
       mergedList=null;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                insertNode(temp1.val);
                temp1=temp1.next;
            }else{
                insertNode(temp2.val);
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
            insertNode(temp1.val);
            temp1=temp1.next;
        }
        while(temp2!=null){
             insertNode(temp2.val);
             temp2=temp2.next;
        }
        return mergedList;
    }
    public void insertNode(int val){
        if(mergedList==null){
            mergedList = new ListNode(val);
            return;
        }else{
            //System.out.println(list.val);
            ListNode temp=mergedList;
            while(temp.next!=null){
                temp=temp.next;
            }
            ListNode newNode = new ListNode(val);
            temp.next=newNode;
        }
   
    }
}
