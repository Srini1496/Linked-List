/*
LeetCode - 707-  Design Linked List
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
*/
class MyLinkedList {

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next=next;
        }
    }
    
    ListNode head;
    ListNode tail;
    int size;
    
    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index>=size){
            return -1;
        }
        
        ListNode temp=head;
        while(index!=0){
            temp=temp.next;
            index--;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode node= new ListNode(val);
        if(head==null){            
            head=node;
            tail=head;
            size++;
        }else{
            node.next=head;
            head=node;
            size++;
        }
    }
    
    public void addAtTail(int val) {
        ListNode node= new ListNode(val);
        if(head==null){            
            head=node;
            tail=head;
            size++;
        }else{
            tail.next=node;
            tail=node;
            size++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size)
            return;
        
        ListNode node= new ListNode(val);
        
        if(index==size && head!=null){
            tail.next=node;
            tail=node;
            size++;
            return;
        }else if(index==0){
            addAtHead(val);
            return;
        }
        
        
        ListNode temp=head;
        ListNode prev=null;        
        while(index!=0){
            prev=temp;
            temp=temp.next;
            index--;
        }
        node.next=temp;
        prev.next=node;       
        size++;
        
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size)
            return;
        
        if(index==0 && head!=null){
            if(tail==head)
                tail=head.next;
            head=head.next;
            size--;
            return;
        }
        
        
        ListNode temp=head;
        ListNode prev=null;        
        while(index!=0){
            prev=temp;
            temp=temp.next;
            index--;
        }
        prev.next=temp.next;
        if(temp.next==null){
            tail=prev;
        }        
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
