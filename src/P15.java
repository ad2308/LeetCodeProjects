import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> result = new HashSet<>();
        for (int start = 0; start < nums.length - 2; start++) {
            result.addAll(twoSum(nums, start + 1, -1 * nums[start]));
        }
        return new ArrayList<>(result);
    }

    private List<List<Integer>> twoSum(int[] nums, int startIndex, int target) {
        int left = startIndex, right = nums.length - 1;
        List<List<Integer>> sols = new ArrayList<>();
        while (left < right) {
            int l = nums[left], r = nums[right];
            if (l + r <= target) {
                if (l + r == target) {
                    sols.add(Arrays.asList(nums[startIndex - 1], l, r));
                }
                do {
                    left++;
                } while (left < right && nums[left - 1] == nums[left]);
            } else {
                do {
                    right--;
                } while (left < right && nums[right + 1] == nums[right]);
            }
        } return sols;
    }

    public static void main(String[] args) {
        System.out.println(new Solution15().threeSum(new int[]{-2,0,1,1,2}));
    }
}