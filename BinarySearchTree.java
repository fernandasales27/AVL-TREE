package tree;



public class BinarySearchTree<T extends Comparable<T>> {

	public Node<T> root;

	public BinarySearchTree() {
		root = null;
	}
	
	public Node<T> insertNode(Node<T> newNode,T value) {
		if (root == null) {
			root = new Node<T>(value);
			return root;
		}
		else if (value.compareTo(newNode.value) < 0) {
			if (newNode.left == null) {
				newNode.left = new Node<T>(value);
				
				
			}
			else {
				newNode.left = insertNode(newNode.left,value);
			}
		} else if (value.compareTo(newNode.value) > 0) {
			if (newNode.right == null) {
				newNode.right = new Node<T>(value);
				
			}
			else
				newNode.right = insertNode(newNode.right,value);	
		}
		newNode.newHeight();
		if(newNode.balanceF == 2) {
			if(newNode.right.balanceF == -1) {
				var C = newNode.right.left;
				if (newNode == root) {
					root = C;
				}
				newNode.RotduplaEsquerda();
				return C;
			}else {
				var B = newNode.right;
				if (newNode == root) {
					root = B;
				}
				newNode.RotEsquerdaSimples();
				return B;
			}
		}
		else if(newNode.balanceF == -2) {
			if(newNode.left.balanceF == 1) {
				var C = newNode.left.right;
				if (newNode == root) {
					root = C;
				}
				newNode.RotDuplaDireita();
				return C;
			}else {
				var B = newNode.left;
				if (newNode == root) {
					root = B;
				}
				newNode.RotDireitaSimples();
				return B;
			}
		}
		return newNode;
	}
	

	public void insert(T obj) {
		insertNode(root,obj);
	}
	
	public void inOrder() throws EmptyTreeException {
		if (root != null) {
			root.printNodesInOrder();
		} else {
			throw new EmptyTreeException();
		}
	}
	
	public void preOrder() throws EmptyTreeException {
		if (root != null) {
			root.printNodesPreOrder();
		} else {
			throw new EmptyTreeException();
		}
	}

	public void postOrder() throws EmptyTreeException {
		if (root != null) {
			root.printNodesPostOrder();
		} else {
			throw new EmptyTreeException();
		}
	}
	
	public void remove(T element) {
		root = remove(root, element);
	}

	public Node<T> remove(Node<T> node, T element) {
		if (node == null) {
			return node;
		}

		int current = element.compareTo(node.value);

		if (current < 0) {
			node.left = remove(node.left, element);
		} else if (current > 0) {
			node.right = remove(node.right, element);
		} else {

			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			node.value = minValue(node.right);

			node.right = remove(node.right, node.value);
		}
		return node;
	}

	public T minValue(Node<T> node) {
		T minValue = node.value;
		while (node.left != null) {
			minValue = node.left.value;
			node = node.left;
		}
		return minValue;
	}
	
	public T min() throws EmptyTreeException {
		if (root == null) {
			throw new EmptyTreeException();
		}
		return min(root).value;
	}

	private Node<T> min(Node<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	
	public T max() throws EmptyTreeException {
		if (root == null) {
			throw new EmptyTreeException();
		}
		return max(root).value;
	}

	private Node<T> max(Node<T> node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	

	


}