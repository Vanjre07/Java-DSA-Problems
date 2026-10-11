import java.util.*;
public class Sort_Colors_LT75 {

    //Here this problem use DNF Algorithm (Duetche National Flag Algorithm) which is optimised compared to other sorting Algorithm
    public static void SortColors(int []nums){
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        for(int i = 0; i < n; i++){
            while(mid <= high){
                if(nums[mid] == 0){
                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                }
                else if(nums[mid] == 1) mid++;
                else{
                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                }
            }
        }
    }
    public static void main(String[]args){
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors(nums);

        for(int num : nums){
            System.out.print(num+" ");
        }
    }
}
