package assignment7;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ***********************************************************************
 * Compilation: javac Graph.java Execution: java Graph input.txt Dependencies:
 * Bag.java In.java StdOut.java Data files:
 * http://algs4.cs.princeton.edu/41undirected/tinyG.txt
 *
 * A graph, implemented using an array of sets. Parallel edges and self-loops
 * allowed.
 *
 * % java Graph tinyG.txt 13 vertices, 13 edges 0: 6 2 1 5 1: 0 2: 0 3: 5 4 4: 5
 * 6 3 5: 3 4 0 6: 0 4 7: 8 8: 7 9: 11 10 12 10: 9 11: 9 12 12: 11 9
 *
 * % java Graph mediumG.txt 250 vertices, 1273 edges 0: 225 222 211 209 204 202
 * 191 176 163 160 149 114 97 80 68 59 58 49 44 24 15 1: 220 203 200 194 189 164
 * 150 130 107 72 2: 141 110 108 86 79 51 42 18 14 ...
 *
 ************************************************************************
 */
/**
 * The <tt>Graph</tt> class represents an undirected graph of vertices named 0
 * through <em>V</em> - 1. It supports the following two primary operations: add
 * an edge to the graph, iterate over all of the vertices adjacent to a vertex.
 * It also provides methods for returning the number of vertices <em>V</em> and
 * the number of edges <em>E</em>. Parallel edges and self-loops are permitted.
 * <p> This implementation uses an adjacency-lists representation, which is a
 * vertex-indexed array of {@link Bag} objects. All operations take constant
 * time (in the worst case) except iterating over the vertices adjacent to a
 * given vertex, which takes time proportional to the number of such vertices.
 * <p> For additional documentation, see <a
 * href="http://algs4.cs.princeton.edu/41undirected">Section 4.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /**
     * Initializes an empty graph with <tt>V</tt> vertices and 0 edges. param V
     * the number of vertices
     *
     * @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0
     */
    public Graph (){
        this.V = 0;
    }
    
    public Graph(int V) {
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
     * Initializes a graph from an input stream. The format is the number of
     * vertices <em>V</em>, followed by the number of edges <em>E</em>, followed
     * by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param in the input stream
     */
    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public boolean hasBiDirectionalEdge(int v, int w) {
        boolean flagV = false;
        boolean flagW = false;
        for (Integer x : adj(v)) {  //loop through v's adjacency list
            flagW = (x == w);  // flagW is true when w is in adj(v)
            if (flagW) {
                break;
            }
        }
        if (flagW) {
            for (Integer x : adj(w)) { //loop through w's adjacency list
                flagV = (x == v);  // flagV is true when v is in adj(w)
                if (flagV) {
                    break;
                }
            }
        }
        return flagV && flagW;
    }

    public boolean hasSelfLoop(int v) {
        boolean flag = false;
        for (Integer w : adj(v)) {
            flag = (w == v);  // flag = true if v is in the adjacency list for v
            if (flag) {
                break;
            }
        }
        return flag;
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return the number of vertices in the graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return the number of edges in the graph
     */
    public int E() {
        return E;
    }

    /**
     * Adds the undirected edge v-w to the graph.
     *
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
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
        adj[w].add(v);
    }

    public boolean hasEdge(int v, int w) {
        boolean found = false;
        for (int x : adj[w]) {
            if (x == v) {
                found = true;
                break;
            }
        }
        return found;

    }

    /**
     * Returns the vertices adjacent to vertex <tt>v</tt>.
     *
     * @return the vertices adjacent to vertex <tt>v</tt> as an Iterable
     * @param v the vertex
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) {
            throw new IndexOutOfBoundsException();
        }
        return adj[v];
    }

    /**
     * Returns a string representation of the graph. This method takes time
     * porportional to <em>E</em> + <em>V</em>.
     *
     * @return the number of vertices <em>V</em>, followed by the number of
     * edges <em>E</em>, followed by the <em>V</em> adjacency lists
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
     * Unit tests the <tt>Graph</tt> data type.
     */
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File(args[0]));
            Graph G = new Graph(in);
            System.out.println(G);
        } catch (FileNotFoundException fne) {
            System.out.println("Missing File");
        }


    }
}
