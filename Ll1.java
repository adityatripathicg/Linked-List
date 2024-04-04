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
    public static void main(String[] args) {
        Ll1 ll = new Ll1();
        printLL();
        ll.addFirst(2);
        printLL();
        ll.addFirst(1);
        printLL();
        ll.addLast(3);
        printLL();
        ll.addLast(4);
        ll.add(2, 9);
        printLL();
        System.out.println(ll.size);
        ll.removeFirst();
        printLL();
    }
}