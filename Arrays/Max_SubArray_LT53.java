import java.util.*;
public class Max_SubArray_LT53 {
    public static int MaxSubArray(int[]nums){
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[]args){
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(MaxSubArray(nums));
    }
}
