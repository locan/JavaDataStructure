package com.locan.graphic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by luan on 2017/6/4.
 */
public class ReadGraph {

    public ReadGraph(Graph graph,final String fileName){

        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            int V = scanner.nextInt();
            int E = scanner.nextInt();

            for(int i=0;i<V;i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if(a<0||a>=V||b<0||b>=V){
                    continue;
                }
               // System.out.println("a : "+a+" b:"+b);
                graph.addEdge(a,b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String fileName = "src/main/resources/testG1.txt";
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            int V = scanner.nextInt();
            int E = scanner.nextInt();
            System.out.println("V : "+V+" E :"+E);
            for(int i=0;i<V;i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if(a<0||a>=V||b<0||b>=V){
                    continue;
                }
               // System.out.println("a : "+a+" b:"+b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
