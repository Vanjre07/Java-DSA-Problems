import java.util.*;
public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> values = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for(int num:nums2){
            values.add(num);
        }
        for(int num : nums1){
            if(values.contains(num)){
                common.add(num);
            }
        }
        int[] arr = new int[common.size()];
        int index = 0;
        for(int num : common){
            arr[index++] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 4};
        int[] nums2 = {2, 2, 4, 5};

        int[] answer = intersection(nums1, nums2);

        for (int value : answer) {
            System.out.print(value + " ");
        }
    }
}
