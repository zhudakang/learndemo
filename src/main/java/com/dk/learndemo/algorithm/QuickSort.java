package com.dk.learndemo.algorithm;

/**
 * @author :zhudakang
 * @description : QuickSort
 * @create : 2020/07/30
 */
public class QuickSort {

    /**
     * // 这时候，跳出上面大的while循环之后，i和j肯定是相等的，因为上面循环的条件是i&lt;j，所以，跳出循环时，i和j是相等的
     *         /**
     *          * 假如最好的情况是一个有序序列 1 3 5 7 9
     *          * temp = 1
     *          * i = 0    arr[i] = 1
     *          * j = 4    arr[j] = 9
     *          * 而且在这里，如果先从左边开始寻找的话，一直往右寻找大于1的数，直到i变成4还没有找到就停止了；但是下面的语句就会把9赋值在1上了
     *          * 如果先从右边开始寻找的话，一直往左寻找小于1的数，直到j变成0还没有找到然后停止，此时i和j都是0，所以就是把自身交换一下并不影响顺序。
     *          * 这也是为什么强调如果选择数组左边第一个数作为基准值的时候，得先从右边开始查找数。
     *
    最后将基准位与i和j相等位置的数字交换
     下面的i和j其实相等的，所以用哪一个都一样。
     * */
    public static void main(String[] args) {
        int[] arr = new int[]{1,9,5,6,7,8,0};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] array) {
        int len;
        if(array == null
                || (len = array.length) == 0
                || len == 1) {
            return ;
        }
        sort(array, 0, len - 1);
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
}
