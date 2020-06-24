package com.dk.learndemo.algorithm.kuaishou;

/**
 * @author :zhudakang
 * @description : CompareVersion
 * @create : 2020/06/15
 */
public class CompareVersion {

    /**
     * 比较两个版本号 version1 和 version2。
     * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
     * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
     *  . 字符不代表小数点，而是用于分隔数字序列。
     * <p>
     * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
     * <p>
     * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。
     * 其第三级和第四级修订号均为 0。
     *
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
     *
     * 输入：version1 = "1.0", version2 = "1.0.0"
     * 输出：0
     */
    public int compareVersion(String version1, String version2) {

        /**
         *
         * */
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        //一次循环找长度最大的，如果没有都当做0处理
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            //否则就当做0
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            //是分隔的长度的
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

}
