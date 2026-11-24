import java.util.*;
public class Jump_Game2_LT45 {
    public static int Jump(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int jump = 0;

        while (r < n - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(i + nums[i], farthest);
            }
            l = r + 1;
            r = farthest;
            jump++;
        }

        return jump;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.print(Jump(nums));
    }
}