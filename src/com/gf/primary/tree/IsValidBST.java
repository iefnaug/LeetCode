package com.gf.primary.tree;

/**
 * Author gf
 * Date 2018/9/25.
 * Coding Forever
 *
 *
 * 验证二叉搜索树
 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

 假设一个二叉搜索树具有如下特征：

 节点的左子树只包含小于当前节点的数。
 节点的右子树只包含大于当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。
 示例 1:

 输入:
 2
 / \
 1   3
 输出: true
 示例 2:

 输入:
 5
 / \
 1   4
 / \
 3   6
 输出: false
 解释: 输入为: [5,1,4,null,null,3,6]。
 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 将值的范围限制在了Integer的范围内
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE - 1L, Integer.MAX_VALUE + 1L);
    }

    public boolean isValidBST(TreeNode node, long left, long right){
        if(node == null){
            return true;
        }else if(node.val <= left || node.val >= right){
            return false;
        }
        return isValidBST(node.left, left, node.val) && isValidBST(node.right, node.val, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new IsValidBST().isValidBST(root));
    }

}
