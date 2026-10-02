public class Move_Zero_LT283 {
    public static void moveZeroes(int[] nums) {
        int k = 0;
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

        public static void main(String[] args) {
            int[] nums = {0, 1, 0, 3, 12};
            moveZeroes(nums);

            for (int num : nums) {
                System.out.print(num + " ");
            }
        }
    }
