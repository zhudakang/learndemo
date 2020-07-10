package com.dk.learndemo.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        /**
         *  add() 和 offer() 区别
         *  Queue 中 add() 和 offer()都是用来向队列添加一个元素。
         * 在容量已满的情况下，add() 方法会抛出IllegalStateException异常，offer() 方法只会返回 false 。
         * */
        q.offer(u);
        q.offer(v);
        //需要所有的节点都比较完了
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            //里面放的是左右节点
            //u 左
            q.offer(u.left);
            //v 右
            q.offer(v.right);

            //u 右边
            q.offer(u.right);
            //v 左边
            q.offer(v.left);
        }
        return true;
    }
}
