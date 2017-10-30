import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testLowestCommonAncestor() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		bst.put(7, 7);			//sample binary search tree constructed: root = 7
		bst.put(5, 5);			//				 _____7____
        bst.put(12, 12);		//			    /          \
		bst.put(3, 3);			//           __5__        __12__
		bst.put(6, 6);			//          /     \      /      \
		bst.put(1, 1);			//        _3_      6   _9_      _15_
 		bst.put(4, 4);			//       /   \        /   \    /    \
		bst.put(9, 9);			//      1     4      8     10 13     17
		bst.put(8, 8);
		bst.put(15, 15);
		bst.put(10, 10);
		bst.put(15, 15);
		bst.put(13, 13);
		bst.put(17, 17);
		
		
        assertEquals(bst.get(7),bst.LCA(7, 7));  //check for ancestor of root
        assertEquals(bst.get(7),bst.LCA(7, 4));
		assertEquals(bst.get(7),bst.LCA(5, 12));
		assertEquals(bst.get(7),bst.LCA(5, 6));
		assertEquals(bst.get(5),bst.LCA(4, 6));
		assertEquals(bst.get(12),bst.LCA(9, 17));
		assertEquals(bst.get(7),bst.LCA(8, 12));
		assertEquals(bst.get(3),bst.LCA(1, 4));
		assertEquals(bst.get(5),bst.LCA(3, 6));
		assertEquals(bst.get(12),bst.LCA(8, 13));
		assertEquals(bst.get(15),bst.LCA(13, 17));
	}
	
	@Test
	public void testLowestCommonAncestorDAG() {
		DAG dag = new DAG(8);
		
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		dag.addEdge(2, 4);
		dag.addEdge(2, 5);
		dag.addEdge(3, 6);
		dag.addEdge(4, 7);
		dag.addEdge(5, 7);
		dag.addEdge(6, 5);
		dag.addEdge(6, 7);
		
//		assertEquals(4,dag.LCA(1, 4));
//		assertEquals(7,dag.LCA(3, 4));
//		assertEquals(5,dag.LCA(2, 3));
//		assertEquals(5,dag.LCA(6, 2));
//		assertEquals(7,dag.LCA(1, 7));
		
	}
	
	@Test
	public void testBFS() {
		DAG dag = new DAG(8);
		
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		dag.addEdge(2, 4);
		dag.addEdge(2, 5);
		dag.addEdge(3, 6);
		dag.addEdge(4, 7);
		dag.addEdge(5, 7);
		dag.addEdge(6, 5);
		dag.addEdge(6, 7);
		
		ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(2,3,4,5,6,7));
		ArrayList<Integer> test2 = new ArrayList<>(Arrays.asList(4,5,7));
		ArrayList<Integer> test3 = new ArrayList<>(Arrays.asList(5,6,7));
		ArrayList<Integer> test4 = new ArrayList<>(Arrays.asList(7));
		ArrayList<Integer> test5 = new ArrayList<>(Arrays.asList(7));
		ArrayList<Integer> test6 = new ArrayList<>(Arrays.asList(5,7));
		ArrayList<Integer> test7 = new ArrayList<>();
		
		assertTrue(dag.BFS(1).containsAll(test1));
		assertTrue(dag.BFS(2).containsAll(test2));
		assertTrue(dag.BFS(3).containsAll(test3));
		assertTrue(dag.BFS(4).containsAll(test4));
		assertTrue(dag.BFS(5).containsAll(test5));
		assertTrue(dag.BFS(6).containsAll(test6));
		assertTrue(dag.BFS(7).containsAll(test7));
		
	}

}


