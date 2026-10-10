import java.util.*;
public class Four_Sum_LT18 {
    static class BetterApproach{
        public static List<List<Integer>> Four_Sum(int []nums,int target){
            int n = nums.length;

            Set<List<Integer>> ans = new HashSet<>();
            for(int first = 0; first < n; first++){
                for(int second = first +1; second<n; second++){
                    Set<Integer> set = new HashSet<>();
                    for(int third = second +1; third < n; third++){
                        int sum = nums[first] + nums[second];
                        sum += nums[third];
                        int fourth = target - sum;

                        if(set.contains(fourth)){
                            List<Integer> list = new ArrayList<>(
                                    Arrays.asList(
                                            nums[first],
                                            nums[second],
                                            nums[third],
                                            fourth
                                    ));
                            Collections.sort(list);
                            ans.add(list);
                        }
                        set.add(nums[third]);
                    }
                }
            }
            return new ArrayList<>(ans);
        }

    }

    static class Optimal_Approach{
        public static List<List<Integer>> Four_Sum(int[]nums,int target){
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            for(int first = 0; first < n; first++){
                if(first != 0 &&  nums[first] == nums[first-1]) continue;

                for(int second = first + 1; second < n; second++){

                    if(second > first + 1 && nums[second] == nums[second - 1]) continue;

                    int third = second + 1;
                    int fourth = n - 1;

                    while(third < fourth){
                        long sum = (long)nums[first];
                        sum+= nums[second];
                        sum+= nums[third];
                        sum+= nums[fourth];

                        if(sum < target) third++;
                        else if(sum > target) fourth--;
                        else{
                            ans.add(Arrays.asList(
                               nums[first],
                               nums[second],
                               nums[third],
                               nums[fourth]
                            ));
                            third++;
                            fourth--;
                            while(third < fourth && nums[third] == nums[third - 1]) third++;
                            while(third < fourth && nums[fourth] == nums[fourth + 1]) fourth--;
                        }
                    }
                }
            }
            return ans;
        }
    }
    public static void main(String[]args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> BetterSol = BetterApproach.Four_Sum(nums,target);

        for(List<Integer> quadruplet : BetterSol){
            System.out.println(quadruplet);
        }

        List<List<Integer>> OptimalSol = Optimal_Approach.Four_Sum(nums, target);

        for (List<Integer> quadruplet : OptimalSol) {
            System.out.println(quadruplet);
        }
    }
}
