package com.gf.primary.tree;

import java.util.LinkedList;

/*
 * Author guanfei
 * Date 2018/10/3
 *
 * 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归求解
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }

        if(left.val == right.val){
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

        return false;
    }


    /**
     * 非递归求解
     */
    public boolean isSymmetric2(TreeNode root){
        if(root == null) return true;
        LinkedList<TreeNode> leftTree = new LinkedList<>();
        LinkedList<TreeNode> rightTree = new LinkedList<>();
        leftTree.offer(root.left);
        rightTree.offer(root.right);

        while(!leftTree.isEmpty()){
            TreeNode leftNode = leftTree.poll();
            TreeNode rightNode = rightTree.poll();
            if(leftNode == null && rightNode == null){
                continue;
            }
            if(leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }
            leftTree.offer(leftNode.left);
            leftTree.offer(leftNode.right);
            rightTree.offer(rightNode.right);
            rightTree.offer(rightNode.left);
        }
        return true;
    }
}
