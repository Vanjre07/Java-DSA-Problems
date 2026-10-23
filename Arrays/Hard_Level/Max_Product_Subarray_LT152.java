package Hard_Level;
import java.util.*;
public class Max_Product_Subarray_LT152 {
    public static int ProductSubarray(int[]nums){
        int n = nums.length;
        int res = 1;
        int pre = 1;
        int suf = 1;

        for(int index = 0; index < n; index++){
            if(suf == 0)    suf = 1;
            if(pre == 0)    pre =1;

            pre = pre * nums[index];
            suf = suf * nums[n - index - 1];
            res = Math.max(res, Math.max(pre,suf));
        }

        return res;
    }

    public static void main(String[] args) {
        int[]nums = {2,3,-2,4};

        System.out.print(ProductSubarray(nums));
    }
}
