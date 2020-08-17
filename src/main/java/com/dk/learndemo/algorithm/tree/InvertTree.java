package com.dk.learndemo.algorithm.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author :zhudakang
 * @description : InvertTree
 * @create : 2020/08/17
 */
public class InvertTree {


    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * */
    public TreeNode invertTree(TreeNode root){

        if(root == null){
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }


}

