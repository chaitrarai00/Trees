package heightofgivenbinarytree;

public class BinaryTree {
		Node root;
		
		/*
		 * Method to find the height of the tree*
		 */
		int maxdepth(Node root) {
			if(root==null)
				return 0;
			else {
				int left_side_depth=maxdepth(root.left);
				int right_side_depth=maxdepth(root.right);
				//find largest of left and right
				return Math.max(left_side_depth, right_side_depth)+1;
			}
		}
		/*
		 * Method to check if a tree is balanced*
		 * tree is balanced when both left and right subtree is balanced
		 * and the diff between the depth/height of left and right subtree 
		 * should not be greater than 1
		 * <=1 
		 */
		boolean isBalanced() {
			return isBalanced(root);
		}
		boolean isBalanced(Node root) {
			if(root==null)
				return true;
			int left_height=maxdepth(root.left);
			int right_height=maxdepth(root.right);
			if(Math.abs(left_height-right_height)<=1 && isBalanced(root.left) && isBalanced(root.right))
				return true;
			return false;
		}
		/*
		 * Method to count the leaf nodes*
		 */
		int getleafcount() {
			return getleafcount_Rec(root);
		}
		int getleafcount_Rec(Node root) {
			if(root==null)
				return 0;
			if(root.left==null && root.right==null)
				{System.out.println(root.key+" is a leaf node");
				return 1;}
			else
				return getleafcount_Rec(root.left) + getleafcount_Rec(root.right);
		}
		
	public static void main(String[] args) {
			BinaryTree tree=new BinaryTree();
			tree.root=new Node(1);
			tree.root.left=new Node(2);
			tree.root.right=new Node(3);
			tree.root.left.left=new Node(4);
			tree.root.left.right=new Node(5);
//			tree.root.left.right.right=new Node(6);
//			tree.root.left.right.left=new Node(7);
//			tree.root.left.right.left.right=new Node(8);
//			tree.root.left.right.left.right.right=new Node(9);
			System.out.println("The tree has the Height "+tree.maxdepth(tree.root));
			System.out.println(" so we have a total of "+tree.getleafcount()+" leaf nodes");
			if(tree.isBalanced())
				System.out.println("And the Tree is also balanced");
	}

}
