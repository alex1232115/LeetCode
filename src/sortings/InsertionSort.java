package sortings;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] testArr = new int[]{5,25,1,0,-5,7,37};
        insertionSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    private static int[] insertionSort(int[] testArr) {
        for (int i = 1; i < testArr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (testArr[j] < testArr[j - 1]) {
                    int swap = testArr[j];
                    testArr[j] = testArr[j - 1];
                    testArr[j - 1] = swap;
                }
            }
        }
        return testArr;
    }
}
