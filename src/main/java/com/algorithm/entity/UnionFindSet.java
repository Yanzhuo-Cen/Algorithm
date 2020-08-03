package com.algorithm.entity;


import java.util.ArrayList;

public class UnionFindSet {

    public ArrayList<Integer> arrayList;
    public ArrayList<Integer> rank;
    public int num;

    public UnionFindSet(){
        arrayList=new ArrayList<>();
        rank=new ArrayList<>();
        num=0;
    }

    public void add(int m){
        for (int i=0; i<m; i++) {
            arrayList.add(i);
            rank.add(0);
            num+=1;
        }
    }

    public ArrayList<Integer> unionRes(){
        for(int i=0; i<arrayList.size(); i++){
            int u=arrayList.get(i);
            while (arrayList.get(u) != u) {
                u = find(arrayList.get(u));
            }
            arrayList.set(i,u);
        }
        return arrayList;
    }

    public int find(int u){
        while (arrayList.get(u)!=u){
            u=find(arrayList.get(u));
        }
        return u;
    }

    public boolean union(int u, int v){
        int uroot=find(u);
        int vroot=find(v);
        if(uroot==vroot)
            return false;
        if(rank.get(uroot)>rank.get(vroot)){
            arrayList.set(vroot,uroot);
        }else if(rank.get(uroot)<rank.get(vroot)){
            arrayList.set(uroot,vroot);
        }else {
            arrayList.set(vroot,uroot);
            rank.set(uroot,rank.get(uroot)+1);
        }
        num-=1;
        return true;
    }

    public boolean same(int a, int b){
        while (arrayList.get(a)!=a){
            a=find(arrayList.get(a));
        }
        while (arrayList.get(b)!=b){
            b=find(arrayList.get(b));
        }
        return a == b;
    }
}
