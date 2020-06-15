package com.dk.learndemo.algorithm.str;

/**
 * @author :zhudakang
 * @description : IsMonotonic
 * @create : 2020/06/15
 */
public class IsMonotonic {

    /**
     * 是否单调递增  或者单调递减
     */
    public static boolean isMonotonic(int[] A) {
        boolean up = true;
        boolean down = true;
        int temp = A[0];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > temp && up) {
                //这边已经是严格的递增了
                down = false;
                temp = A[i];
            } else if (A[i] < temp && down) {
                up = false;
                temp = A[i];
            } else if (A[i] == temp) {
                //do nothing
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{
                6, 5, 4, 4
        };
        System.out.println(isMonotonic(A));
    }
}
