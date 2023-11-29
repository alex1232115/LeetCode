package SlidingWindow;

import java.util.Arrays;

public class SlidingWindow1658 {
    // https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

    public static void main(String[] args) {
        SlidingWindow1658 recursion = new SlidingWindow1658();
        System.out.println(recursion.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        System.out.println(recursion.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
    }

    public int minOperations(int[] nums, int x) {
        int sumArr = Arrays.stream(nums).sum();
        int target = sumArr - x;
        int max_len = 0, cur_sum = 0, left = 0;
        if (sumArr < x) {
            return -1;
        } else if (target == 0){
            return nums.length;
        }
        for (int right = 0; right < nums.length; right++) {
            cur_sum += nums[right];

            while (left <= right && cur_sum > target) {
                cur_sum -= nums[left];
                left +=1;
            }
            if (cur_sum == target) {
                max_len = Math.max(max_len, right - left + 1);
            }
        }
        if (max_len !=  0) {
            return nums.length - max_len;
        } else {
            return -1;
        }
    }
}
