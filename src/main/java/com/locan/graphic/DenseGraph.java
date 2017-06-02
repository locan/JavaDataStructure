package com.locan.graphic;

/**
 * Created by luan on 2017/6/2.
 */
public class DenseGraph implements Graph{
    private Integer n;
    private Integer m;

    private boolean isDirected;
    private boolean[][]g;

    public DenseGraph(int n,boolean isDirected){
        this.n = n;
        this.m = 0;

        this.isDirected = isDirected;
        g = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                g[i][j] = false;
            }
        }

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

        if(hasEdge(v,w))
            return;
        g[v][w] = true;
        if(!isDirected){
            g[w][v] = true;
        }
        m++;
    }
    @Override
    public boolean hasEdge(int v,int w){
        if(v>=n||w>=n){
            // 判断越界
            return false;
        }
        return g[v][w];
    }



}
