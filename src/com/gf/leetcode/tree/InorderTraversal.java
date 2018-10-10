package com.gf.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Author guanfei
 * Date 2018/10/8
 *
 *
 *
Binary Tree Inorder Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * recursive version
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inorderTraversal(root, list);
//        return list;
//    }
//
//    private void inorderTraversal(TreeNode node, List<Integer> list){
//        if(node != null){
//            inorderTraversal(node.left, list);
//            list.add(node.val);
//            inorderTraversal(node.right, list);
//        }
//    }


    /**
     * recursive version
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root != null){
//            List<Integer> subListLeft = inorderTraversal(root.left);
//            list.add(root.val);
//            List<Integer> subListRight = inorderTraversal(root.right);
//            list.addAll(subListLeft);
//            list.addAll(subListRight);
//        }
//        return list;
//    }


    /**
     * iterative version
     *
     * Submission Detail
     * 68 / 68 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Submitted: 0 minutes ago
     * beats 100.00 %
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur){
                    node = node.right;
                }
                if(node.right == null){
                    node.right = cur;
                    cur = cur.left;
                }else{
                    node.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return list;
    }

}
