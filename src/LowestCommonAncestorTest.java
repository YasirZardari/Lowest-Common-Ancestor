import static org.junit.Assert.*;

import org.junit.Test;

public class LowestCommonAncestorTest {

	@Test
	public void testLowestCommonAncestor() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
//		bst.put(7, 7);  
//        bst.put(8, 8);   
//        bst.put(3, 3);  
//        bst.put(1, 1);
//        bst.put(2, 2);   
//        bst.put(6, 6);   
		
		bst.put(2, 2);
		bst.put(1, 1);
		bst.put(3, 3);
        
		//assertEquals(bst.get(7),bst.LCA(8, 9));
		assertEquals(bst.get(2),bst.LCA(1, 3));
	}

}


