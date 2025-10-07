package YandexList;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/maximize-distance-to-closest-person/description/">849. Maximize Distance to Closest Person</a>
 */
public class MaximizeDistancetoClosestPerson {
    public static void main(String[] args) {
        int[][] arr = new int[][]{};
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        System.out.println(maxDistToClosest(new int[] {1,0,0,0}));
    }


    public static int maxDistToClosest(int[] seats) {
        int maxDist = -1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int curMaxDist = findDist(i, seats);
                maxDist = Math.max(curMaxDist, maxDist);
            }
        }
        return maxDist;
    }

    private static int findDist(int curSeat, int[] seats) {
        int leftDist = 0;
        for (int i = curSeat; i >= 0; i--) {
            if (seats[i] == 1) {
                break;
            }
            leftDist++;
        }

        int rightDist = 0;
        for (int i = curSeat; i < seats.length - 1; i++) {
            if (seats[i] == 1) {
                break;
            }
            rightDist++;
        }
        if (leftDist == 0) return rightDist;
        if (rightDist == 0) return leftDist;
        return Math.min(leftDist, rightDist);
    }
}
