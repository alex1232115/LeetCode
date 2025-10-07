package sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        int[] testArr = new int[]{5,25,1,0,-5,7,37};
        List<Integer> integers = quickSort(Arrays.stream(testArr).boxed().collect(Collectors.toList()));
        System.out.println(integers);
    }

    private static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        Random random = new Random();
        int pivot = arr.get(random.nextInt(arr.size()));

        List<Integer> lessList = new ArrayList<>();
        List<Integer> pivotList = new ArrayList<>();
        List<Integer> moreList = new ArrayList<>();

        for (Integer i: arr) {
            if (i < pivot) {
                lessList.add(i);
            } else if (i > pivot) {
                moreList.add(i);
            } else pivotList.add(i);
        }
        lessList = quickSort(lessList);
        moreList = quickSort(moreList);
        List<Integer> result = new ArrayList<>();
        result.addAll(lessList);
        result.addAll(pivotList);
        result.addAll(moreList);
        return result;
    }
}
