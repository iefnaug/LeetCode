package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/12
 */

import java.util.LinkedList;

/**
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class HasPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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


    /**
     * pre order
     *
     * @param root
     * @param sum
     * @return
     */
    private int state = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        compute(root, sum, 0);
        return state == 1;
    }

    private void compute(TreeNode node, int sum, int count){
        if(state ==  1) return;
        count += node.val;
        if(node.left == null && node.right == null && sum == count){
            state = 1;
        }else{
            if(node.left != null){
                compute(node.left, sum, count);
            }
            if(node.right != null){
                compute(node.right, sum, count);
            }
        }
    }



    public static void main(String[] args) {

        Integer[] nodes = new Integer[]{
            1,2
        };

        HasPathSum hasPathSum = new HasPathSum();
        TreeNode root = hasPathSum.generateTree(nodes);
        boolean result = hasPathSum.hasPathSum(root, 1);
        System.out.println(result);

    }
}
