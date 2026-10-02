import java.util.*;
public class Hash_Map {

    public static void main(String[]args){
        Map<String,Integer> map = new HashMap<>();
        map.put("India",150);
        map.put("China",140);
        map.put("USA",35);

//        System.out.println(map);
//        map.put("China",145);
//        System.out.println(map);
//        System.out.println(map.containsKey("China"));
//        System.out.println(map.containsValue(150));
//        System.out.println(map.get("China"));

            for(Map.Entry<String,Integer> e: map.entrySet()){
                System.out.print(e.getKey()+" ");
                System.out.println(e.getValue());
            }

    }
}
