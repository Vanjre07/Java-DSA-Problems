import java.util.*;
public class Reaarange_by_Sign {

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i = 0; i< n;i++){
            if(nums[i] < 0){
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        for(int i = 0; i < n/2; i++){
            nums[i*2+1] = pos.get(i);
            nums[i*2] = neg.get(i);
        }

        return nums;
    }
    public static void main(String[]args){
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
}
