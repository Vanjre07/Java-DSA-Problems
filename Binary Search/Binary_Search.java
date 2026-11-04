public class Binary_Search {
    public static int Algorithm(int[]nums,int target){
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = (low + high)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[low] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]nums = {1,2,3,4,5,6,7,8,9};
        int target = 5;

        System.out.print(Algorithm(nums,target));
    }
}
