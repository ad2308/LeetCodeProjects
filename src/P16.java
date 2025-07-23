import java.util.Arrays;

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int
                closest = -1, //Placeholder value
                closestDist = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length - 2; start++) {
            int item = nums[start];
            int thisClosest = item + twoSumClosest(nums, start + 1, target - item);
            int thisClosestDist = Math.abs(thisClosest - target);
            if (thisClosestDist < closestDist) {
                closestDist = thisClosestDist;
                closest = thisClosest;
            }
        }
        return closest;
    }

    private int twoSumClosest(int[] nums, int startIndex, int target) {
        int
                left = startIndex,
                right = nums.length - 1,
                closest = -1, //Placeholder value
                closestDist = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];
            int dist = Math.abs(sum - target);
            if (dist < closestDist) {
                closest = sum;
                closestDist = dist;
            }
            if (sum <= target) {
                left++;
            } else {
                right--;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}