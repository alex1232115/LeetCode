package sortings;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] testArr = new int[]{5,25,1,0,-5,7,37};
        selectionSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    private static int[] selectionSort(int[] testArr) {
        int n = testArr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (testArr[j] < testArr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int swap = testArr[minIndex];
                testArr[minIndex] = testArr[i];
                testArr[i] = swap;
            }
        }
        return testArr;
    }
}
