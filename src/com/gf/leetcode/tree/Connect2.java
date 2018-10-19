package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/18
 */

import java.util.LinkedList;

/**
 * Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example:
 * <p>
 * Given the following binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \    \
 * 4-> 5 -> 7 -> NULL
 */
public class Connect2 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }


    public TreeLinkNode generateTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0)
            return null;
        int length = nodes.length;
        int index = -1;
        LinkedList<TreeLinkNode> curNodeLevel = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(nodes[++index]);
        curNodeLevel.offer(root);
        LinkedList<TreeLinkNode> nextNodeLevel = new LinkedList<>();
        while (index < length) {

            while (!curNodeLevel.isEmpty()) {
                TreeLinkNode node = curNodeLevel.poll();

                if (++index >= length) return root;
                if (nodes[index] != null) {
                    TreeLinkNode leftNode = new TreeLinkNode(nodes[index]);
                    node.left = leftNode;
                    nextNodeLevel.offer(leftNode);
                }

                if (++index >= length) return root;
                if (nodes[index] != null) {
                    TreeLinkNode rightNode = new TreeLinkNode(nodes[index]);
                    node.right = rightNode;
                    nextNodeLevel.offer(rightNode);
                }

            }

            curNodeLevel = nextNodeLevel;
            nextNodeLevel = new LinkedList<>();
        }
        return root;
    }


//    /**
//     * 不能这样使用递归，使用广度优先遍历
//     * @param root
//     */
//    public void connect(TreeLinkNode root) {
//        if(root == null)
//            return;
//
//        if(root.left != null){
//            if(root.right != null){
//                root.left.next = root.right;
//            }else{
//                TreeLinkNode node = root;
//                while(node.next != null){
//                    if(node.next.left != null){
//                        root.left.next = node.next.left;
//                        break;
//                    }else if(node.next.right != null){
//                        root.left.next = node.next.right;
//                        break;
//                    }
//                    node = node.next;
//                }
//            }
//        }
//
//        if(root.right != null){
//            if(root.next != null){
//                TreeLinkNode node = root;
//                while(node.next != null){
//                    if(node.next.left != null){
//                        root.right.next = node.next.left;
//                        break;
//                    }else if(node.next.right != null){
//                        root.right.next = node.next.right;
//                        break;
//                    }
//                    node = node.next;
//                }
//            }
//        }
//
//        connect(root.left);
//        connect(root.right);
//    }


    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeLinkNode> curLevel = new LinkedList<>();
        LinkedList<TreeLinkNode> nextLevel = new LinkedList<>();
        curLevel.offer(root);
        TreeLinkNode prev = null;
        TreeLinkNode curr;

        while (!curLevel.isEmpty()) {
            curr = curLevel.poll();
            if (prev != null) {
                prev.next = curr;
            }

            if (curr.left != null) {
                nextLevel.offer(curr.left);
            }


            if (curr.right != null) {
                nextLevel.offer(curr.right);
            }

            prev = curr;

            if (curLevel.isEmpty()) {
                curr.next = null;
                prev = null;
                curLevel = nextLevel;
                nextLevel = new LinkedList<>();
            }

        }
    }

    public static void main(String[] args) {
        Integer[] nodes = {
                2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7
        };
        Connect2 connect2 = new Connect2();
        TreeLinkNode root = connect2.generateTree(nodes);
        connect2.connect(root);
        System.out.println();
    }

}
