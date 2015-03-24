/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 *
 * @author taxidriver
 */
public class GraphProperties {

    Graph newG; 

    public GraphProperties(Graph G) {

        Graph newG = new Graph(G.V());
        newG = G;

    }

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
        dist2 = eccAtV;
        return eccAtV;

    }

    public int diameter() {

        int diameter = 0;
        int ecc1 = 0;
        int ecc2 = 0;
        //store eccentricities in array, loop through and find max eccentricity
        for (int i = 0; i < newG.V(); i++) {
            ecc1 = eccentricity(i);
            if (ecc1 > ecc2) {
                ecc2 = ecc1;
            }
        }
        diameter = ecc2;
        return diameter;

    }

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
}
