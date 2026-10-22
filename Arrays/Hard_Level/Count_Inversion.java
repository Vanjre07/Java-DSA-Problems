package Hard_Level;
import java.util.*;

public class Count_Inversion {
    public static int countInversion( int[]nums){
        int n = nums.length;
        int count = MergeSort(nums,0,n-1);
        return count;
    }

    public static int MergeSort(int[]nums,int low,int high){
        int mid = (low+high)/2;
        int count = 0;
        if(low >= high){
            return count;
        }
        count += MergeSort(nums,low,mid);
        count += MergeSort(nums,mid+1,high);
        count +=DivideMerge(nums,low,mid,high);

        return count;
    }

    public static int DivideMerge(int[]nums,int low,int mid,int high){
        int count = 0;
        List<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                list.add(nums[left]);
                left++;
            }
            else{
                list.add(nums[right]);
                count += mid- left+1;
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
            nums[i] = list.get( i - low);
        }
        return count;
    }

    public static void main(String[] args) {
        int []arr = {8, 4, 2, 1, 5, 3, 7, 6};

        System.out.print(countInversion(arr));
    }
}
