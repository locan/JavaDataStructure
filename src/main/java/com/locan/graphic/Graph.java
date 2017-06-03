package com.locan.graphic;

import java.util.Iterator;

/**
 * Created by luan on 2017/6/2.
 */
public interface Graph {

    public Integer V();
    public Integer E();

    public void addEdge(int v,int w);

    boolean hasEdge(int v,int w);

    public GraphIterator iterator();


}
