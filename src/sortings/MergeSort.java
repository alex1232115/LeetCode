package sortings;

import java.util.Arrays;

// да запомни ты уже наконец сортировки!!!
public class MergeSort {
    public static void main(String[] args) {
        int[] testArr = new int[]{5,25,1,0,-5,7,37};
        mergeSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, arr.length/2));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, arr.length/2, arr.length));

        int l = 0, r = 0, k = 0;
        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] <= rightArr[r]) {
                arr[k] = leftArr[l];
                l++;
            } else {
                arr[k] = rightArr[r];
                r++;
            }
            k++;
        }

        while (l < leftArr.length) {
            arr[k] = leftArr[l];
            l++;
            k++;
        }

        while (r < rightArr.length) {
            arr[k] = rightArr[r];
            r++;
            k++;
        }
        return arr;
    }
}
