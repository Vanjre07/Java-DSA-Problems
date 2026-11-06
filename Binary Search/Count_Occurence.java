import java.util.*;
public class Count_Occurence {
    public static int Occurence(int[]nums,int target){
        int first = lowerBound(nums,target);
        if(first == nums.length || nums[first] != target)
            return 0;
        int afterLast = upperBound(nums,target);

        return afterLast - first;
        }

        public static int lowerBound(int[]nums,int target){
            int low = 0;
            int high = nums.length - 1;
            int ans = nums.length;
            while(low <= high){
                int mid = (low + high)/2;

                if(nums[mid] >= target){
                    ans = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            return ans;
        }

        public static int upperBound(int[]nums,int target){
        int low = 0;
        int ans = nums.length;
        int high = ans - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] > target){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
        }

    public static void main(String[] args) {
        int[]nums = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.print(Occurence(nums,target));
    }
}
