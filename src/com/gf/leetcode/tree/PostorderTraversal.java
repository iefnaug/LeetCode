package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/9
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class PostorderTraversal {

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
     * Submitted: 0 minutes ago
     * beats 71.28 %
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        postorderTraversal(root, list);
//        return list;
//    }
//
//    private void postorderTraversal(TreeNode node, List<Integer> list){
//        if(node != null){
//            postorderTraversal(node.left, list);
//            postorderTraversal(node.right, list);
//            list.add(node.val);
//        }
//    }

    /**
     * iterative version with stack
     *
     * Submission Detail
     * 68 / 68 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Submitted: 0 minutes ago
     * beats 71.28 %
     *
     * @param root
     * @return
     */
//    public List<Integer> postorderTraversal(TreeNode root) {
//        LinkedList<Integer> list = new LinkedList<>();
//        if(root == null) return list;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            list.push(node.val);
//            if(node.left != null){
//                stack.push(node.left);
//            }
//            if(node.right != null){
//                stack.push(node.right);
//            }
//        }
//        return list;
//    }


    /**
     * Submission Detail
     * 68 / 68 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Submitted: 0 minutes ago
     * beats 71.00 %
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode visited = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if( (node.left == null && node.right == null) || (visited != null && (node.left == visited || node.right == visited)) ){
                stack.pop();
                list.add(node.val);
                visited = node;
            }else{
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return list;
    }
}
