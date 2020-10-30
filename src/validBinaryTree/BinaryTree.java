package validBinaryTree;


public class BinaryTree {
	Node root;
	
	void insert(int key) {
		root=insertRec(root, key);
	}
	Node insertRec(Node root, int key) {
		if(root==null) {
			root=new Node(key);
			return root;
		}
		if(key<root.key) {
			root.left=insertRec(root.left, key);
		}
		else if(key>root.key){
			root.right=insertRec(root.right, key);
		}
		return root;
	}
	
	boolean validBST() {
		return validBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	boolean validBST(Node root,int min,int max) {
		if(root==null)
			return true;
		if(root.key<=min || root.key>=max)
			return false;
		boolean isleft_validBST=validBST(root.left,min,root.key);
		boolean isright_validBST=validBST(root.right, root.key, max);
		if(!isleft_validBST || !isright_validBST)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(20);
		tree.insert(80);
		if(tree.validBST())
			System.out.println(tree+"is a valid BST");
		else
			System.out.println(tree+"is not a valid BST");
		BinaryTree tree1=new BinaryTree();
		tree1.root=new Node(1);
		tree1.root.left=new Node(2);
		tree1.root.right=new Node(3);
		tree1.root.left.left=new Node(4);
		tree1.root.left.right=new Node(5);
		if(tree1.validBST())
			System.out.println(tree1+"is a valid BST");
		else
			System.out.println(tree1+"is not a valid BST");
	}

}
