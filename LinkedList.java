import java.util.*;
class LinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		ListNode cur = head.next.next.next;
		cur.next = new ListNode(4);
		cur.next.next = new ListNode(5);
		System.out.println("Find the nth Node: "); 
		print(findNthNode(head, 2));
		System.out.println("Remove the nth Node: ");
		print(removeNthFromEnd(head, 2));
		System.out.println("If true there is a cycle?" + hasCycle(head));
		System.out.println("Reverse");
		print(reverse(head));
		System.out.println("Reverse recursively");
		print(reverseList(head));
		
	}
	public static void print(ListNode head){
		while(head != null){
			System.out.print(head.val);
			System.out.print(" -> ");
			head = head.next;
		}
		System.out.println("null");
	}

	public static ListNode findNthNode(ListNode head, int n){
		if (head == null) return null;
		
		while(n-- > 0){
			head = head.next;
		}
		return head;
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode first = head;
		for (int i = 0; i < n; i++){
			first = first.next;
		}
		while(first != null && first.next != null){
			first = first.next;
			head = head.next;
		}
		head.next = head.next.next;
		return dummy.next;
	}
//	public ListNode removeElements(ListNode head, int val) {
//		if (head == null) return null;
//		head.next = removeElements(head.next, val);
//		return head.val == val ? head.next : head;
//	}
	
	public static boolean hasCycle(ListNode head){
		if (head == null || head.next == null){
			return false;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while(slow != fast){
			if (fast == null || fast.next == null){
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
			
	public static ListNode removeElements(ListNode head, int val){
		if (head == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		while(head.next != null){
			if (head.next.val == val){
				head.next = head.next.next;
			}else{
				head = head.next;
			}
		}
		return dummy.next;
	}
	public static ListNode reverseList(ListNode head) {
		/* recursive solution */
		return reverseListInt(head, null);
	}

	private static ListNode reverseListInt(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverseListInt(next, head);
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
			
		while (head != null){
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		} 
		return prev;
	}
	
}
class ListNode{
	ListNode next = null;
	int val;
	public ListNode(int val){
		this.val = val;
	}
}