
/******************
 * 三种方式打印二叉树
 * 递归实现
 * ************/
class Node{
	public int val;
	public Node left;
	public Node rigth;
	public Node(int val) {
		this.val = val;
	}
}
public class printBinTree{
	//前序遍历
	public void prePrint(Node head){
		if (head == null) {
			return;
		}
		System.out.print(head.val+" ");
		prePrint(head.left);
		prePrint(head.rigth);
	}
	//中序遍历
	public void midPrint(Node head){
		if (head == null) {
			return;
		}
		midPrint(head.left);
		System.out.print(head.val+" ");
		midPrint(head.rigth);
	}
	//后序遍历
	public void backPrint(Node head){
		if (head == null) {
			return;
		}
		backPrint(head.left);
		backPrint(head.rigth);
		System.out.print(head.val+" ");
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.rigth = new Node(3);
		
		head.left.left = new Node(4);
		head.left.rigth = new Node(5);
		head.rigth.left = new Node(6);
		head.rigth.rigth = new Node(7);
		
		printBinTree pbt = new printBinTree();
		pbt.prePrint(head);
		System.out.println();
		System.out.println("------------");
		pbt.midPrint(head);
		System.out.println();
		System.out.println("-------------");
		pbt.backPrint(head);
	}
}
