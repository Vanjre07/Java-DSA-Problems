import java.util.*;
public class Union_array {
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int num:nums1){
            set.add(num);
        }

        for(int num:nums2){
            set.add(num);
        }

        int[] arr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            arr[index++] = num;
        }

        Arrays.sort(arr);
        return arr;
    }

}
