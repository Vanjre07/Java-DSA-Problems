import java.util.*;
public class Three_Sum_15 {

    //Brute Force -> It only work for limited cases only, for other cases it Time limit will Exceed
    static class Brute_Force{
        public List<List<Integer>> threeSum(int[] nums) {
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
        public static List<List<Integer>> ThreeSum(int nums[]){
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
    public static void main(String[]args){

    }
}
