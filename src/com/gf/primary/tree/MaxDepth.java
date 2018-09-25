package com.gf.primary.tree;

/*
 * Author guanfei
 * Date 2018/9/23
 *
 *
 *
 * 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
public class MaxDepth {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int max = 0;
    private static int temp_max = 0;

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int depth){
        if(node == null) return depth;
        depth++;
        int depth_left = maxDepth(node.left, depth);
        int depth_right = maxDepth(node.right, depth);
        return depth_left > depth_right ? depth_left : depth_right;
    }



    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
    }
}
