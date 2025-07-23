import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int item1 = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                try {
                    int item2 = nums[j];
                    List<List<Integer>> newRes = twoSum(nums, j + 1, Math.subtractExact(target, Math.addExact(item1, item2)));
                    for (List<Integer> res : newRes) {
                        res.addFirst(item1);
                    }
                    result.addAll(newRes);
                } catch (ArithmeticException _) {}
            }
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
                    sols.add(new ArrayList<>(Arrays.asList(nums[startIndex - 1], l, r)));
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

//    public static void main(String[] args) {
//        System.out.println(new Solution18().fourSum(new int[]{1,0,-1,0,-2,2}, 0));
//    }
}