import java.util.LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode head;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode Solution(ListNode head, int n){
        if(head.next == null)   return null;

        int size = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }

        if(n == size)    return head.next;
        int IndexSearch = size - n;
        int i=1;
        ListNode prev = head;
        while(i < IndexSearch){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;

        return head;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[]args){
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        head = Solution(head,2);
        printList(head);

    }
}
