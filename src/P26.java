import java.util.Arrays;

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int prev_val = nums[0];
        int dest_i = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr_val = nums[i];
            if (curr_val != prev_val) {
                nums[++dest_i] = curr_val;
                prev_val = curr_val;
            }
        }
        return dest_i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Solution26().removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}