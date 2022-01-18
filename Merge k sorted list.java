/*
Leetcode : 23
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return mergeSort(lists,0,lists.length-1);
    }
    public ListNode mergeSort(ListNode[] lists,int start,int end){
        if(start>end)
            return null;
        if(start==end){
            return lists[start];
        }
            
        int mid=start+(end-start)/2;        
        ListNode l1=mergeSort(lists,start,mid);
        ListNode l2=mergeSort(lists,mid+1,end);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode node1=l1;
        ListNode node2=l2;
        
        ListNode list=new ListNode();
        ListNode tail=list;
        
        while(node1!=null && node2!=null){
            if(node1.val<node2.val){
                tail.next=node1;               
                node1=node1.next;
            }else{
                tail.next=node2;
                node2=node2.next;
            }
            tail=tail.next;
        }
        
        tail.next=node1==null?node2:node1;
        
        return list.next;
        
    }
}
