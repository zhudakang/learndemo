package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : MinDeletionSize
 * @create : 2020/07/18
 */
public class MinDeletionSize {

    public static int minDeletionSize (String[] A) {
        int res = 0;
        if(null == A || A.length == 0 ||A.length == 1){
            return res;
        }
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length -1 ; j++) {
                if(A[j-1].charAt(i) > A[j].charAt(i)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static int minDeletionSize2 (String[] A) {
        int res = 0;
        if(null == A || A.length == 0 ||A.length == 1){
            return res;
        }
        for (int i = 0; i < A[0].length(); i++) {
            if(judge(A, i)){
                res ++;
            }else {
                break;
            }
        }
        return res;
    }

    private static boolean judge(String[] A, int index){
        char c = A[0].charAt(index);
        for (int j = 0; j < A.length -1 ; j++) {
            if(A[j].charAt(index) < c){
                return true;
            }
            c = A[j].charAt(index);
        }
        return false;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"zyx","wvu","tsr"};
        String[] B = new String[]{"ca","bb","ac"};
        String[] C = new String[]{"xc","yb","za"};
        System.out.println(minDeletionSize2(A));
        System.out.println(minDeletionSize2(B));
        System.out.println(minDeletionSize2(C));
    }
}
