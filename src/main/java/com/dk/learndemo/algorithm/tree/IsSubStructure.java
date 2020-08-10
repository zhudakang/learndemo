package com.dk.learndemo.algorithm.tree;

/**
 * @author :zhudakang
 * @description : IsSubStructure
 * @create : 2020/08/10
 */
public class IsSubStructure {


    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //先序遍历树 A 中的每个节点 nA
        // 对应函数 isSubStructure(A, B)
        // 判断树 A 中 以 nA  为根节点的子树 是否包含树 B  对应函数 recur(A, B)
        // https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
