/*
Convert Binary Number in a Linked List to Integer
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 

Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
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
    public int getDecimalValue(ListNode head) {
        List<Character> binary = new ArrayList<Character>();
        ListNode temp=head;
        while(temp!=null){
            binary.add((char)temp.val);
            temp=temp.next;
        }
        int size=binary.size()-1;
        int decValue=0;
        int base=1;
        while(size>=0){
            decValue+=base*binary.get(size);
            base*=2;
            size--;
        }
        return decValue;
    }
}
