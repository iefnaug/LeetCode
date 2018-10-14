package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/14
 */

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 *   Go to Discuss
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree2 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || (preorder.length != inorder.length)){
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight){
        if(pLeft<0 || pRight<0 || pLeft>=preorder.length || pRight>=preorder.length){
            return null;
        }
        int root_val = preorder[pLeft];
        TreeNode root = new TreeNode(root_val);
        for(int i=iLeft; i<=iRight; i++){
            if(root_val == inorder[i]){
                root.left = buildTree(preorder, pLeft+1, i-iLeft+pLeft, inorder, iLeft, i-1);
                root.right = buildTree(preorder, i-iLeft+pLeft+1, pRight, inorder, i+1, iRight);
                return root;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BuildTree2 buildTree2 = new BuildTree2();
        int[] inorder = {
                9,3,15,20,7
        };

        int[] preorder = {
                3,9,20,15,7
        };
        TreeNode root = buildTree2.buildTree(preorder, inorder);
        System.out.println();
    }
}
