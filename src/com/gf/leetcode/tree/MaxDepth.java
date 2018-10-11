package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/11
 */

import java.util.LinkedList;

/**
 *Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaxDepth {

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
     * level order
     */
    public void printTree(TreeNode root){
        if(root == null) return;
        LinkedList<TreeNode> curLevel = new LinkedList<>();
        curLevel.offer(root);
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        while(!curLevel.isEmpty()){
            while(!curLevel.isEmpty()){
                TreeNode node = curLevel.poll();
                System.out.print(String.format("%-4d", node.val));
                if(node.left != null){
                    nextLevel.offer(node.left);
                }
                if(node.right != null){
                    nextLevel.offer(node.right);
                }
            }
            curLevel = nextLevel;
            nextLevel = new LinkedList<>();
            System.out.println();
        }
    }


    /**
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer []nodes = new Integer[100];
        for(int i=1; i<=nodes.length; i++){
            nodes[i-1]  = i;
        }

        MaxDepth maxDepth = new MaxDepth();
//        maxDepth.printTree(maxDepth.generateTree(nodes));
        TreeNode root = maxDepth.generateTree(nodes);
        maxDepth.printTree(root);
        int depth = maxDepth.maxDepth(root);
        System.out.println("depth:" + depth);
    }

}
