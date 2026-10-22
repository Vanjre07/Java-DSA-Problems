package Hard_Level;
import java.util.*;
public class MergeSort {
    public static void Merge(int nums[],int low,int high){

        if(low>= high){
            return;
        }

        int mid = (low+high)/2;
        Merge(nums,low,mid);
        Merge(nums,mid+1,high);
        DivideMerge(nums,low,mid,high);

    }

    public static void DivideMerge(int[]nums,int low,int mid,int high){
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                list.add(nums[left]);
                left++;
            }
            else{
                list.add(nums[right]);
                right++;
            }
        }

        while(left <= mid){
            list.add(nums[left]);
            left++;
        }

        while(right <= high){
            list.add(nums[right]);
            right++;
        }

       for(int i = low; i <= high; i++){
           nums[i] = list.get(i-low);
       }
    }

    public static void main(String[] args) {
        int[]nums = {38, 27, 43, 10};
        int n = nums.length;
        Merge(nums,0,n-1);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }
}
