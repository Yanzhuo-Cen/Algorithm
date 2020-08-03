package com.algorithm.entity;


public class TrieTreeNode {

    public int count;  //出现次数
    public char ch;    //存储的字符
    public TrieTreeNode[] child;  //子节点数组

    //创建字典树
    public TrieTreeNode() {
        count = 1;
        child = new TrieTreeNode[26];  //存在26个字符
    }

    //添加字符串
    public void add(TrieTreeNode node, String str){
        if(str.length()==0)
            return;
        for(int i=0; i<str.length(); i++){
            int pos = str.charAt(i) - 'a';
            if(node.child[pos] == null){
                node.child[pos] = new TrieTreeNode();
            }else {
                node.child[pos].count+=1;
            }
            node.child[pos].ch = str.charAt(i);
            node = node.child[pos];
            System.out.println("node.char= " +node.ch);
        }
    }

    //查询字符串
    public int findCount(TrieTreeNode node, String str){
        if (str==null||str.length()==0) {
            return -1;
        }
        for(int i=0; i<str.length(); i++){
            int pos = str.charAt(i) - 'a';
            if(node.child[pos] == null){
                return 0;
            }
            node = node.child[pos];
        }
        return node.count;
    }
}
