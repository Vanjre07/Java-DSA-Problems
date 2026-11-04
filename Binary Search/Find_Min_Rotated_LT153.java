import java.util.*;
public class Find_Min_Rotated_LT153 {
    public static int Minimum(int[]nums){
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] < nums[mid]){
                ans = Math.min(ans,nums[low]);
                low = mid + 1;
            }
            else{
                ans = Math.min(ans,nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]nums = {3,4,5,1,2 };
        System.out.print(Minimum(nums));
    }
}
