package treefromarray;


public class Tree {
	
	Node root;
	
	static class Node{
		int data;
		Node left,right;
		
		Node(int data){
			this.data=data;
			System.out.print(this.data);
			this.left=null;
			this.right=null;
		}
	}
	
	public static Node insertLevelOrder(int[] array,Node root,int i) {
		//until the last node
		if(i<array.length) {
			Node temp=new Node(array[i]);
			root=temp;
			//let the function handle the rest of node at left
			root.left=insertLevelOrder(array, root, (2*i)+1);
			//let the function handle the rest of node at right
			root.right=insertLevelOrder(array, root,(2*i)+2);
		}
		return root;
	}
	
	public static void main(String[] args) {
		Tree t1=new Tree();
		int arr[]= {1,2,3,4,5,6,6,6};
		t1.root=insertLevelOrder(arr,t1.root,0);
	}

}
