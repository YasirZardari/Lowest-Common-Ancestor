import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testLowestCommonAncestor() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		DAG<Integer, Integer> dag = new DAG<Integer, Integer>();
		
		dag.put(4, 5);
		
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

}


