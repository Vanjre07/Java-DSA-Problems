import java.util.*;
public class Candy_LT135 {
    public static int Candy(int[]rating){
        int n = rating.length;
        int []left = new int[n];
        Arrays.fill(left,1);

        for(int index = 1; index < n; index++){
            if(rating[index] > rating[index - 1]){
                left[index] = left[index - 1] + 1;
            }
        }

        int sum = Math.max(left[n - 1],1);
        int right = 1;

        for(int index = n - 2; index >= 0; index--){
            if(rating[index] > rating[index + 1]){
                right++;
            }
            else right = 1;

            sum += Math.max(left[index],right);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 2, 2};
        System.out.print(Candy(ratings));
    }
}
