import java.util.*;
public class Search_Rotated_Arr_LT33 {

    public static int Search(int[]nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid +1;
                }
            }
            else{
                if(nums[low] <= target && target < nums[mid]){
                    low = mid +1;
                }
                else{
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
