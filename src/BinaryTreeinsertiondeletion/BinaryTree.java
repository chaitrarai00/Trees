package BinaryTreeinsertiondeletion;

public class BinaryTree {

	Node root;
	
	BinaryTree(){
		root=null;
	}
	
	BinaryTree(int key){
		root=new Node(key);
	}

	class Node{
		int key;
		Node right,left;
		Node(int key){
			this.key=key;
			this.right=null;
			this.left=null;
		}
	}
	
	void insert(int key) {
		root=insertRec(root,key);
	}
	
	Node insertRec(Node root, int key) {
		if(root==null)
		{
			root=new Node(key);
			return root;
		}
		if(key<root.key) {
			root.left=insertRec(root.left, key);
		}
		else if(key>root.key) {
			root.right=insertRec(root.right, key);
		}
		return root;
	}
	
	void inorder() {
		inorderRec(root);
	}
	
	void inorderRec(Node root) {
		if(root!=null) {
			inorderRec(root.left);
			System.out.print(root.key+" ");
			inorderRec(root.right);
		}
	}
	
	void deleteKey(int key) {
		root=deleteRec(root, key);
	}
	
	Node deleteRec(Node root, int key) {
		if(root==null)
			return root;
		if(key<root.key)
			root.left=deleteRec(root.left, key);
		else if(key>root.key)
			root.right=deleteRec(root.right, key);
		else {
			//when key is reached
			//node has onely one child / no child
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			//nodes with 2 or more children find inorder successor and replace
			root.key=minvalue(root.right);
			//delete the node
			root.right=deleteRec(root.right, root.key);
		}
		return root;
	}
	
	/*
	 * getting the inorder successor
	 */
	int minvalue(Node root) {
		int minv=root.key;
		if(root.left!=null) {
			minv=root.left.key;
			root=root.left;
		}
		return minv;
	}
	/*
	 * method checks if the node exists/ undergoes a search 
	 */
	boolean ifNodeExists(Node root,int key) {	
		if(root==null)
			return false;
		
		if(root.key==key)
			return true;
		
		boolean res_left=ifNodeExists(root.left, key);
		if(res_left) return true;
		
		boolean res_right=ifNodeExists(root.right, key);
		return res_right;
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
		tree.inorder();
		System.out.println("");
		if(tree.ifNodeExists(tree.root, 10))
			tree.deleteKey(20);
		tree.inorder();
		System.out.println("");
		if(tree.ifNodeExists(tree.root, 30))
			tree.deleteKey(30);
		tree.inorder();
		System.out.println("");
		tree.deleteKey(50);
		tree.inorder();
	}
}
