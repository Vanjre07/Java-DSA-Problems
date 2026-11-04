import java.util.*;
public class Min_Rotation_Count {
public static int Rotated(int[]nums){
    int low = 0;
    int high = nums.length - 1;
    int ans = Integer.MAX_VALUE;
    int index = -1;
    while(low <= high){
        int mid = (low + high)/2;
        if(nums[low] <= nums[high]){
            if(nums[low] < ans){
                index = low;
                ans = nums[low];
            }
            break;
        }
        if(nums[low] <= nums[mid]){
            if(nums[low] < ans){
                ans = nums[low];
                index = low;
            }
            low = mid + 1;
        }
        else{
            high = mid - 1;
            if(nums[mid] < ans){
                index = mid;
                ans = nums[mid];
            }
        }
    }
    return index;
}
    public static void main(String[] args) {
        int[]nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.print(Rotated(nums));
    }
}
