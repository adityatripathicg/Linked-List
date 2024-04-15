import java.util.*;
public class Ll1{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; //Size/Length of LinkedList

    public void addFirst(int data){ //AddFirst LinkedList
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        if (head==null) {
            head = tail = newNode;
            return;
        }
        
        //step2 - newNode next = head
        newNode.next = head;

        //step3 - head = newNode
        head = newNode;
    }
    public void addLast(int data){ // AddLast LinkedList
        //Step-1 Create New Node
        Node newNode = new Node(data);
        size++;
        if (head==null) {
            head = tail = newNode;
            return;
        }
        //Step-2 tail next = newNode
        tail.next = newNode;
        //step-3 tail = newNode
        tail=newNode;
    }
    public static void printLL(){ //Printing a LinkedList
        if (head==null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" -->  ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public void add(int idx, int data){ // Add in Middle
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i<idx-1) {
            temp = temp.next;
            i++;
        }

        //i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){ // Remove first in LinkedList
        if (size == 0) {
            System.out.println("LinkedList is EMPTY");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){ //Remove Last in LinkedList
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //Prev : i = size-2
        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public static int itrSearch(int key){
        Node temp = head;
        int i = 0;
        while (temp!=null) {
            if (temp.data==key) { //Key Found
                return i;
            }
            temp = temp.next;
            i++;
        }
        //Key Not Found
        return -1;
    }
    public int helper(Node head, int key){
        if (head == null) {
            return -1;
        }
        if(head.data== key){
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){ //Recursive Search in LL
        return helper(head, key);
    }

    public void reverse(){ // reverse a LL
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public boolean isCycle(){ //Floyd's CFA
        Node slow = head;
        Node fast = head;
        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){ //Remove a Cycle in LL
        //Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle==false) {
            return;
        }
        //Find Meeting Point 
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        // Remove Cycle -> last.next = null
        prev.next = null;
    } 
    //FIND MID
    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    // Merge 
    private Node merge(Node head1, Node head2){
        Node MergedLL = new Node(-1);
        Node temp = MergedLL;

        while (head1!= null && head2 != null) {
            if (head1.data<=head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1!=null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return MergedLL.next;
    }
    //MERGE SORT IN LL
    public Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        //Find MID
        Node mid = getMid(head);
        //Left & Right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(rightHead);
        Node newRight = mergeSort(rightHead);
        //Merge
        return merge(newLeft, newRight);
    }
    public static void main(String[] args) {
        LinkedList<Integer>ll = new LinkedList<>();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        System.out.println(ll);
        ll.head = ll.mergeSort(ll.head);
        // Ll1 ll = new Ll1();
        // printLL();
        // ll.addFirst(2);
        // printLL();
        // ll.addFirst(1);
        // printLL();
        // ll.addLast(3);
        // printLL();
        // ll.addLast(4);
        // ll.add(2, 9);
        // printLL();
        // System.out.println(ll.size);
        // ll.removeFirst();
        // printLL();
        // ll.removeLast();
        // printLL();
        // System.out.println(itrSearch(3));
        // System.out.println(ll.recSearch(10));
        // System.out.println(ll.isCycle());
        // ll.reverse();
        // printLL();
    }
}