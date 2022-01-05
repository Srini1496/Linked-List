/*
705. Design HashSet
Easy

1074

140

Add to List

Share
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

Example 1:

Input
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
Output
[null, null, null, true, false, null, true, null, false]

Explanation
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)
*/
class MyHashSet {
    
    class ListNode{
        int key;
        ListNode next;
        ListNode(int key){
            this.key=key;
        }
    }
    static ListNode head;
    public MyHashSet() {
        head=null;
    }
    
    public void add(int key) {
        if(head==null){
            ListNode node = new ListNode(key);
            head=node;
        }else{
            ListNode temp=head;
            while(temp.next!=null){
                if(temp.key==key)
                    return;
                temp=temp.next;
            }
            if(temp.key==key)
                    return;
            ListNode node = new ListNode(key);
            temp.next=node;
        }
    }
    
    public void remove(int key) {
        ListNode prev,temp;
        if(head==null)
            return;
        
        temp=head;
        if(temp.key==key){
            head=head.next;
            return;
        }
            
        prev=null;
        while(temp!=null && temp.key!=key){
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
            return;
        prev.next=temp.next;
       
    }
    
    public boolean contains(int key) {
        if(head==null)
            return false;
        ListNode temp=head;
        while(temp!=null){
            if(temp.key==key)
                return true;
            temp=temp.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
