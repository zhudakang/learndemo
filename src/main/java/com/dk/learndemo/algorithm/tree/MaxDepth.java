package com.dk.learndemo.algorithm.tree;

/**
 * @author :zhudakang
 * @description : MaxDepth
 * @create : 2020/07/15
 */
public class MaxDepth {

    /**
     * 入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * */
    /**
     * 思想：
     * 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；
     * <p>
     * 常见的 DFS ： 先序遍历、中序遍历、后序遍历；
     * 常见的 BFS ： 层序遍历（即按层遍历）。
     * 求树的深度需要遍历树的所有节点，本文将介绍基于 后序遍历（DFS） 和 层序遍历（BFS） 的两种解法。
     * <p>
     * 递归需要找到关键点
     * 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1+1 。
     */
    public int maxDepth(TreeNode root) {
//        时间复杂度 O(N)O(N) ： NN 为树的节点数量，计算树的深度需要遍历所有节点。
//        空间复杂度 O(N)O(N) ： 最差情况下（当树退化为链表时），递归深度可达到 NN 。

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
