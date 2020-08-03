package com.algorithm.entity;


import java.util.ArrayList;
import java.util.List;

public class BstNode {

    // 左子节点
    BstNode leftBstNode;
    // 右子节点
    BstNode rightBstNode;
    // 值
    public Object value;

    //创建Node时直接赋值
    public BstNode(int value) {
        this.value = value;
    }

    // 二叉排序树插入数据的方法
    public void addBst(int v) {
        if (null == value) {
            value = v;
            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        } else {
            // 新增的值，比当前值小或者相同
            if (v - ((Integer) value) <= 0) {
                if (null == leftBstNode) {
                    leftBstNode = new BstNode(0);   //初始化新节点的value
                    leftBstNode.value = v;
                } else {
                    leftBstNode.addBst(v);
                }
                //新增的值，比当前值大
            } else {
                if (null == rightBstNode) {
                    rightBstNode = new BstNode(0);  //初始化新节点的value
                    rightBstNode.value = v;
                } else {
                    rightBstNode.addBst(v);
                }
            }
        }
    }

    // 二叉排序树插入数据的方法
    public void addRbt(int v) {
        if (null == value) {
            value = v;
            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        } else {
            // 新增的值，比当前值小或者相同
            if (v - ((Integer) value) <= 0) {
                if (null == leftBstNode) {
                    leftBstNode = new BstNode(0);   //初始化新节点的value
                    leftBstNode.value = v;
                } else {
                    leftBstNode.addRbt(v);
                }
                //新增的值，比当前值大
            } else {
                if (null == rightBstNode) {
                    rightBstNode = new BstNode(0);  //初始化新节点的value
                    rightBstNode.value = v;
                } else {
                    rightBstNode.addRbt(v);
                }
            }
        }
    }

    // 前序遍历所有的节点
    public List<Object> frontFind() {
        List<Object> values = new ArrayList<>();

        // 当前节点
        values.add(value);

        // 左节点的遍历结果
        if (null != leftBstNode)
            values.addAll(leftBstNode.frontFind());

        // 右节点的遍历结果
        if (null != rightBstNode)
            values.addAll(rightBstNode.frontFind());

        return values;
    }

    // 中序遍历所有的节点
    public List<Object> midFind() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftBstNode)
            values.addAll(leftBstNode.midFind());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightBstNode)
            values.addAll(rightBstNode.midFind());

        return values;
    }

    //后序遍历所有的节点
    public List<Object> rearFind() {
        List<Object> values = new ArrayList<>();

        // 左节点的遍历结果
        if (null != leftBstNode)
            values.addAll(leftBstNode.rearFind());

        // 右节点的遍历结果
        if (null != rightBstNode)
            values.addAll(rightBstNode.rearFind());

        // 当前节点
        values.add(value);

        return values;
    }
}

