package BinaryTreeTraversal;

import java.util.Stack;

public class BinaryTree {
	Node root;
	
	BinaryTree(){
		root=null;
	}
	
	BinaryTree(int key){
		root=new Node(key);
	}
	
	/*
	 * void insert(int key) { root=insertRec(root,key); }
	 * 
	 * Node insertRec(Node root, int key) { if(root==null) { root=new Node(key);
	 * return root; } if(key<root.key) { root.left=insertRec(root.left, key); } else
	 * if(key>root.key) { root.right=insertRec(root.right, key); } return root; }
	 */
	/*
	 * Inorder*
	 * starts from left then the key then right
	 * left-->key-->right
	 */
	void inorder() {
		inorderRec(root);
	}
	void inorderRec(Node root) {
		if(root!=null) {
		inorderRec(root.left);
		System.out.print(root.key+" ");
		inorderRec(root.right);}
	}
	
	void inorder_stack() {
		if(root==null)
			return;
		Stack<Node> s=new Stack<Node>();
		Node curr=root;
		while(curr!=null || s.size()>0) {
			while(curr!=null) {
				s.push(curr);
				curr=curr.left;
			}
			curr=s.pop();
			System.out.print(curr.key+" ");
			curr=curr.right;
		}
	}
	
	/*
	 * preorder*
	 * starts from the key then left then right
	 * key-->left-->right
	 */
	void preorder() {
		preorderRec(root);
	}
	void preorderRec(Node root) {
		if(root!=null) {
		System.out.print(root.key+" ");
		preorderRec(root.left);
		preorderRec(root.right);}
	}
	void preorder_stack() {
		if(root==null)
			return;
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()) {
			Node node=s.pop();
			System.out.print(node.key+" ");
			if(node.right!=null)
				s.push(node.right);
			if(node.left!=null)
				s.push(node.left);
		}
	}
	
	/*
	 * postorder*
	 * starts from the left then the right then key
	 * left-->right-->key
	 */
	void postorder() {
		postorderRec(root);
	}
	void postorderRec(Node root) {
		if(root!=null) {
		postorderRec(root.left);
		postorderRec(root.right);
		System.out.print(root.key+" ");}
	}
	void postorder_stack() {
		if(root==null)
			return;
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		Node prev=null;
		while(!s.empty()) {
			Node current=s.peek();
			if(prev==null || prev.left==current||prev.right==current) {
				if(current.left!=null)
					s.push(current.left);
				else if(current.right!=null)
					s.push(current.right);
				else {
					s.pop();
					System.out.print(current.key+" ");
				}
			}
			else if(current.left==prev) {
				if(current.right!=null)
					s.push(current.right);
				else {
					s.pop();
					System.out.print(current.key+" ");
				}
			}
			else if(current.right==prev) {
				s.pop();
				System.out.print(current.key+" ");
			}
			prev=current;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree=new BinaryTree();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		System.out.print("Inorder recursion: ");
		tree.inorder();
		System.out.print("Inorder stack: ");
		tree.inorder_stack();
		System.out.println("");
		System.out.print("Preorder: ");
		tree.preorder();
		System.out.print("Preorder stack: ");
		tree.preorder_stack();
		System.out.println("");
		System.out.print("Postorder: ");
		tree.postorder();
		System.out.print("Postorder stack: ");
		tree.postorder_stack();
	}

}
