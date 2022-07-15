package com.test.sorting;

import org.junit.Test;

import java.util.*;


public class Test1 {
    private static int[] arr = null;

    static {
        int N = 10;
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

    }


    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


    public void println(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    @Test
    public void bubbleSort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int e = 0; e < i; e++) {
                if (arr[e] > arr[e + 1]) {
                    swap(arr, e, e + 1);
                }
            }
        }
        println(arr);
    }

    @Test
    public void selectionSort() {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    int temp = min;
                    min = arr[j];
                    arr[j] = temp;
                }
            }
        }
        println(arr);
    }


    public int singleOddNumberOfOccurrences(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        return eor;
    }

    public int[] twiceOddNumberOfOccurrences(int[] arr) {
        int eor = 0;
        int $eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        /**
         * 001000
         * 110111
         * 111000
         */
        int rightOne = eor & (~eor + 1);//取最右边的1
        for (int i = 0; i < arr.length; i++) {
            if ((rightOne & arr[i]) == 1) {
                $eor ^= arr[i];
            }
        }
        int a = $eor;
        int b = eor ^ $eor;
        return new int[]{a, b};
    }

    @Test
    public void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
        println(arr);
    }

    public void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, R, mid);
    }

    private void merge(int[] arr, int L, int R, int m) {
        int help[] = new int[R - L + 1];
        int p1 = L;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L] = help[j];
            L++;
        }
    }

    @Test
    public void testMergeSort() {
        int middle = 0 + (arr.length - 1 - 0) >> 1;
        merge(arr, 0, arr.length - 1, middle);
        println(arr);
    }

    //快排1.0
    public void quickSortV1(int[] arr, int L, int R) {
        if (L < R) {
            int p1 = L;
            int p2 = R;
            int i = L;
            int num = arr[R];

            while (i <= R && i < p2) {
                if (num > arr[p1]) {
                    swap(arr, i, p1);
                    p1++;
                    i++;
                } else {
                    p2--;
                    swap(arr, i, p2);
                }
            }

            swap(arr, i, R);

            quickSortV1(arr, L, i - 1);
            quickSortV1(arr, i + 1, R);
        }
    }

    //快排2.0
    public void quickSortV2(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partion(arr, L, R);
            quickSortV2(arr, L, p[0] - 1);
            quickSortV2(arr, p[1] + 1, R);
        }
    }

    private int[] partion(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    @Test
    public void testQuickSort() {
        List<Integer> integers = Arrays.asList(2, 10, 5, 3, 19, 19, 19, 19, 19, 86);
        Collections.shuffle(integers);
        int[] abc = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            abc[i] = integers.get(i);
        }

        quickSortV2(abc, 0, abc.length - 1);
        println(abc);
    }
}
