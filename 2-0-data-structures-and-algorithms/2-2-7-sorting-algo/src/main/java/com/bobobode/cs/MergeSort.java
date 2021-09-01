package com.bobobode.cs;

import lombok.NonNull;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 3, 1, 8, 7, 2, 4, 9};

        var sortedArray = sort(array);
        Arrays.stream(sortedArray).forEach(System.out::print);
    }

    private static int[] sort(@NonNull int[] array) {

        if (array.length == 1) {
            return array;
        } else {

            int[] arrayLeft = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] arrayRight = Arrays.copyOfRange(array, array.length / 2, array.length);

            arrayLeft = sort(arrayLeft);
            arrayRight = sort(arrayRight);

            Arrays.stream(arrayLeft).forEach(System.out::print);
            Arrays.stream(arrayRight).forEach(System.out::print);
            System.out.println();

            return merge(arrayLeft, arrayRight);
        }

    }

    private static int[] merge(int[] arrayL, int[] arrayR) {
        int[] result = new int[arrayL.length + arrayR.length];

        int leftIndex = 0;
        int rightIndex = 0;

        int mergedIndex = 0;

        while (leftIndex < arrayL.length && rightIndex < arrayR.length) {
            if (arrayL[leftIndex] < arrayR[rightIndex]) {
                result[mergedIndex] = arrayL[leftIndex];
                leftIndex++;
            } else {
                result[mergedIndex] = arrayR[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < arrayL.length) {
            result[mergedIndex] = arrayL[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        while (rightIndex < arrayR.length) {
            result[mergedIndex] = arrayR[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

        return result;

    }
}
