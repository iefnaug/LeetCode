package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/15
 */

import java.util.LinkedList;

/**
 * Populating Next Right Pointers in Each Node
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class Connect {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }


    public TreeLinkNode generateTree(Integer []nodes){
        if(nodes == null || nodes.length == 0)
            return null;
        int length = nodes.length;
        int index = -1;
        LinkedList<TreeLinkNode> curNodeLevel = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(nodes[++index]);
        curNodeLevel.offer(root);
        LinkedList<TreeLinkNode> nextNodeLevel = new LinkedList<>();
        while(index < length){

            while(!curNodeLevel.isEmpty()){
                TreeLinkNode node = curNodeLevel.poll();

                if(++index >= length) return root;
                if(nodes[index] != null){
                    TreeLinkNode leftNode = new TreeLinkNode(nodes[index]);
                    node.left = leftNode;
                    nextNodeLevel.offer(leftNode);
                }

                if(++index >= length) return root;
                if(nodes[index] != null){
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


    /**
     * iteratively
     * @param root
     * @return
     */
//    public void connect(TreeLinkNode root) {
//        if(root == null){
//            return;
//        }
//
//        LinkedList<TreeLinkNode> curLevel = new LinkedList<>();
//        curLevel.offer(root);
//        LinkedList<TreeLinkNode> nextLevel = new LinkedList<>();
//
//        TreeLinkNode prevNode = null;
//        while(!curLevel.isEmpty()){
//            TreeLinkNode curNode = curLevel.poll();
//            if(prevNode != null){
//                prevNode.next = curNode;
//            }
//            prevNode = curNode;
//            if(curLevel.size() == 0){ //curNode is the last one in current level
//                curNode.next = null;
//                prevNode = null;
//            }
//
//            if(curNode.left != null){
//                nextLevel.offer(curNode.left);
//            }
//            if(curNode.right != null){
//                nextLevel.offer(curNode.right);
//            }
//            if(curLevel.size() == 0){
//                curLevel = nextLevel;
//                nextLevel = new LinkedList<>();
//            }
//        }
//    }


    /**
     * recursively
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = root.next == null ? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    public static void main(String[] args) {
        Integer[] nodes = {
                1,2,3
        };
        Connect connect = new Connect();
        TreeLinkNode root = connect.generateTree(nodes);
        connect.connect(root);
        System.out.println();
    }
}
