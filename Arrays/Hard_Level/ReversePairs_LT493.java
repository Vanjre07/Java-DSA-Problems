package Hard_Level;
import java.util.*;
public class ReversePairs_LT493 {
    public static int CountReversePair(int[]nums){
        int n = nums.length;

        int count = MergeSort(nums,0,n -1);
        return count;
    }

    public static int MergeSort(int[]nums,int low,int high){
        int count = 0;

        if(low >= high){
            return count;
        }
        int mid = (low + high)/2;

        count += MergeSort(nums,low,mid);
        count += MergeSort(nums,mid+1,high);
        count += CountPairs(nums,low,mid,high);
        DivideMerge(nums,low,mid,high);

        return count;

    }

    public static int CountPairs(int[]nums,int low,int mid,int high){
        int right = mid+1;
        int count = 0;
        for(int index = low; index<= mid; index++){
            while(right <= high && nums[index] > (2 * nums[right])){
                right++;
            }
            count += (right - (mid +1));
        }

        return count;
    }

    public static void DivideMerge(int[]nums,int low,int mid,int high){
        int left = low;
        int right = mid+1;
        List<Integer> list = new ArrayList<>();
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

        for(int index = low; index <= high; index++){
            nums[index] = list.get(index - low);
        }
    }
    public static void main(String[] args) {
        int[]nums = {10, 5, 2, 6, 1, 8, 3, -2};

        System.out.print(CountReversePair(nums));
    }
}
