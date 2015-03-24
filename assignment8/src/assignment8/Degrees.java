/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Degrees by Eduardo Moreno -- 05/15/14
 * Description: This class contains methods for analyzing
 * a directed graph. Specifically, it contains an indegree(int)
 * method which takes the vertex for which indegree is desired and returns
 * an int which represents that indegree (the number of vertices that point to
 * that vertex). The outdegree(int) method takes the vertex for which outdegree
 * is desired and returns that outdegree (the number of vertices that emanate from
 * that vertext). The sink() method returns an int which indicates how many
 * vertices have only other vertices pointing to them but none emanating from them,
 * and the source() method returns an int which indicates how many vertices have 
 * only vertices emanating from them but none pointing to them.
 */
public class Degrees {

    Digraph newDG;
    int[] inArray2;
    int[] outArray2;

    //Degress constructor takes a Digraph object as a parameter, copies
    //the graph into a new reference variable, newDG. Also, this constructor
    //creates two int arrays (inArray and outArray) that will store the counts
    //for the indegree and outdegree of each vertex. The graph is then looped
    //through and the arrays incremented accordingly.
    
    public Degrees(Digraph G) {

        newDG = G;
        int[] inArray = new int[newDG.V()];
        int[] outArray = new int[newDG.V()];

        for (int i = 0; i < newDG.V(); i++) {
            for (int j : newDG.adj(i)) {
                inArray[j]++;
                outArray[i]++;
            }
        }
        inArray2 = inArray;
        outArray2 = outArray;
    }

    //indegree() takes an int which represents the vertex to be investigated.
    //the method returns an int from the inArray which represents the number
    //of vertices pointing the vertex given as a parameter.
    
    public int indegree(int v) {
        return inArray2[v];
    }
    
    //outdegree() takes an int which represents the vertex to be investigated.
    //the method returns an int from the outArray which represents the number
    //of vertices emanating from the vertex given as a parameter.
    
    public int outdegree(int v) {
        return outArray2[v];
    }

    //sources() returns the number of vertices in the graph that only have
    //vertices emanating from them and no vertices pointing to them.
    
    public Iterable<Integer> sources() {
        ArrayList<Integer> sources = new ArrayList<>();
       
        for (int i = 0; i < newDG.V(); i++) {
            if (inArray2[i] == 0) {
                sources.add(i);
            }
        }
        return sources;
    }

    //sinks() returns the number of vertices in the graph that only have
    //vertices pointing to them and no vertices emanating from them.
    
    public Iterable<Integer> sinks() {

        ArrayList<Integer> sinks = new ArrayList<>();
        
        for (int i = 0; i < newDG.V(); i++) {
            if (outArray2[i] == 0) {
                sinks.add(i);
            }
        }
        return sinks;

    }

    public static void main(String[] args) {
        Digraph g = null;
        try {
            try (Scanner file = new Scanner(new File(args[0]))) {
                g = new Digraph(file);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        Degrees gp = new Degrees(g);

        for (int i = 0; i < g.V(); i++) {
            System.out.println("vertex = " + i + " indegree = " + gp.indegree(i));
            System.out.println("vertex = " + i + " outdegree = " + gp.outdegree(i));
            System.out.println();
        }
        System.out.println();
        System.out.println("Sources of the graph: " + gp.sources());
        System.out.println("Sinks of the graph: " + gp.sinks());
    }

}


