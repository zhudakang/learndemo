package com.dk.learndemo.algorithm.arr;

/**
 * @author :zhudakang
 * @description : SearchTarget
 * @create : 2020/07/15
 */
public class SearchTarget {

    public static int search(int[] nums, int target) {
        //是否可以使用二分查找？
        //找到这个数然后前后指针走
        int result = 0;
        int low = 0;
        int high = nums.length -1;
        int pos = (low + high) / 2;
        while (low <= high) {
            if (nums[pos] == target) {
                result++;
                break;
            }
            if (nums[pos] > target) {
                high = pos - 1;

            } else {
                low = pos + 1;
            }
            pos = (low + high) / 2;
        }
        //对pos做处理
        int l = pos - 1;
        while (l >= 0 && nums[l] == target) {
            result++;
            l--;
        }
        int r = pos + 1;
        while (r < nums.length && nums[r] == target) {

            result++;
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5, 7, 7, 8,  10}, 8));
    }

    //思路很简单，但是,需要处理边界值
    /**
     * 与上一题不太一样，
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     */
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}
