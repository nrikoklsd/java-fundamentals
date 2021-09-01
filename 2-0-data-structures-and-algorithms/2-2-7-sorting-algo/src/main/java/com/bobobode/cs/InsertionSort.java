package com.bobobode.cs;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 3, 1, 8, 7, 2, 4};

        var sortedArray = sort(array);
        Arrays.stream(sortedArray).forEach(System.out::print);
    }

    private static int[] sort(int[] array) {


        for (int i = 1; i < array.length; i++) {
            int current = array[i];

            int marker = i - 1;

            while (marker >= 0 && current < array[marker]) {
                array[marker + 1] = array[marker];
                marker--;
            }

            array[marker + 1] = current;
        }
        return array;
    }


}


