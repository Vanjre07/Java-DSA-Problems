public class Remove_Duplicates_LT26 {
    public static int removeDuplicates(int[] nums) {
        int index= 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};

        int k = removeDuplicates(nums);

        System.out.println("k = " + k);

        for (int index = 0; index < k; index++) {
            System.out.print(nums[index] + " ");
        }
    }
}
