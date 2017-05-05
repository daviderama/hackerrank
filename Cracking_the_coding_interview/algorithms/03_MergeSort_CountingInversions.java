// Merge Sort: Counting Inversions
// https://www.hackerrank.com/challenges/ctci-merge-sort

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long countInversions(int[] array){
        int[] temp = array.clone();
        return mergeSort(array, temp, 0, array.length-1);
    }

    public static long mergeSort(int[] array, int[] temp, int leftStart, int rightEnd){
        if(leftStart >= rightEnd) return 0;

        int middle = (leftStart + rightEnd)/2;
        long count = 0;
        count += mergeSort(temp, array, leftStart, middle);
        count += mergeSort(temp, array, middle+1, rightEnd);
        count += mergeHalves(array, temp, leftStart, rightEnd, middle);

        return count;
    }

    public static long mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd, int middle){
        long count = 0;

        int left = leftStart;
        int right = middle+1;
        int index = leftStart;

        while(left <= middle || right <= rightEnd){
            if(left > middle){
                array[index++] = temp[right++];
            }
            else if(right > rightEnd){
                array[index++] = temp[left++];
            }
            else if(temp[left] <= temp[right]){
                array[index++] = temp[left++];
            }
            else {
                array[index++] = temp[right++];
                count += middle + 1 - left;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }
}
