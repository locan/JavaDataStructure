package com.locan.graphic;

/**
 * Created by luan on 2017/6/2.
 */
public abstract class Graph {

    abstract public Integer V();
    abstract public Integer E();

    abstract public void addEdge(int v,int w);

    abstract boolean hasEdge(int v,int w);


}
