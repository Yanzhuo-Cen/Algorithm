package com.algorithm.entity;

public class Node {
    public int val;
    public Node left;
    public Node right;

    //构造方法
    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
