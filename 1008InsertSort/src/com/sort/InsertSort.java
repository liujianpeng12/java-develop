package com.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] elem = {0, 9, 1, 5, 8, 3, 7, 4, 6, 2};
        //int[] elem = {0, 5, 3, 4, 6, 2};
        insertSort(elem);

        System.out.println(Arrays.toString(elem));
    }

    public static void insertSort(int[] elem) {
        for (int i = 2; i < elem.length; i++) {
            if(elem[i] < elem[i - 1]) {
                elem[0] = elem[i];
                int j;
                for (j = i - 1; elem[j] > elem[0]; j--) {
                    elem[j + 1] = elem[j];
                }
                elem[j + 1] = elem[0];
            }
        }
    }
}
