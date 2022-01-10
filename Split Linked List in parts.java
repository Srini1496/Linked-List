/*
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.

 

Example 1:


Input: head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
Explanation:
The first element output[0] has output[0].val = 1, output[0].next = null.
The last element output[4] is null, but its string representation as a ListNode is [].
Example 2:


Input: head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
Explanation:
The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 

Constraints:

The number of nodes in the list is in the range [0, 1000].
0 <= Node.val <= 1000
1 <= k <= 50
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
