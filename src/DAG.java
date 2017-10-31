import java.util.ArrayList;
import java.util.LinkedList;

/*************************************************************************
 *  Compilation:  javac DAG.java 
 *  Execution:    java DAG filename.txt 
 *  Dependencies: Bag.java In.java StdOut.java 
 *  Data files:   http://algs4.cs.princeton.edu/42directed/tinyDG.txt 
 * 
 *  A graph, implemented using an array of lists. 
 *  Parallel edges and self-loops are permitted. 
 * 
 *  % java DAG tinyDG.txt 
 *  13 vertices, 22 edges 
 *  0: 5 1  
 *  1:  
 *  2: 0 3  
 *  3: 5 2  
 *  4: 3 2  
 *  5: 4  
 *  6: 9 4 8 0  
 *  7: 6 9 
 *  8: 6  
 *  9: 11 10  
 *  10: 12  
 *  11: 4 12  
 *  12: 9  
 *   
 *************************************************************************/
 
/**
 *  The <tt>DAG</tt> class represents a directed graph of vertices 
 *  named 0 through <em>V</em> - 1. 
 *  It supports the following two primary operations: add an edge to the DAG, 
 *  iterate over all of the vertices adjacent from a given vertex. 
 *  Parallel edges and self-loops are permitted. 
 *  <p> 
 *  This implementation uses an adjacency-lists representation, which  
 *  is a vertex-indexed array of {@link Bag} objects. 
 *  All operations take constant time (in the worst case) except 
 *  iterating over the vertices adjacent from a given vertex, which takes 
 *  time proportional to the number of such vertices. 
 *  <p> 
 *  For additional documentation, 
 *  see <a href="http://algs4.cs.princeton.edu/42directed">Section 4.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 * 
 *  @author Robert Sedgewick 
 *  @author Kevin Wayne 
 */ 
 
public class DAG { 
    private final int V; 
    private int E; 
    private Bag<Integer>[] adj; 
     
    /**
     * Initializes an empty DAG with <em>V</em> vertices. 
     * @param V the number of vertices 
     * @throws java.lang.IllegalArgumentException if V < 0 
     */ 
    @SuppressWarnings("unchecked")
	public DAG(int V) { 
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a DAG must be nonnegative"); 
        this.V = V; 
        this.E = 0; 
        adj = (Bag<Integer>[]) new Bag[V]; 
        for (int v = 0; v < V; v++) { 
            adj[v] = new Bag<Integer>(); 
        } 
    } 
  
    /**
     * Returns the number of vertices in the DAG. 
     * @return the number of vertices in the DAG 
     */ 
    public int V() { 
        return V; 
    } 
 
    /**
     * Returns the number of edges in the DAG. 
     * @return the number of edges in the DAG 
     */ 
    public int E() { 
        return E; 
    } 
 
 
    /**
     * Adds the directed edge v->w to the DAG. 
     * @param v the tail vertex 
     * @param w the head vertex 
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V 
     */ 
    public void addEdge(int v, int w) { 
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1)); 
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException("vertex " + w + " is not between 0 and " + (V-1)); 
        adj[v].add(w); 
        E++; 
    } 
 
    /**
     * Returns the vertices adjacent from vertex <tt>v</tt> in the DAG. 
     * @return the vertices adjacent from vertex <tt>v</tt> in the DAG, as an Iterable 
     * @param v the vertex 
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V 
     */ 
    public Iterable<Integer> adj(int v) { 
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException(); 
        return adj[v]; 
    } 
 
    /**
     * Returns the reverse of the DAG. 
     * @return the reverse of the DAG 
     */ 
    public DAG reverse() { 
        DAG R = new DAG(V); 
        for (int v = 0; v < V; v++) { 
            for (int w : adj(v)) { 
                R.addEdge(w, v); 
            } 
        } 
        return R; 
    } 
 
  /**
     * Returns a string representation of the graph. 
     * This method takes time porportional to <em>E</em> + <em>V</em>. 
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,   
     *    followed by the <em>V</em> adjacency lists 
     */ 
    public String toString() { 
        StringBuilder s = new StringBuilder(); 
        String NEWLINE = System.getProperty("line.separator"); 
        s.append(V + " vertices, " + E + " edges " + NEWLINE); 
        for (int v = 0; v < V; v++) { 
            s.append(String.format("%d: ", v)); 
            for (int w : adj[v]) { 
                s.append(String.format("%d ", w)); 
            } 
            s.append(NEWLINE); 
        } 
        return s.toString(); 
    } 
    
    public ArrayList<Integer> BFS(int x){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	boolean visited[] = new boolean[V];
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	visited[x] = true;
		queue.add(x);
    	list.add(x);
		while(queue.size()!=0){
			x = queue.poll();
			Iterable<Integer> result = adj(x);
			for(int i : result){
				if (!visited[i])
                {
                    visited[i] = true;
                    queue.add(i);
                    list.add(i);
                }
			}
		}
    	
    	return list;
    }
    
    public int LCA(int x, int y){
    	ArrayList<Integer> xList = BFS(x);
    	ArrayList<Integer> yList = BFS(y);
    	ArrayList<Integer> commonAncestors = new ArrayList<>(xList);
    	commonAncestors.retainAll(yList);
    	ArrayList<Integer> result = new ArrayList<>(commonAncestors);
    	
    	for(int i : commonAncestors){
    		ArrayList<Integer> List = BFS(i);
    		List.remove(new Integer(i));
    		for(int j : List){
    			for(int k : commonAncestors){
    				if(j == k){
    					result.remove(new Integer(j));
    				}
    			}
    		}
    	}
    	
    	return result.get(0);
    	
    	
    }
    
 
}