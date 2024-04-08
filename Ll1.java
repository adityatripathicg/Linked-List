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
    public void addFirst(int data){
        //step1 - create new node
        Node newNode = new Node(data);

        if (head==null) {
            head = tail = newNode;
            return;
        }
        
        //step2 - newNode next = head
        newNode.next = head;

        //step3 - head = newNode
        head = newNode;
    }
    public void addLast(int data){
        //Step-1 Create New Node
        Node newNode = new Node(data);
        if (head==null) {
            head = tail = newNode;
            return;
        }
        //Step-2 tail next = newNode
        tail.next = newNode;
        //step-3 tail = newNode
        tail=newNode;
    }
    public static void printLL(){
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
    public static void main(String[] args) {
        Ll1 ll = new Ll1();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        printLL();
    }
}