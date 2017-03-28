// Arrays: Left Rotation
// https://www.hackerrank.com/challenges/ctci-array-left-rotation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /* Solution found reasoning on paper
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int i = a.length-1;
        int j;
        int[] result = new int[n];

        while( i >= 0 ) {
            j = i - k;
            if( j < 0 )
                j = n + j;

            result[j] = a[i];
            i--;
        }

        return result;
    }*/

    // Solution found when realized that was actually modular arithmetic
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int j;
        int[] result = new int[n];
        for( int i=0; i < a.length; i++ ){
            j = (i + k) % n;

            result[i] = a[j];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}
