package Hard_Level;
import java.util.*;
public class Majority_Elements2_LT229 {
    public static List<Integer> Majority(int[]nums){
        int n = nums.length;
        int target = n/3;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > target){
                list.add(e.getKey());
            }
        }
        return list;
    }
    public static void main(String[]args){
        int[]nums = {1, 2, 3, 1, 2, 1, 2, 4, 2, 1};
        System.out.println(Majority(nums));
    }
}
