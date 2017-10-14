import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testLowestCommonAncestor() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		
		bst.put(7, 7);
		bst.put(5, 5);
		bst.put(12, 12);
		bst.put(3, 3);
		bst.put(6, 6);
		bst.put(1, 1);
		bst.put(4, 4);
		bst.put(9, 9);
		bst.put(8, 8);
		bst.put(15, 15);
		bst.put(10, 10);
		bst.put(15, 15);
		bst.put(13, 13);
		bst.put(17, 17);
		
		
        
		assertEquals(bst.get(7),bst.LCA(5, 12));
		assertEquals(bst.get(7),bst.LCA(5, 6));
		assertEquals(bst.get(5),bst.LCA(4, 6));
		assertEquals(bst.get(12),bst.LCA(9, 17));
		assertEquals(bst.get(7),bst.LCA(8, 12));
	}

}


