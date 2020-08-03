package com.algorithm.entity;


import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    // 前序遍历所有的节点
    public List<Object> frontFind() {
        List<Object> values = new ArrayList<>();

        // 当前节点
        values.add(val);

        // 左节点的遍历结果
        if (null != left)
            values.addAll(left.frontFind());

        // 右节点的遍历结果
        if (null != right)
            values.addAll(right.frontFind());

        return values;
    }

    //根据前序与中序遍历重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if(len == 0){
            return null;
        }else {
            TreeNode root = new TreeNode(preorder[0]);
            int k = 0;
            for(int i=0; i<len; i++){
                if(inorder[i] == root.val){
                    k=i;
                    break;
                }
            }
            int[] newPreorder1 = new int[k];
            int[] newPreorder2 = new int[len-k-1];
            int[] newInorder1 = new int[k];
            int[] newInorder2 = new int[len-k-1];
            for(int j =0; j<len; j++){
                if(j>0 && j<=k){
                    newPreorder1[j-1]=preorder[j];
                }
                if(j<k){
                    newInorder1[j]=inorder[j];
                }
                if(j>k) {
                    newPreorder2[j-1-k]=preorder[j];
                    newInorder2[j-1-k]=inorder[j];
                }
            }
            root.left = root.buildTree(newPreorder1,newInorder1);
            root.right = root.buildTree(newPreorder2,newInorder2);
            return root;
        }
    }
    // 中序遍历所有的节点
    public List<Object> midFind() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != left)
            values.addAll(left.midFind());

        // 当前节点
        values.add(val);

        // 右节点的遍历结果
        if (null != right)
            values.addAll(right.midFind());

        return values;
    }
}
