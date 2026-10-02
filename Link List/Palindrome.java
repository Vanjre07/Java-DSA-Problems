import java.util.List;

public class Palindrome {
    static class ListNode{
        int val;
        ListNode next;
        ListNode head;

        ListNode(){}
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public boolean pali(ListNode head){
        if(head == null || head.next ==null){
            return true;
        }
        ListNode FirstHalf = head;
        ListNode middle = FindMiddle(head);
        ListNode SecHalf = FindReverse(middle.next);

        while(SecHalf != null){
            if(FirstHalf.val != SecHalf.val){
                return false;
            }
            FirstHalf = FirstHalf.next;
            SecHalf = SecHalf.next;
        }
        return true;
    }

    public ListNode FindMiddle(ListNode head){
        ListNode Hare = head;
        ListNode Turtle = head;

        while(Hare.next != null && Hare.next.next  != null){
            Hare = Hare.next.next;
            Turtle = Turtle.next;
        }
        return Turtle;
    }

    public ListNode FindReverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = FindReverse(head.next);
        head.next.next = head.next;
        head.next =  null;
        return newHead;
    }

    public static void main(String []args){
        Palindrome P = new Palindrome();
        ListNode list = new ListNode(1,new ListNode(2,new ListNode(3)));
        boolean res = P.pali(list);
        System.out.println(res);
    }
}
