import java.util.*;
public class Using_ArrayList {
    static class Stackclass{
        static List<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }
        public static void push(int data){
            list.add(data);
        }

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() -1);
            list.remove(list.size() -1);
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() -1);
        }

    }
    public static void main(String[] args){
        Stackclass s = new Stackclass();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(10);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        Stack<Integer> Stc = new Stack<>();
        System.out.println("Collection");
        Stc.push(3);
        Stc.push(4);
        Stc.push(5);
        Stc.push(6);
        Stc.push(10);

        System.out.println("Size of Stack "+ Stc.size());
        while(!Stc.isEmpty()){
            System.out.println(Stc.peek());
            Stc.pop();
        }
    }
}
