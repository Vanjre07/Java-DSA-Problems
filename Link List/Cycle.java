public class Cycle {
    static class ListNode{
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
    }

    public boolean HasACycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode Hare = head;
        ListNode turtle = head;
        while(Hare != null && Hare.next != null){
            Hare = Hare.next.next;
            turtle = turtle.next;

            if(Hare == turtle){
                return true;
            }
        }
            return false;

    }
    public static void main(String []args){
        Cycle c = new Cycle();

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creates the cycle: 2 -> 3 -> 4 -> 2

        System.out.println(c.HasACycle(head));
    }
}
