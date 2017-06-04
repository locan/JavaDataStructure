package com.locan.graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luan on 2017/6/2.
 */
public class SparseGraph implements Graph{

    private Integer n;
    private Integer m;

    private boolean isDirected;

    private List<List<Integer>> g;

    public SparseGraph(int n,boolean isDirected){
        this.n = n;
        this.m = 0;
        this.isDirected = isDirected;
        g = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
           // g.set(i,new ArrayList<>());
    }
    @Override
    public Integer V(){
        return n;
    }
    @Override
    public Integer E(){
        return m;
    }


    @Override
    public void addEdge(int v,int w){
        if(v>=n||w>=n){
            // 判断越界
            return;
        }
        g.get(v).add(w);

        if(v!=w&&!isDirected){
            g.get(w).add(v);
        }

        m++;
    }


    public GraphIterator iterator(int v){
        return new Itr(this,v);
    }
    @Override
    public boolean hasEdge(int v,int w){
        if(v>=n||w>=n){
            // 判断越界
            return false;
        }
        for(int i=0;i<g.get(v).size();i++){
            if(g.get(v).get(i)==w){
                return true;
            }
        }
        return false;
    }

    public class Itr implements GraphIterator{
        private SparseGraph graph;
        private int v;
        private int index;

        public Itr(SparseGraph graph,Integer v){
            this.graph = graph;
            this.v = v;
            this.index =0;
        }

        public int begin(){
            index =0;
            if(graph.g.get(v).size()!=0){
                return graph.g.get(v).get(index);
            }
            return -1;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        public Integer next(){
            index++;
            if(index<graph.g.get(v).size()){
                return graph.g.get(v).get(index);
            }
            return -1;
        }

        public boolean end(){
            return index>=graph.g.get(v).size();
        }
    }
}
