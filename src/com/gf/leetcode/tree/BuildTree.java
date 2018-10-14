package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/13
 */

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 * 
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || (inorder.length != postorder.length)){
            return null;
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);

    }

    private TreeNode buildTree(int[] inorder, int iLeft, int iRight, int []postorder, int pLeft, int pRight){
        if(iLeft<0 || iRight<0 || pLeft<0 || pRight<0) return null;
        int root_val = postorder[pRight];
        TreeNode root = new TreeNode(root_val); //according to the meaning of post traversal, get the root node in each recursive
        for(int i=iLeft; i<=iRight; i++){
            if(inorder[i] == root_val){
                root.left = buildTree(inorder, iLeft, i-1, postorder, pLeft, i-1-iLeft+pLeft);
                root.right = buildTree(inorder, i+1, iRight, postorder, i-iLeft+pLeft, pRight-1);
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] inorder = {
                9,3,15,20,7
        };

        int[] postorder = {
                9,15,7,20,3
        };

        TreeNode root = buildTree.buildTree(inorder, postorder);
        System.out.println();
    }
}
