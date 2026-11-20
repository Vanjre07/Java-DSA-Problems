import java.util.*;
public class Assign_Cookies_LT455 {
    private static int Assign(int[]greed,int[]Size){
        Arrays.sort(greed);
        Arrays.sort(Size);

        int left = 0;
        int right = 0;

        int size = Size.length;

        while(left < size && right < greed.length){
            if(Size[left] >= greed[right]){
                left++;
                right++;
            }
            else{
                left++;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        int[] greed = {4,2,1,2,1,3};
        int[] cookieSizes = {1,5,3,3,4};

        int contentChildren = Assign(greed, cookieSizes);
        System.out.println("Maximum number of content children: " + contentChildren);
    }
}
