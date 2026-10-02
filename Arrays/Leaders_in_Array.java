import java.util.*;
public class Leaders_in_Array {
    public static List<Integer> leaders(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int min = Integer.MIN_VALUE;
        for(int i = nums.length -1; i >= 0; i--){
            if(nums[i] >= min){
                list.add(nums[i]);
                min = nums[i];
            }
        }
        Collections.reverse(list);

        return list;
    }
    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};

        System.out.println(leaders(nums));
    }
}
