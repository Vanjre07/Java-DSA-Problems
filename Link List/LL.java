import java.util.*;
public class LL {

    public static void main(String[]args){
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);
        list.addLast("list");
        list.addFirst("This");
        System.out.println(list);
        //list.removeFirst();
       // System.out.println(list);
        //list.removeLast();
        //System.out.println(list);
        System.out.println(list.size());

        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i)+"->");
        }
        System.out.println("NULL");
        list.remove(2);
        System.out.print(list);

    }
}
