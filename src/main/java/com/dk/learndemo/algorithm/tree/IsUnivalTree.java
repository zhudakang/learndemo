package com.dk.learndemo.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhudakang
 * @description : TsUnivalTree
 * @create : 2020/06/15
 */
public class IsUnivalTree {

    /**
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     * <p>
     * DK思路 可以使用SET + 遍历TREE
     */
    List<Integer> vals;


    public boolean isUnivalTree(TreeNode root) {
        vals = new ArrayList<>();
        dfs(root);
        for (int v : vals) {
            if (v != vals.get(0)) {
                return false;
            }
        }
        return true;
    }

    //其实就是写一次遍历 中序遍历
    public void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
