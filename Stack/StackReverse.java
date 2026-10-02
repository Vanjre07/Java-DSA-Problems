import java.util.*;
public class StackReverse {
    public static void PushAtBottom(int data,Stack<Integer> S){
        if(S.isEmpty()){
            S.push(data);
            return;
        }
        int top = S.pop();
        PushAtBottom(data,S);
        S.push(top);
    }
    public static void reverse(Stack<Integer> S){
        if(S.isEmpty()){
            return;
        }
        int top = S.pop();
        reverse(S);
        PushAtBottom(top,S);
    }

    public static void main(String[]args){
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(2);
        S.push(3);
        S.push(4);

//        while(!S.isEmpty()){
//            System.out.println(S.peek());
//            S.pop();
//        }


        System.out.println("Reversed Stack");
        reverse(S);
        while(!S.isEmpty()){
            System.out.println(S.peek());
            S.pop();
        }

    }
}
