import java.util.*;
public class Longest_Increasing_Subsequence_LT300 {
    static class Binary_Search {
        private static int Subsequence(int[] nums) {
            int size = nums.length;
            if (size == 0) {
                return 0;
            }
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);

            int len = 1;
            for (int index = 1; index < size; index++) {
                if (nums[index] > list.get(list.size() - 1)) {
                    list.add(nums[index]);
                    len++;
                } else {
                    int ind = LowerBound(list, nums[index]);
                    list.set(ind, nums[index]);
                }
            }
            return len;
        }
    }

    private static int LowerBound(List<Integer> list,int target){
        int low = 0;
        int high = list.size() - 1;
        int ans = list.size();
        while(low <= high){
            int mid = (low + high)/2;

            if(list.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static class Dynamic_Programming{
        private static int Subsequence(int[]nums){
            int size = nums.length;
            int[][]DP = new int[size][size + 1];

            for(int[]row : DP)
                Arrays.fill(row,-1);

            return Solve(0,-1,nums,DP);
        }

        private static int Solve(int ind,int prev,int[]nums,int[][]DP){
            if(ind == nums.length)
                return 0;

            if(DP[ind][prev + 1] != -1)
                return DP[ind][prev + 1];

            int NotTake = Solve(ind + 1,prev,nums,DP);
            int Take = 0;

            if(prev == -1 || nums[ind] > nums[prev]){
                Take = 1 + Solve(ind + 1,ind,nums,DP);
            }

            return DP[ind][prev + 1] = Math.max(NotTake,Take);
        }
    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of longest increasing subsequence: " + Binary_Search.Subsequence(nums));

        System.out.println("Length of longest increasing subsequence using DP: " + Dynamic_Programming.Subsequence(nums));

    }
}
