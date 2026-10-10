import java.util.*;
public class Three_Sum_15 {

    //Brute Force -> It only work for limited cases only, for other cases it Time limit will Exceed
    static class Brute_Force{
        public static List<List<Integer>> Three_Sum(int[] nums) {
            Set<List<Integer>> list = new HashSet<>();

            for(int i=0; i<nums.length; i++){
                for(int j = i+1; j< nums.length; j++){
                    for(int k = j+1; k<nums.length; k++){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> set = new ArrayList<>();
                            set.add(nums[i]);
                            set.add(nums[j]);
                            set.add(nums[k]);

                            Collections.sort(set);
                            list.add(set);
                        }
                    }
                }
            }
            return new ArrayList<>(list);
        }
    }


    //Better Approach -> It also takes too much time, but it will run "NOT RECOMMENDED"
    static class Better_Approach{
        public static List<List<Integer>> Three_Sum(int nums[]){
            Set<List<Integer>> Unique = new HashSet<>();

            for(int first = 0; first < nums.length; first++){
                int target = - nums[first];
                Set<Integer> SeenValue = new HashSet<>();

                for(int second = first + 1; second < nums.length; second++){
                    int third = target - nums[second];

                    if(SeenValue.contains(third)){
                        List<Integer> TripLets = new ArrayList<>(
                                Arrays.asList(nums[first],
                                        nums[second],
                                        third)
                        );
                        Collections.sort(TripLets);
                        Unique.add(TripLets);
                    }
                    SeenValue.add(nums[second]);
                }

            }
            return new ArrayList<>(Unique);
        }
    }

    static class Optimal_Solution{
        public static List<List<Integer>> Three_Sum(int []nums){

            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();

            for(int first = 0; first < n; first++){

                int second = first + 1;
                int third = n - 1;

                if(first > 0 && nums[first] == nums[first - 1]) continue;

                while(second < third){
                    int sum = nums[first] + nums[second] + nums[third];

                    if(sum < 0) second ++;

                    else if(sum > 0)    third--;

                    else{
                        ans.add(
                                Arrays.asList(
                                        nums[first],
                                        nums[second],
                                        nums[third]
                                )
                        );
                        second++;
                        third--;

                        while(second < third && nums[second] == nums[second - 1])   second++;
                    }
                }
            }
            return ans;
        }
    }
    public static void main(String[]args){
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> BruteForceSol = Brute_Force.Three_Sum(nums);
        for (List<Integer> triplet : BruteForceSol) {
            System.out.println(triplet);
        }

        List<List<Integer>> BetterSol = Better_Approach.Three_Sum(nums);
        for (List<Integer> triplet : BetterSol) {
            System.out.println(triplet);
        }

        List<List<Integer>> OptimalSol = Optimal_Solution.Three_Sum(nums);
        for (List<Integer> triplet : OptimalSol) {
            System.out.println(triplet);
        }

    }
}
