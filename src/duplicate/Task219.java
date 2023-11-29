package duplicate;

import java.util.HashSet;
import java.util.Set;

public class Task219 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3}, 0));
        System.out.println(containsNearbyDuplicate(new int[]{1, 1, 9, 2, 2, 6}, 2));
        System.out.println(containsNearbyDuplicate(new int[]{1}, 5));

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> digits = new HashSet<>();

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (digits.contains(nums[j])) {
                return true;
            } else {
                digits.add(nums[j]);
            }

            if (Math.abs(i - j) >= k) {
                digits.remove(nums[i]);
                i++;
            }
        }

        return false;
    }
}
