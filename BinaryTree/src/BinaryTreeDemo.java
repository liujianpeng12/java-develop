//二叉树数据结构
public class BinaryTreeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(8);
		bt.add(3);
		bt.add(13);
		bt.add(6);
		bt.add(89);
		bt.add(4);
		bt.add(223);
		bt.add(1);
		bt.add(67);
		bt.print();
	}

}

class BinaryTree {
	private Node root;

	public void add(int data) {
		if (null == root) {
			root = new Node(data);
		} else {
			root.addNode(data);
		}
	}
	
	public void print(){
		if(null!=root){
			root.printNode();
		}
	}

	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

		public void addNode(int data) {
			if (data <= this.data) {
				if (null == this.left) {
					this.left = new Node(data);
				} else {
					this.left.addNode(data);
				}
			} else if (data > this.data) {
				if (null == this.right) {
					this.right = new Node(data);
				} else {
					this.right.addNode(data);
				}
			}
		}
		
		//中序遍历:左->中->右
		public void printNode(){
			if(null!=this.left){
				this.left.printNode();
			}
			System.out.print(this.data+" ");
			if(null!=this.right){
				this.right.printNode();
			}
		}
	}
}
