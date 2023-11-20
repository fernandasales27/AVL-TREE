package tree;

public class AppMain {
	

	public static void main(String[] args) {
		
		try {
			BinarySearchTree<Integer> alunosADS = new BinarySearchTree<Integer>();

			alunosADS.insert(50);
			alunosADS.insert(1);
			alunosADS.insert(34);
			
			
			alunosADS.insert(11);
			alunosADS.insert(3);
		
			
			//alunosADS.remove("Ingrid");
			//alunosADS.inOrder();
			
			
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
	}

}
