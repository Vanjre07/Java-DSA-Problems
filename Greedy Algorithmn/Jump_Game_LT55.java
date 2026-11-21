import java.util.*;
public class Jump_Game_LT55 {
    private static boolean Jump(int[]nums){
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max,i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int[]nums = {2,3,1,1,4};
        System.out.print(Jump(nums));
    }
}
