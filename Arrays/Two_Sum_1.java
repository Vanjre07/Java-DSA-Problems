import java.lang.reflect.Array;
import java.util.*;
public class Two_Sum_1 {
    static class Brute_Force{
        public static int[] TwoSum(int[]nums,int target){

            for(int i=0; i<nums.length - 1; i++){
                for(int j = 1; j < nums.length; j++){
                    if(nums[i] + nums[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{-1,-1};
        }
    }

    static class Optimal{
        public static int[] TwoSum(int[]nums,int target){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];

                int compliment = target - num;

                if(map.containsKey(compliment)){
                    return new int[]{map.get(compliment),i};
                }
                map.put(nums[i],i);
            }
            return new int[]{-1,-1};
        }
    }
    public static void main(String[]args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(Brute_Force.TwoSum(nums,target)));
        System.out.println(Arrays.toString(Optimal.TwoSum(nums,target)));

    }
}
