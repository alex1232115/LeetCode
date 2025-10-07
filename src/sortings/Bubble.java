package sortings;

import java.util.Arrays;

public class Bubble {

    public static void main(String[] args) {
        int[] testArr = new int[]{5,25,1,0,-5,7,37};
        bubbleSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    private static int[] bubbleSort(int[] testArr) {
        for (int i = 1; i < testArr.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < testArr.length - i; j++) {
                if (testArr[j] > testArr[j + 1]) {
                    int swap = testArr[j];
                    testArr[j] = testArr[j + 1];
                    testArr[j + 1] = swap;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        return testArr;
    }
}
