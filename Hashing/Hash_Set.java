import java.util.*;
public class Hash_Set {

    public static void main(String[]args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

//        System.out.println(set.size());
//        System.out.println(set);
//        System.out.println(set.contains(5));

        Iterator it = set.iterator();

        for (int num : set) {
            System.out.print(it.next()+" ");
        }

    }
}
