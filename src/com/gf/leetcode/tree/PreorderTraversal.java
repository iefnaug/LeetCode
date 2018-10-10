package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/8
 *
 *
 *
Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


//Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * recursive version
     *
     * Submission Detail
     * 68 / 68 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * beats 64.68 %
     *
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preorderTraversal(root, list);
//        return list;
//    }
//
//    private void preorderTraversal(TreeNode root, List<Integer> list){
//        if(root != null){
//            list.add(root.val);
//            preorderTraversal(root.left, list);
//            preorderTraversal(root.right, list);
//        }
//    }

    /**
     * iterative version
     *
     * Submission Detail
     * 68 / 68 test cases passed.
     * Status: Accepted
     * Runtime: 2 ms
     * Submitted: 0 minutes ago
     * beats 5.66 %
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root == null) return list;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            list.add(node.val);
//            if(node.right != null)
//                stack.push(node.right);
//            if(node.left != null)
//                stack.push(node.left);
//        }
//        return list;
//    }

    /**
     * iterative version
     *
     *Submission Detail
     * 68 / 68 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Submitted: 0 minutes ago
     * beats 100.00 %
     *
     * @param root
     * @return
     */
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root == null) return list;
//
//        TreeNode cur = root;
//        while(cur != null){
//            list.add(cur.val);
//            if(cur.left == null){
//                cur = cur.right;
//            }else{
//                TreeNode node = cur.left;
//                while(node.right != null && node.right != cur){
//                    node = node.right;
//                }
//                if(node.right == null){
//                    node.right = cur.right;
//                    cur = cur.left;
//                }else{
//                    node.right = null;
//                    cur = cur.right;
//                }
//            }
//        }
//        return list;
//    }






}
