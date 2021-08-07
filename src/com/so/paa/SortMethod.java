package com.so.paa;

import java.time.LocalDateTime;

public class SortMethod {


    public static void insertionSort(int[] arr) {

        LocalDateTime startTime = LocalDateTime.now();

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int aux = arr[i];
            int j = i - 1;
            Details.addComparitions();

            while ((j > -1) && (arr[j] > aux)) {
                Details.addComparitions();

                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = aux;
            Details.addMoviment();

        }

        Details.setTime(startTime);

    }


    public static void selectionSort(int arr[]) {

        int n = arr.length;

        LocalDateTime startTime = LocalDateTime.now();

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                Details.addComparitions();
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int aux = arr[min_idx];
            Details.addMoviment();
            arr[min_idx] = arr[i];
            Details.addMoviment();
            arr[i] = aux;
            Details.addMoviment();
        }

        Details.setTime(startTime);
    }


    public static void mergeSort(int arr[]){

        LocalDateTime startTime = LocalDateTime.now();

        mergeSort(arr, arr.length);

        Details.setTime(startTime);
    }


    public static void mergeSort(int[] arr, int n) {

        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            Details.addMoviment();
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            Details.addMoviment();
            right[i - mid] = arr[i];
        }
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(arr, left, right, mid, n - mid);
    }

    public static void merge(
            int[] arr, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            Details.addComparitions();
            Details.addMoviment();
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < left) {
            Details.addMoviment();
            arr[k++] = l[i++];
        }
        while (j < right) {
            Details.addMoviment();
            arr[k++] = r[j++];
        }

    }

}
