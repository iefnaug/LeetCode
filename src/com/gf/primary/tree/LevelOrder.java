package com.gf.primary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Author guanfei
 * Date 2018/10/4
 *
二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class LevelOrder {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new LinkedList<>();

        List<List<Integer>> numList = new ArrayList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.offer(root);
        while(!nodeList.isEmpty()){
            List<Integer> oneLevel = new ArrayList<>();
            int size = nodeList.size();
            for(int i=0; i<size; i++){
                TreeNode node = nodeList.poll();
                oneLevel.add(node.val);
                TreeNode leftNode = node.left;
                TreeNode rightNode = node.right;
                if(leftNode != null){
                    nodeList.offer(leftNode);
                }
                if(rightNode != null){
                    nodeList.offer(rightNode);
                }
            }
            numList.add(oneLevel);
        }
        return numList;
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> numList = new ArrayList<>();
        levelOrder(root, 0, numList);
        return numList;
    }

    public void levelOrder(TreeNode node, int level, List<List<Integer>> list){
        if(list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        if(node.left != null){
            levelOrder(node.left, level+1, list);
        }
        if(node.right != null){
            levelOrder(node.right, level+1, list);
        }
    }
}
