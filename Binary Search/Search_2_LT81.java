import java.util.*;
public class Search_2_LT81 {
    public static boolean Search(int[]nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
            }

            else if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[high]){
                    high = mid - 1;
                }
                else{
                    low = mid +1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]nums = {2,5,6,0,0,1,2 };
        int target = 0;

        System.out.println(Search(nums,target));
    }
}
