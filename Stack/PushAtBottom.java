import java.util.*;
public class PushAtBottom {
    public static void Bottom(int data, Stack<Integer> S){
        if(S.isEmpty()){
            S.push(data);
            return;
        }
        int top = S.pop();
        Bottom(data,S);
        S.push(top);
    }
    public static void main(String [] args){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        int data =4;
        Bottom(data,s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}
