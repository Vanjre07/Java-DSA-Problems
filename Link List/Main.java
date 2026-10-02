public class Main{
    Node head;
    private int size;
    Main(){
        this.size=0;
    }

    class Node{
        String data;
        Node next; 
        
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }
    
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;

        
    }
    
    public void printList(){
        if(head ==null){
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void deleteFirst(){

        if(head ==null){
            System.out.println("NULL");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            System.out.println("The list is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node secLast = head;
        Node lastNode = head.next;
        while(lastNode.next!=null){
            lastNode  = lastNode.next;
            secLast=secLast.next;
        }
        secLast.next =null;
    }

    //Using Iterative method
    public void reverseNode(){
        if(head == null || head.next==null){
            return;
        }

        Node prevnode = head;
        Node currNode = head.next;
        while(currNode!= null){
            Node nextNode = currNode.next;
            currNode.next = prevnode;

            prevnode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevnode;
    }


    //Using Recrusive Method
    public Node reverseRecrusive(Node head){
        if(head ==null || head.next == null){
            return head;
        }
        Node newHead = reverseRecrusive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public int getSize(){
        return size;
    }
    public static void main(String args[]){
        Main list =  new Main();
        list.addFirst("A");
        list.addFirst("is");
        list.printList();

        list.addLast("List");
        list.printList();

        list.addFirst("this");
        list.printList();

        list.deleteFirst();
        list.printList();
        list.deleteLast();
        list.printList();
        System.out.println(list.getSize());
        list.addFirst("this");
        list.printList();
        System.out.println(list.getSize());
//        list.reverseNode();

        list.head = list.reverseRecrusive(list.head);
        list.printList();
    }
}