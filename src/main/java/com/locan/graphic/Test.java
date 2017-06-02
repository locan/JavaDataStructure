package com.locan.graphic;

import java.util.Random;

/**
 * Created by luan on 2017/6/2.
 */
public class Test {
    public static void main(String[] args) {
        int N = 20;
        int M = 100;
        int max =20;
        int min = 0;
        SparseGraph graph = new SparseGraph(20,false);
        Random random = new Random();
        for(int i=0;i<M;i++){
            int a = random.nextInt(max)%(max-min+1) + min;
            int b = random.nextInt(max)%(max-min+1) + min;
            //System.out.println(a+" -:- "+b);
            graph.addEdge(a,b);
        }
        for(int v=0;v<N;v++){
            System.out.println(v+" : ");
            SparseGraph.Iterator iterator = graph.new Iterator(graph,v);
            for(int w = iterator.begin();!iterator.end();w = iterator.next()){
                System.out.print(w+ " ");
            }
            System.out.println();
        }
    }
}
