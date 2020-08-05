package com.dk.learndemo.algorithm;

import java.util.Arrays;

/**
 * @author :zhudakang
 * @description : MNArrayRoute
 * @create : 2020/08/05
 */
public class MNArrayRoute {

    public static int uniquePaths(int m, int n) {
        //dp[i][j] 是到达 i, j 最多路径
        //但是为什么i= 0的时候 都要弄成1呢？
        //因为这是初始化过程最左边和最上面的都是1
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     *思路就是把上一行存起来，当前行左边 + 上一个行相同位置 就是结果
     * */
    public static int uniquePaths2(int m, int n) {
        //上一行数据
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }

    /**
     *
     * */
    public static void main(String[] args) {

        System.out.println(uniquePaths2(3, 3));
    }
}
