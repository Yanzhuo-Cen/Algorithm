package com.algorithm.entity;


import java.util.List;

public class RedBlackTree {

    RbtNode root;

    // 红黑树插入数据
    public void add(int[] arr) {
        root = new RbtNode(arr[0]);  //创建根节点
        root.parentNode = null;
        root.color = "black";
        for (int i=1; i < arr.length; i++) {
            int v = arr[i];
            RbtNode rbtNodeRoot = root.queryRoot(root);   //每次重新查询根节点
            rbtNodeRoot.addRbt(v);
        }
    }

    //红黑树删除数据
    public void delete(int x){
        RbtNode rbtNodeRoot = root.queryRoot(root);   //查询根节点
        rbtNodeRoot.delete(x);
//        RbtNode result = rbtNodeRoot.queryNode(x); //查询节点
//        System.out.println("节点值：" + result.value+ "，节点颜色：" +result.color);
    }

    //中序遍历打印
    public void print(){
        RbtNode rootRbtNode = root.queryRoot(root);    //查询根节点
        List<Object> result = rootRbtNode.midFind();   //遍历值
        List<String> colors = rootRbtNode.midFindColro();  //遍历颜色
//        for(int i=0; i<result.size(); i++) {
            System.out.println("节点值：" + result+ "，节点颜色" +colors);
//        }
    }

    public void printroot(){
        RbtNode rootRbtNode = root.queryRoot(root);    //查询根节点
        System.out.println("根节点值为" +rootRbtNode.value+ "，根节点颜色为" +rootRbtNode.color);
    }
}
