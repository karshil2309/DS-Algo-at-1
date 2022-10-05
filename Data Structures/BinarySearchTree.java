import java.util.*;

class MainNode {
	int data;
	MainNode left, right;

	MainNode(int data)
	{
		this.data = data;
		left = right = null;
	}
}

class BinarySearchTree {

public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		int post[] = new int[] { 1, 7, 5, 50, 40, 10 };
		int size = post.length;

		MainNode root = bst.constructTree(post, size);
		bst.printInorder(root);
	}
  
	MainNode constructTreeUtil(int post[], int n)
	{
		MainNode root = new MainNode(post[n - 1]);
		Stack<MainNode> s = new Stack<>();
		s.push(root);

		for (int i = n - 2; i >= 0; --i) {
			
			MainNode x = new MainNode(post[i]);

			MainNode temp = null;
			while (!s.isEmpty() && post[i] < s.peek().data)
				temp = s.pop();	
			if (temp != null){
				temp.left = x;	
        }
			else{
				s.peek().right = x;
        }
			s.push(x);
		}
		return root;
	}
	MainNode constructTree(int post[], int size)
	{
		return constructTreeUtil(post, size);
	}

	void printInorder(MainNode node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	
}
