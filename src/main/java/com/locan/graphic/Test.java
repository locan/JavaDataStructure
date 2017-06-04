package com.locan.graphic;

import java.util.Random;

/**
 * Created by luan on 2017/6/2.
 */
public class Test {
    public static void main(String[] args) {
        test2();
    }


    public static void test1(){
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
            SparseGraph.Itr iterator = graph.new Itr(graph,v);
            for(int w = iterator.begin();!iterator.end();w = iterator.next()){
                System.out.print(w+ " ");
            }
            System.out.println();
        }
    }

    public static void test2(){
        String baseRes = "src/main/resources/";
        String fileName1 = "testG1.txt";
        String fileName2 = "testG2.txt";
        SparseGraph sparseGraph = new SparseGraph(13,false);
        new ReadGraph(sparseGraph,baseRes+fileName1);
        Component<SparseGraph> component1 = new Component<>(sparseGraph);
        System.out.println("TestG1.txt, Component Count: "+component1.count());


        DenseGraph denseGraph = new DenseGraph(7,false);
        new ReadGraph(denseGraph,baseRes+fileName2);
        Component<DenseGraph> component2 = new Component<>(denseGraph);
        System.out.println("TestG2.txt, Component Count: "+component2.count());

    }
}
