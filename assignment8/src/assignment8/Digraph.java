package assignment8;


import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Digraph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /**
     * Create an empty graph with V vertices.
     *
     * @throws java.lang.IllegalArgumentException if V < 0
     */
    public Digraph(int V) {
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Create a digraph from input stream.
     */
    public Digraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {;
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    /**
     * Return the number of vertices in the graph.
     */
    public int V() {
        return V;
    }

    /**
     * Return the number of edges in the graph.
     */
    public int E() {
        return E;
    }

    /**
     * 
     *
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0
     * <= w < V
     */
    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) {
            throw new IndexOutOfBoundsException();
        }
        if (w < 0 || w >= V) {
            throw new IndexOutOfBoundsException();
        }
        E++;
        adj[v].add(w);
        // adj[w].add(v);
    }

    public boolean hasEdge(int v, int w) {
        boolean flag = false;
        for (Integer x : adj(v)) {
            if (x == w) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Return the list of neighbors of vertex v as in Iterable.
     *
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) {
            throw new IndexOutOfBoundsException();
        }
        return adj[v];
    }
    
    

    public Digraph reverse() {
        /*
         * Create a directed graph with V edges and no edges.
         */
        Digraph R = new Digraph(V);
        
        /*  If the original graph has an edge
         * from v to w then the reverse graph has an 
         *  edge from w to v.
         */
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }

    /**
     * Return a string representation of the graph.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    /**
     * Test client.
     */
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File(args[0]));
             Digraph G = new Digraph(in);
            System.out.println(G);
        } catch (FileNotFoundException fnfe) {
        }
    }
}
