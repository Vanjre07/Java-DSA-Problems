import java.util.*;
public class Floor_Ceil {

    public static int[]FloorCeil(int[]nums,int x){
        int Floor = -1;
        int Ceil = -1;

        Floor = Floor(nums,x);
        Ceil = Ceil(nums,x);

        return new int[]{Floor,Ceil};
    }

    public static int Floor(int[]nums,int x){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        int ans = -1;
        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] <= x){
                ans = nums[mid];
                low = mid +1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int Ceil(int[]nums,int x){
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] >= x){
                ans = nums[mid];
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]nums = {1, 2, 3, 5, 6, 8};
        int x = 4;

        System.out.print(Arrays.toString(FloorCeil(nums,x)));
    }
}
