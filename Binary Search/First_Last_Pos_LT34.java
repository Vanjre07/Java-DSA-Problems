import java.util.*;
public class First_Last_Pos_LT34 {
    public static int[] searchRange(int[]nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int []ans = {-1,-1};
        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                ans[0] = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }

        low = 0;
        high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                ans[1] = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]nums ={5,7,7,8,8,10};
        int target = 8;

        System.out.print(Arrays.toString(searchRange(nums,target)));
    }
}
