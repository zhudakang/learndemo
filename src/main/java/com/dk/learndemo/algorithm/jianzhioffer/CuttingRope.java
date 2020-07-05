package com.dk.learndemo.algorithm.jianzhioffer;

/**
 * @Author : zhudakang@situdata.com
 * @Description :
 * @Date : 2020/7/5
 */
public class CuttingRope {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 等同：给定一个正整数 n，将其拆分为至少两个正整数的和，
     * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
     * */
    public int cuttingRope(int n) {
        //这道题有公知：切成为3的段是最好的，然后尽可能切得多，剩下不为三的乘起来
        if (n <= 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int number;
        int count = 1;
        while (n >= 5) {
            count *= 3;
            n -= 3;
        }
        return  count * n;
    }
}
