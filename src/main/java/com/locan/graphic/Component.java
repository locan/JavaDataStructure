package com.locan.graphic;


/**
 * Created by luan on 2017/6/2.
 */
public class Component<G extends Graph> {

    private G graph;

    private boolean[] visited;

    private Integer ccount;


    public Component(G graph) {
        this.graph = graph;

        this.ccount = 0;
        visited = new boolean[this.graph.V()];
        for(int i =0; i<graph.V();i++)
            visited[i] = false;

        for(int i=0;i<graph.V();i++){
            if(!visited[i]){
                //dfs(i);
                ccount++;
            }
        }

        //ArrayList
    }

    public int count(){
        return ccount;
    }


}
