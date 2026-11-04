import java.util.*;
public class Search_Insert_LT35 {
    public static int Insert(int[]nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int []nums = {1,3,5,6};
        int target = 2;

        System.out.print(Insert(nums,target));
    }
}
