package com.test.query;

import org.junit.Test;

import java.util.*;

public class Test1 {
    private static int[] arr = null;

    public static void println(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(5 >> 1);
    }

    static {
        int N = 5;
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

    }

    @Test
    public void testDichotomousSearch() {
        println(arr);
        // System.out.println(Collections.max(ints));
        System.out.println(process(arr, 0, arr.length - 1));

    }

    int dichotomousSearch(int[] arr, int out, int start, int end) {
        int middle = start + (end - start) >> 1;

        if (out > arr[middle]) {
            return dichotomousSearch(arr, out, middle + 1, end);
        } else if (out <= arr[middle]) {
            return dichotomousSearch(arr, out, start, middle - 1);
        } else {
            return middle;
        }

    }

    public int process(int[] arr, int L, int R) {
        int middle = L + ((R - L) >> 1);
        if (L == R) {
            return arr[L];
        }
        //A*O(N/b)+O(N^d)
        //log(b,a)>d O(N^log(b,a))
        int leftMax = process(arr, L, middle);//n/2
        int rightMax = process(arr, middle + 1, R);//n/2
        return Math.max(leftMax, rightMax);
    }

    public int summation(int result, int[] arr, int L, int R) {
        int middle = L + ((R - L) >> 1);
        if (L == R) {
            return 0;
        }
        return summation(result, arr, L, middle) + summation(result, arr, middle + 1, R) + mergeResult(result, arr, L, R, middle);
    }

    public int mergeResult(int result, int[] arr, int L, int R, int m) {
        int p1 = L;
        int p2 = m + 1;
        int[] help = new int[R - L + 1];
        int i = 0;
        while (p1 <= m && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                result += (R - p2 + 1) * arr[p1];
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= m)
            help[i++] = arr[p1++];
        while (p2 <= R)
            help[i++] = arr[p2++];
        for (int x = 0; x < help.length; x++) {
            arr[L + x] = help[x];
        }
        return result;
    }

    public String reverseCouple(List<Map<Integer, Integer>> reverseCouple, int L, int R, int[] arr) {
        int middle = L + ((R - L) >> 1);
        if (L == R) {
            return "";
        }

        return reverseCouple(reverseCouple, L, middle, arr) + reverseCouple(reverseCouple, middle + 1, R, arr) + mergeResult(reverseCouple, L, R, arr, middle);
    }

    public String mergeResult(List<Map<Integer, Integer>> reverseCouple, int L, int R, int[] arr, int middle) {
        int p1 = L;
        int p2 = middle + 1;
        int i = 0;
        String temp = "";
        int[] help = new int[R - L + 1];
        while (p1 <= middle && p2 <= R) {
            if (arr[p1] < arr[p2]) {

                temp += "{" + arr[p2] + "," + arr[p1] + "}";


                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int x = 0; x < help.length; x++) {
            arr[L + x] = help[x];
        }
        return temp;
    }

    @Test
    public void testSummation() {
        int xxx[] = {1, 3, 4, 2, 5};

        ;
        System.out.println(reverseCouple(null, 0, arr.length - 1, xxx));
        println(xxx);
    }
}
