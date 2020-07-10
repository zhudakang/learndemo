package com.dk.learndemo.algorithm.tree;

/**
 * @author :zhudakang
 * @description : IsSymmetric
 * @create : 2020/07/10
 */
public class IsSymmetric {
    /**
     * 题目：给定一个二叉树，检查它是否是镜像对称的。
     * */

    /**
    时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)
    空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)
    镜像队列？？两个树在什么情况下互为镜像？
    它们的两个根结点具有相同的值
    每个树的右子树都与另一个树的左子树镜像对称
    进行左右子树的递归,但是这个是对称的，并不是完全的将左右子树进行判等
     */
    public boolean isSymmetric(TreeNode root) {
        //初始都按照root去走
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //必须值也相等，检查左右和右左
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
