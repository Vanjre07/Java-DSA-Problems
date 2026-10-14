import java.util.*;
public class Next_Permutation_LT31 {
    static class Permutation{
        public static void nextPermutation(int []nums){
            int n = nums.length;
            int pivot = -1;

            for(int i = n - 2; i >= 0; i--){
                if(nums[i] < nums[i + 1]){
                    pivot = i;
                    break;
                }
            }

            if(pivot != -1)
                for(int i = n -1; i >= pivot; i--) {
                    swap(nums, i, pivot);
                    break;
                }

            ReverseArray(nums,pivot+1,n - 1);
        }

        public static void swap(int[]nums,int left,int right){
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
        }

        public static void ReverseArray(int[]nums,int left,int right){
            while(left < right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
    }
    public static void main(String[]args){
        int []nums = {1,2,3};
        Permutation.nextPermutation(nums);

        for(int num:nums){
            System.out.print(num+" ");
        }

    }
}

