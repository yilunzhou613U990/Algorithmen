package com.test.specialQ;

import org.junit.Test;

public class Test1 {


    private static int[] arr = null;

    public static void println(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        swap(a, 0, 1);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    @Test//荷兰国旗问题
    public void test() {
        int num = 5;
        int arr[] = {3, 0, 3, 4, 2, 5, 5, 6, 9, 6};
        int arr2[] = {3, 5, 6, 3, 4, 5, 2, 6, 9, 0};
        int p1 = 0;//左边小于区域
        int i = 0;
        int p2 = arr.length - 1;//右边大于区域
        while (i < arr2.length && i < p2 ) {
            if (num > arr2[i]) {

                swap(arr2, i, p1);
                i++;
                p1++;
            } else if (num < arr2[i]) {
                swap(arr2, i, p2);
                p2--;
            } else {
                i++;
            }
        }
        println(arr2);
    }
}


