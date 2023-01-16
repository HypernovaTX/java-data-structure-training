package com.hypernova.sorttest;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Bubble SORT =====");
        int[] array0 = generateArray(-99, 99);
        long timer0 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array0));
        bubbleSort(array0);
        System.out.println("after: " + Arrays.toString(array0));
        System.out.println("Execution time: " + (currentTimeMillis() - timer0) + "ms");
        System.out.println(" ");

        System.out.println("===== Selection SORT =====");
        int[] array1 = generateArray(-99, 99);
        long timer1 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array1));
        selectionSort(array1);
        System.out.println("after: " + Arrays.toString(array1));
        System.out.println("Execution time: " + (currentTimeMillis() - timer1) + "ms");
        System.out.println(" ");

        System.out.println("===== Insertion SORT =====");
        int[] array2 = generateArray(-99, 99);
        long timer2 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array2));
        insertionSort(array2);
        System.out.println("after: " + Arrays.toString(array2));
        System.out.println("Execution time: " + (currentTimeMillis() - timer2) + "ms");
        System.out.println(" ");

        System.out.println("===== Insertion SORT (recursive) =====");
        int[] array2b = generateArray(-99, 99);
        long timer2b = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array2b));
        insertionSortRecursive(array2b, array2b.length);
        System.out.println("after: " + Arrays.toString(array2b));
        System.out.println("Execution time: " + (currentTimeMillis() - timer2b) + "ms");
        System.out.println(" ");

        System.out.println("===== Shell SORT =====");
        int[] array3 = generateArray(-99, 99);
        long timer3 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array3));
        shellSort(array3);
        System.out.println("after: " + Arrays.toString(array3));
        System.out.println("Execution time: " + (currentTimeMillis() - timer3) + "ms");
        System.out.println(" ");

        System.out.println("===== Merge SORT =====");
        int[] array4 = generateArray(-99, 99);
        long timer4 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array4));
        mergeSort(array4, 0, array4.length);
        System.out.println("after: " + Arrays.toString(array4));
        System.out.println("Execution time: " + (currentTimeMillis() - timer4) + "ms");
        System.out.println(" ");

        System.out.println("===== Quick SORT =====");
        int[] array5 = generateArray(-99, 99);
        long timer5 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array5));
        quickSort(array5, 0, array5.length);
        System.out.println("after: " + Arrays.toString(array5));
        System.out.println("Execution time: " + (currentTimeMillis() - timer5) + "ms");
        System.out.println(" ");

        System.out.println("===== Counting SORT =====");
        int[] array6 = generateArray(-9, 9);
        long timer6 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array6));
        countingSort(array6, -9, 9);
        System.out.println("after: " + Arrays.toString(array6));
        System.out.println("Execution time: " + (currentTimeMillis() - timer6) + "ms");
        System.out.println(" ");

        System.out.println("===== Radix SORT =====");
        int[] array7 = generateArray(0, 9999);
        long timer7 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array7));
        radixSort(array7, 10, 4);
        System.out.println("after: " + Arrays.toString(array7));
        System.out.println("Execution time: " + (currentTimeMillis() - timer7) + "ms");
        System.out.println(" ");

        System.out.println("===== Bucket SORT =====");
        int[] array8 = generateArray(0, 99);
        long timer8 = currentTimeMillis();
        System.out.println("before: " + Arrays.toString(array8));
        bucketSort(array8);
        System.out.println("after: " + Arrays.toString(array8));
        System.out.println("Execution time: " + (currentTimeMillis() - timer8) + "ms");
        System.out.println(" ");

        System.out.println("==========");
        int testNumber = 4;
        int rFactorial = recursiveFactorial(testNumber);
        int iFactorial = iterativeFactorial(testNumber);
        System.out.println("Number: " + testNumber);
        System.out.println("Recursive Factorial: " + rFactorial);
        System.out.println("Iterative Factorial: " + iFactorial);
    }

    /**
     * Sorting mechanisms
     */
    private static void bubbleSort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex --) {
            for (int i = 0; i < lastUnsortedIndex; i ++) {
                // Stable sorting logics
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }
    private static void selectionSort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex --) {
            int largestIndex = 0;
            for (int i = 0; i <= lastUnsortedIndex; i ++) {
                // unstable sorting logics regardless how it is implemented
                largestIndex = array[largestIndex] > array[i] ? largestIndex : i;
            }
            // int[] before = array.clone();
            swap(array, largestIndex, lastUnsortedIndex);
            // System.out.println("-" + Arrays.toString(before) +  " => " + Arrays.toString(array) + " | lastLargeI = " + lastLargestIndex);
        }
    }
    private static void insertionSort(int[] array) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex ++) {
            int i;
            int newElement = array[firstUnsortedIndex];
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i --) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
    }

    private static void insertionSortRecursive(int[] input, int numItems) {
        if (numItems < 2) {
            return;
        }
        insertionSortRecursive(input, numItems - 1);

        int newElement = input[numItems - 1];
        int i;
        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i --) {
            input[i] = input[i - 1];
        }
        input[i] = newElement;
    }

    private static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i ++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void quickSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(array, start, end);
        quickSort(array, start, pivotIndex);
        quickSort(array, pivotIndex + 1, end);
    }

    private static void countingSort(int[] array, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < array.length; i ++) {
            countArray[array[i] - min] ++;
        }
        int j = 0;
        for (int i = min; i <= max; i ++) {
            while (countArray[i - min] > 0) {
                array[j ++] = i;
                countArray[i - min] --;
            }
        }
    }

    private static void radixSort(int[] array, int radix, int width) {
        for (int i = 0; i < width; i ++) {
            radixSingleSort(array, i, radix);
        }
    }

    /**
     * Util
     */
    private static int[] generateArray(int min, int max) {
        int[] intArray = new int[15];
        for (int i = 0; i < intArray.length; i ++) {
            intArray[i] = ThreadLocalRandom.current().nextInt(min, max);
        }
        return intArray;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            // If <= replaced with <, this will be an unstable sorting
            temp[tempIndex ++] = input[i] <= input[j] ? input[i ++] : input[j ++];
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && input[-- j] >= pivot); // Empty loop body
            if (i < j) {
                input[i] = input[j];
            }

            while (i < j && input[++ i] <= pivot); // Empty loop body
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }

    private static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];
        for (int value: input) {
            countArray[getDigit(position, value, radix)] ++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j ++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex --) {
            temp[-- countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex ++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    private static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];
        for (int i = 0; i < buckets.length; i ++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int j = 0; j < input.length; j ++) {
            buckets[hash(input[j])].add(input[j]);
        }
        for (List bucket: buckets) {
            Collections.sort(bucket);
        }

        int l = 0;
        for (int k = 0; k < buckets.length; k ++) {
            for (int value: buckets[k]) {
                input[l ++] = value;
            }
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    /**
     * Etc
     */
    private static int iterativeFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        int factorial = 1;
        for (int i = 1; i <= num; i ++) {
            factorial *= i;
        }
        return factorial;
    }
    private static int recursiveFactorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }

    private static int hash(int value) {
        return value / (int) 10 % 10;
    }
}
