import java.util.*;
public class Merge2Sorted_Array_LT88 {
    public static void MergeArrays(int[]nums1,int n,int[]nums2,int m){
        int p1 = n - 1;
        int p2 = m - 1;
        int p = n + m -1;

        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p--] = nums1[p1--];
            }
            else{
                nums1[p--] = nums2[p2--];
            }
        }
    }
    public static void main(String[]args){
        int[]nums1 = {1,2,3,0,0,0};

        int[]nums2 = {2,5,6};
        int n = nums1.length - nums2.length;

        int m = nums2.length;

        MergeArrays(nums1,n,nums2,m);

        for(int num:nums1){
            System.out.print(num+" ");
        }
    }


}
