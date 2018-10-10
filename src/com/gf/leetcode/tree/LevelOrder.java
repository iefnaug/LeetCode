package com.gf.leetcode.tree;

/*
 * Author guanfei
 * Date 2018/10/10
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 *   Go to Discuss
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * use queue
     *
     * Submission Detail
     * 34 / 34 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Submitted: 0 minutes ago
     * beats 91.03 %
     *
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if(root == null) return list;
//
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int curLevelSize = 1;
//        int nextLevelSize = 0;
//        int tempSize = 0;
//
//        List<Integer> eachLevelList = new ArrayList<>();
//        while(!queue.isEmpty()){
//           TreeNode curNode = queue.poll();
//           eachLevelList.add(curNode.val);
//           tempSize++;
//           if(curNode.left != null){
//               queue.offer(curNode.left);
//               nextLevelSize++;
//           }
//           if(curNode.right != null){
//               queue.offer(curNode.right);
//               nextLevelSize++;
//           }
//           if(tempSize == curLevelSize){
//               curLevelSize = nextLevelSize;
//               nextLevelSize = 0;
//               tempSize = 0;
//               list.add(eachLevelList);
//               eachLevelList = new ArrayList<>();
//           }
//
//        }
//        return list;
//    }


    /**
     * recursive
     *
     * Submission Detail
     * 34 / 34 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Submitted: 0 minutes ago
     * beats 100.00 %
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(list, root, 0);
        return list;
    }

    private void levelOrder(List<List<Integer>> list, TreeNode cur, int level){
        if(cur == null){
            return;
        }

        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(cur.val);

        levelOrder(list, cur.left, level + 1);
        levelOrder(list, cur.right, level + 1);
    }
}
