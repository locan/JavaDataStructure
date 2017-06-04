package com.locan.graphic;

/**
 * 这个类中完成的图的深度遍历，并且使用深度遍历的方法对图进行判断 连通图的个数
 * Created by luan on 2017/6/2.
 */
public class Component<G extends Graph> {

    private G graph;

    private boolean[] visited;

    private Integer[] id;
    private Integer ccount;


    public Component(G graph) {
        this.graph = graph;

        this.ccount = 0;
        visited = new boolean[this.graph.V()];
        id = new Integer[this.graph.V()];
        for(int i =0; i<graph.V();i++){
            visited[i] = false;
            id[i] = -1;
        }


        for(int i=0;i<graph.V();i++){
            if(!visited[i]){
                dfs(i);
                ccount++;
            }
        }
    }


    private void dfs(int v){
        visited[v] = true;
        id[v] = ccount;
        GraphIterator iterator = graph.iterator(v);

        for(int i=iterator.begin();!iterator.end();i = iterator.next()){
            if(!visited[i]){
                dfs(i);
            }
        }

    }
    public int count(){
        return ccount;
    }


    public boolean isConnection(int v,int w){
        if(v<0||v>=graph.V())
            return false;
        if(w<0||w>=graph.V())
            return false;

        return id[v] == id[w];
    }

}
