import java.util.*;
public class StackClass {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
            next = null;
        }
    }

    static class Stack{
        public static ListNode head;
        public static boolean isEmpty(){
            return head == null;
        }

        public void Push(int data){
            ListNode newNode = new ListNode(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.val;
            head = head.next;
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
          return head.val;
        }
    }

    public static void main(String[]args){
        Stack s = new Stack();
        s.Push(1);
        s.Push(2);
        s.Push(3);
        s.Push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}
