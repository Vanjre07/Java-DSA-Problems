import java.util.Arrays;

public class Partition_Equal_Subset_Sum_LT416 {
    public static boolean Subset(int[]arr){
        int size = arr.length;
        int sum = 0;

        for(int index = 0; index < size; index++)
            sum += arr[index];

        if (size == 0)
            return true;

        if(sum % 2 != 0)
            return false;

        int target = sum / 2;

        int[][]DP = new int[size][target + 1];

        for(int []row : DP)
            Arrays.fill(row, -1);

        return Calculate(size - 1,target,arr,DP);
    }

    private static boolean Calculate(int ind,int target,int []arr,int[][]DP){
        if(target == 0)
            return true;

        if(ind == 0)
            return arr[0] == target;

        if(DP[ind][target] != -1)
            return DP[ind][target] == 1;

        boolean NotTaken  = Calculate(ind - 1,target,arr,DP);
        boolean taken  = false;

        if(arr[ind] <= target){
            taken = Calculate(ind - 1,target -arr[ind],arr,DP);
        }

        DP[ind][target] = taken || NotTaken ? 1 : 0;

        return DP[ind][target] == 1;
    }
    public static void main(String[] args) {
        int[]arr = {1,5,11,5};

        System.out.println(Subset(arr));
    }
}
