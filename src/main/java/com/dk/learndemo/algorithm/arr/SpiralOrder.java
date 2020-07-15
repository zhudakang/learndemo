package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : SpiralOrder
 * @create : 2020/07/15
 */
public class SpiralOrder {

    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    /**
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 螺旋打印 有点类似于蚊香形式
     * */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        //d是二位数组的行数  ;r是二维数组的列数
        //u是横行 i是竖行
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        //作为总的元素输出
        int idx = 0;
        //做一个循环，最后返回结果
        while (true) {
            //第一个横行
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[u][i];
            }
            if (++u > d) {
                break;
            }
            //这个时候应该从i = u 开始
            for (int i = u; i <= d; i++) {
                res[idx++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[d][i];
            }
            if (--d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res[idx++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    /**
     * 圈圈圆圆圈圈
     * 时间复杂度：O(mn)，其中 mm 和 nn 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
     *
     * 空间复杂度：O(1) 除了输出数组以外，空间复杂度是常数。
     *
     * */
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        //rows 代表行号  columns代表列
        int rows = matrix.length, columns = matrix[0].length;
        //return的
        int[] order = new int[rows * columns];
        //总的index
        int index = 0;
        //左右上下，但是问题是怎么停下来
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        //停下来的条件，左右相遇 或者上下相遇
        while (left <= right && top <= bottom) {
            //固定行不变，输出列信息
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            //固定列不变，输出行信息
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            //第二次做L型的时候需要看看是否符合要求 可能已经到了结束的点了
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
