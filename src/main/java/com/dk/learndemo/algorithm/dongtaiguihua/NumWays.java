package com.dk.learndemo.algorithm.dongtaiguihua;

/**
 * @author :zhudakang
 * @description : NumWays
 * @create : 2020/07/01
 */
public class NumWays {

    /**
     * 青蛙跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 设跳上 nn 级台阶有 f(n)种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2级台阶。
     * 当为 1 级台阶： 剩 n-1个台阶，此情况共有 f(n-1) 种跳法；
     * 当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
     *
     * f(n)f(n) 为以上两种情况之和，即 f(n)=f(n-1)+f(n-2)f(n)=f(n−1)+f(n−2) ，以上递推性质为斐波那契数列。本题可转化为 求斐波那契数列第 nn 项的值 ，与 面试题10- I. 斐波那契数列 等价，唯一的不同在于起始数字不同。
     * 青蛙跳台阶问题： f(0)=1f(0)=1 , f(1)=1f(1)=1 , f(2)=2f(2)=2 ；
     * 斐波那契数列问题： f(0)=0f(0)=0 , f(1)=1f(1)=1 , f(2)=1f(2)=1 。
     *
     * 以斐波那契数列性质 f(n + 1) = f(n) + f(n - 1) 为转移方程。
     */
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
