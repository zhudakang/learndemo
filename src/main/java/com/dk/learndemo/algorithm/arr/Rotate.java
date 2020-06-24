package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : Rotate
 * @create : 2020/06/10
 */
public class Rotate {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * <p>
     * 暴力
     */
    public void rotate(int[] nums, int k) {

        int temp, previous;
        for (int i = 0; i < k; i++) {
            //每一次移动只有最后一个元素滚到了第一个元素，
            // 所以只要处理好边界的第一个元素
            //把pre元素一直存着
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 借助一个数组
     */
    public void rotate2(int[] nums, int k) {
        /**
         *
         * 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中。
         * */
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //这种方式也很秀，因为超过了长度那么就余了，比如100个长度，
            // 他正好是第99也就是最后一个元素，需要移动1，那么就是100%100 = 0
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }


    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * <p>
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
     * <p>
     * 假设 n=7n=7 且 k=3k=3 。
     * <p>
     * <p>
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * 大呼 nb
     */
    public void rotate3(int[] nums, int k) {
        //因为K有可能是长度的几倍，所以取余
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 环形替换法：
     * 最牛逼的解法
     * 换桌思路好评，但是还挺难理解的
     * 总体的思想就是让他换k个位置，被占了之后，让那个人自己再去往后面移动K个位置
     * 把元素看做同学，把下标看做座位，大家换座位。第一个同学离开座位去第k+1个座位，第k+1个座位的同学被挤出去了，
     * 他就去坐他后k个座位，如此反复。但是会出现一种情况，就是其中一个同学被挤开之后，
     * 坐到了第一个同学的位置（空位置，没人被挤出来），但是此时还有人没有调换位置，这样就顺着让第二个同学换位置。
     * 那么什么时候就可以保证每个同学都换完了呢？n个同学，换n次，所以用一个count来计数即可。
     * */
    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                //从下一个作为开始坐下来
                current = next;
                count++;
            } while (start != current); // 说明做的没有空位了
        }
    }
}
