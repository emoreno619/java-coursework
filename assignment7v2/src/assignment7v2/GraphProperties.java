/*
 * GraphProperties by Eduardo Moreno -- 05/07/14
 * Description: This class contains methods for analyzing
 * an undirected graph. Specifically, it contains an eccentricity(int)
 * method which takes the vertex for which eccentricity is desired and returns
 * an int which represents that eccenctricty. The diameter method returns the
 * diameter of the graph (i.e., the maximum eccentricity for the graph); the
 * radius method returns the radius of the graph (i.e., the minimum eccentricity
 * for the graph); and the center method returns the vertex of the radius.
 */
package assignment7v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphProperties {

    Graph newG; 
    
    //GraphProperties constructor takes a Graph object as a parameter, copies
    //the graph into a new reference variable, newG.

    public GraphProperties(Graph G) {
        
        newG = new Graph(G.V());
        newG = G;

    }
    
    //eccentricity method takes an int, v, which is the vertex for which the
    //desired eccentricity will be calculated. eccentricity is defined as the
    //length of the shortest path from a vertex to the furthest vertex from it.
    //returns an int which is the calculated eccentricity
    
    public int eccentricity(int v) {
        int eccAtV = 0;
        int dist2 = 0;
        int dist1 = 0;
        BreadthFirstPaths search = new BreadthFirstPaths(newG, v);
        int numOfVert = newG.V();
        
        for (int x = 0; x < numOfVert; x++) {
            dist1 = search.distTo(x);
            if (dist1 > dist2 && dist1 != Integer.MAX_VALUE) {
                dist2 = dist1;
            }
        }
        eccAtV = dist2;
        return eccAtV;

    }

    //diameter method returns the maximum eccentricity in a graph. calls
    //eccentricity method.
    public int diameter() {

        int diameter = 0;
        int ecc1 = 0;
        int ecc2 = 0;
     
        for (int i = 0; i < newG.V(); i++) {
            ecc1 = eccentricity(i);
            if (ecc1 > ecc2) {
                ecc2 = ecc1;
            }
        }
        diameter = ecc2;
        return diameter;

    }

    //radius method returns the minimum eccentricity in a graph. calls
    //eccentricity method.
    public int radius() {
        int ecc1 = Integer.MAX_VALUE;
        int ecc2 = Integer.MAX_VALUE;
        int radius = 0;
        //same as diameter except find smallest eccentricity
        for (int i = 0; i < newG.V(); i++) {
            ecc1 = eccentricity(i);
            if (ecc1 < ecc2) {
                ecc2 = ecc1;
            }
        }
        radius = ecc2;
        return radius;

    }

    //center method returns the vertext of minimum eccentricity in a graph. 
    //calls eccentricity method.
    public int center() {

        int center = 0;
        //same as radius except return vertex of smallest eccentricity
        int ecc1 = Integer.MAX_VALUE;
        int ecc2 = Integer.MAX_VALUE;
        int radius = 0;
        for (int i = 0; i < newG.V(); i++) {
            ecc1 = eccentricity(i);
            if (ecc1 < ecc2) {
                ecc2 = ecc1;
                center = i;
            }
        }
        
        return center;

    }
    
    public static void main(String[] args) {
        Graph g = null;
        try {
            try (Scanner file = new Scanner(new File(args[0]))) {
                g = new Graph(file);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        GraphProperties gp = new GraphProperties(g);
         
        for (int i = 0; i < g.V(); i++)
        System.out.println("vertex = " + i + " eccentricity = " + gp.eccentricity(i));
        System.out.println();
        System.out.println("The diameter of the graph is: " + gp.diameter());
        System.out.println("The radius of the graph is: " + gp.radius());
        System.out.println("The center of the graph is: " + gp.center());
        
    }
}
