package com.dk.learndemo.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : pmdream
 * @description : TreeRecursionTraversal
 * @create : 2020/06/15
 */
public class TreeRecursionTraversal {

    //Degree 根结点D
    // 用递归的方法进行先序遍历
    //DLR
    public static List dlrList = new ArrayList();
    public void dlrTraversal(TreeNode treeNode) {
        dlrList.add(treeNode.val);
        if (treeNode.left != null) {
            dlrTraversal(treeNode.left);
        }
        if (treeNode.right != null) {
            dlrTraversal(treeNode.right);
        }
    }

    // 用递归的方法进行中序遍历
    public static List ldrList = new ArrayList();
    public void ldrTraversal(TreeNode treeNode) {
        if (treeNode.left != null) {
            ldrTraversal(treeNode.left);
        }
        ldrList.add(treeNode.val);
        if (treeNode.right != null) {
            ldrTraversal(treeNode.right);
        }
    }

    public static List lrdList = new ArrayList();
    // 用递归的方法进行后序遍历
    public void lrdTraversal(TreeNode treeNode) {
        if (treeNode.left != null) {
            lrdTraversal(treeNode.left);
        }
        if (treeNode.right != null) {
            lrdTraversal(treeNode.right);
        }
        lrdList.add(treeNode.val);
    }

    public static void main(String[] args) {
        TreeRecursionTraversal traversal = new TreeRecursionTraversal();
        TreeNode root = treeSet();
        traversal.dlrTraversal(root);
        System.out.println("前序遍历 : " + dlrList.toString());
        traversal.ldrTraversal(root);
        System.out.println("中序遍历 : " + ldrList.toString());
        traversal.lrdTraversal(root);
        System.out.println("后序遍历 : " + lrdList.toString());
    }

    // 构造二叉树，返回根节点
    public static TreeNode treeSet() {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);
        TreeNode g = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        c.right = f;
        b.left = d;
        b.right = e;
        e.left = g;
        return root;
    }


}
