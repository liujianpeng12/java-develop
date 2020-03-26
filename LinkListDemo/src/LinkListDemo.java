
public class LinkListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeManager nm=new NodeManager();
		nm.addNode("node1");
		nm.addNode("node2");
		nm.addNode("node3");
		nm.addNode("node4");
		nm.addNode("node5");
		nm.addNode("node6");
		nm.print();
		System.out.println();
		nm.delNode("node3");
		nm.delNode("node5");
		nm.print();
	}

}
class NodeManager{
	private Node root;
	
	public void addNode(String name){
		if(null==root){
			root=new Node(name);
		}else{
			root.add(name);
		}
	}
	
	public void delNode(String name){
		if(null!=root){
			if(root.name.equals(name)){
				root=root.next;
			}else{
				root.del(name);
			}
		}
	}
	
	public void print(){
		if(null!=root){
			System.out.print(root.name);
			root.print();
		}
	}
	
	class Node{
		private String name;
		private Node next;
		public Node(String name){
			this.name=name;
		}
		
		public void add(String name){
			if(null==this.next){
				this.next=new Node(name);
			}else{
				this.next.add(name);
			}
		}
		
		public void del(String name){
			if(null!=this.next){
				if(this.next.name.equals(name)){
					this.next=this.next.next;
				}else{
					this.next.del(name);
				}
			}
		}
		
		public void print(){
			if(null!=this.next){
				System.out.print("-->"+this.next.name);
				this.next.print();
			}
		}
	}
}
