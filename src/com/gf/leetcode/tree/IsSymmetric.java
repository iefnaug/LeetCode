package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/11
 */

import java.util.LinkedList;

/**
 * Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class IsSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * iteratively
     *
     * Submission Detail
     * 193 / 193 test cases passed.
     * Status: Accepted
     * Runtime: 12 ms
     * Submitted: 0 minutes ago
     *
     * beats 32.67 %
     *
     * @param root
     * @return
     */
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null)
//            return true;
//        LinkedList<TreeNode> leftTree = new LinkedList<>();
//        LinkedList<TreeNode> rightTree = new LinkedList<>();
//        leftTree.offer(root.left);
//        rightTree.offer(root.right);
//        while(!leftTree.isEmpty()){
//            TreeNode leftNode = leftTree.poll();
//            TreeNode rightNode = rightTree.poll();
//
//            if(leftNode == null && rightNode == null){
//                continue;
//            }else if(leftNode == null || rightNode == null || (leftNode.val != rightNode.val)){
//                return false;
//            }
//            leftTree.offer(leftNode.left);
//            leftTree.offer(leftNode.right);
//            rightTree.offer(rightNode.right);
//            rightTree.offer(rightNode.left);
//        }
//        return true;
//    }

    /**
     * recursively
     *
     * Submission Detail
     * 193 / 193 test cases passed.
     * Status: Accepted
     * Runtime: 9 ms
     * Submitted: 0 minutes ago
     * beats 68.16 %
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null)  return true;
        if(leftNode == null || rightNode == null || (leftNode.val != rightNode.val)) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }


    /**
     * create a BinaryTree
     * @param nodes
     * @return
     */
    public TreeNode generateTree(Integer []nodes){
        if(nodes == null || nodes.length == 0)
            return null;
        int length = nodes.length;
        int index = -1;
        LinkedList<TreeNode> curNodeLevel = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[++index]);
        curNodeLevel.offer(root);
        LinkedList<TreeNode> nextNodeLevel = new LinkedList<>();
        while(index < length){

            while(!curNodeLevel.isEmpty()){
                TreeNode node = curNodeLevel.poll();

                if(++index >= length) return root;
                if(nodes[index] != null){
                    TreeNode leftNode = new TreeNode(nodes[index]);
                    node.left = leftNode;
                    nextNodeLevel.offer(leftNode);
                }

                if(++index >= length) return root;
                if(nodes[index] != null){
                    TreeNode rightNode = new TreeNode(nodes[index]);
                    node.right = rightNode;
                    nextNodeLevel.offer(rightNode);
                }

            }

            curNodeLevel = nextNodeLevel;
            nextNodeLevel = new LinkedList<>();
        }
        return root;
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        Integer []nodes = new Integer[]{
                1, 2, 2, 3, 4, 4, 3
        };
        TreeNode root = isSymmetric.generateTree(nodes);
        boolean result = isSymmetric.isSymmetric(root);
        System.out.println(result);

    }

}
