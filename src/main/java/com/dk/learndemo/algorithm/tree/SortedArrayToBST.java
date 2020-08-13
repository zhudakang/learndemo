package com.dk.learndemo.algorithm.tree;

/**
 * @author :zhudakang
 * @description : SortedArrayToBST
 * @create : 2020/08/10
 */
public class SortedArrayToBST {

    /**
     *二叉搜索树，又称之为二叉排序树（二叉查找树），它或许是一棵空树，或许是具有以下性质的二叉树：
     *
     * 若他的左子树不为空，则左子树上所有节点的值都小于根节点的值
     * 若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
     * 它的左右子树也分别是二叉搜索树
     *
     *
     * AVL树的性质：
     * 左子树与右子树高度之差的绝对值不超过1
     * 树的每个左子树和右子树都是AVL树
     * 每一个节点都有一个平衡因子（balance factor），任一节点的平衡因子是-1、0、1
     * （每一个节点的平衡因子 = 右子树高度 - 左子树高度）
     *
     * */
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        System.out.println(a==b);
        String c = new String("hello");
        System.out.println(a==c);
        StringBuffer d = new StringBuffer("hello");
        System.out.println(a==d.toString());
        String e = "he" + "llo";
        System.out.println(b==e);
    }





}
