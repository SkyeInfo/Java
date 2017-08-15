/**************************************
 * 反转链表程序，不借助新链表
 **************************************/
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
public class Solution1 {
	public ListNode ReverseList(ListNode head) {
		/*有点指针的意思 .next就表示下一个节点*/
		if(head == null){
			return null;
		}
		ListNode pre = null;//head前一个节点
		ListNode next_node = null;//head下一个节点
		while (head != null) {
			next_node = head.next;
			head.next = pre;
			pre = head;
			head = next_node;
		}
		return head;
	}
}