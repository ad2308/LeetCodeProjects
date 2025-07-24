import java.util.Arrays;

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int dest_i = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[dest_i] = nums[i];
                dest_i++;
            }
        }
        return dest_i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        System.out.println(new Solution27().removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));
    }
}