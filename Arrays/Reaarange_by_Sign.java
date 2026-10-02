import java.util.*;
public class Reaarange_by_Sign {

    public static int[] rearrangeArray(int[] nums) {
        int [] pos = new int[nums.length/2];
        int []neg = new int[nums.length/2];
        int pVe = 0, NEG = 0;

        int []ans = new int[nums.length];
        for(int i = 0; i<nums.length; i++){

            if(nums[i] > 0){
                pos[pVe] = nums[i];
                pVe++;
            }

            else{
                neg[NEG] = nums[i];
                NEG++;
            }
        }

        for(int i = 0; i < nums.length/2; i++){
            ans[2*i] = pos[i];
            ans[2*i+1] = neg[i];
        }

        return ans;
    }
    public static void main(String[]args){
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
}
