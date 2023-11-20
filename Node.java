package tree;

import java.util.ArrayList;
import java.util.List;

class Node<U extends Comparable<U>> {
	public U value;
	public Node<U> left, right;
	public int height;
	public int balanceF;

	public Node(U element) {
		value = element;
		left = right = null;
		this.height=1;
		this.balanceF=0;
	}

	

	public void printNodesPreOrder() {
		System.out.println(value);
		if (left != null)
			left.printNodesPreOrder();
		if (right != null)
			right.printNodesPreOrder();
	}

	public void printNodesInOrder() {
		if (left != null)
			left.printNodesInOrder();
		System.out.println(value);
		if (right != null)
			right.printNodesInOrder();
	}

	public void printNodesPostOrder() {
		if (left != null)
			left.printNodesPostOrder();
		if (right != null)
			right.printNodesPostOrder();
		System.out.println(value);
	}
	
	
	public void RotEsquerdaSimples() {
		//marcação
		Node<U> nodeA=this;
		Node<U> nodeB=this.right;	
		Node<U> nodeD=nodeB.left;	
		
		nodeB.left=nodeA;
		nodeA.right=nodeD;
		
		
		nodeA.newHeight();
		nodeB.newHeight();
		
		
	}
	
	public void RotDireitaSimples() {
		Node<U> nodeA=this;
		Node<U> nodeB=this.left;	
		Node<U> nodeD=nodeB.right;	
		
		nodeB.right=nodeA;
		nodeA.left=nodeD;
		
		
		nodeA.newHeight();
		nodeB.newHeight();
		
		
	}
	
	public void RotduplaEsquerda() {
		Node<U> nodeA=this;
		Node<U> nodeB=this.right;	
		Node<U> nodeC=nodeB.left;
		
		Node<U> nodeCLeft= nodeC.left;
		Node<U> nodeCright= nodeC.right;
		
		nodeA.right = nodeCLeft;
		nodeB.left=nodeCright;
		nodeC.left= nodeA;
		nodeC.right= nodeB;
		
		nodeA.newHeight();
		nodeB.newHeight();
		nodeC.newHeight();
	}
	
	public void RotDuplaDireita() {
		
		Node<U> nodeA=this;
		Node<U> nodeB=this.left;	
		Node<U> nodeC=nodeB.right;
		//----------------------------------
		Node<U> nodeCLeft= nodeC.left;
		Node<U> nodeCright= nodeC.right;
		
		nodeA.left = nodeCright;
		nodeB.right=nodeCLeft;
		nodeC.right= nodeA;
		nodeC.left= nodeB;
		
		nodeA.newHeight();
		nodeB.newHeight();
		nodeC.newHeight();
		
	}
	public void newHeight () {
		int leftHeight = 0;
		int rightHeight = 0;
		if(this.left != null) {
			leftHeight = left.height;
		}
		if(this.right != null) {
			rightHeight = right.height;
		}
		this.height = 1 + Integer.max(leftHeight, rightHeight);
		balanceF = rightHeight - leftHeight;
	}
	
	
	}
	