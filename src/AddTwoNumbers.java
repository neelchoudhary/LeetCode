import java.util.HashMap;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class SolutionAddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		HashMap<Integer, Integer> hm1 = listNodeToNumber(l1);
		HashMap<Integer, Integer> hm2 = listNodeToNumber(l2);

		ListNode finalLn = createListNode(hm1, hm2, l1, l2);
		System.out.println(listNodeToNumber(finalLn));
		return finalLn;
	}

	public HashMap<Integer, Integer> listNodeToNumber(ListNode ln) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		while (ln != null) {
			map.put(count, ln.val);
			count++;
			ln = ln.next;
		}
		return map;
	}

	public ListNode createListNode(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2, ListNode ln1,
			ListNode ln2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		int count = 0;
		int carryover = 0;
		int size = Integer.max(map1.size(), map2.size());
		while (count < size) {
			int sum;
			if (map1.get(count) == null) {
				sum = map2.get(count);
			} else if (map2.get(count) == null) {
				sum = map1.get(count);
			} else {
				sum = map1.get(count) + map2.get(count);
			}
			sum += carryover;
			current.next = new ListNode(sum % 10);

			if (sum > 9) {
				carryover = 1;
			} else {
				carryover = 0;
			}
			current = current.next;
			count++;
		}
		
		if (carryover == 1) {
			current.next = new ListNode(1);
		}

		return result.next;
	}
}


public class AddTwoNumbers {

  public static void main(String[] args) {
    SolutionAddTwoNumbers s = new SolutionAddTwoNumbers();
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    s.addTwoNumbers(l1, l2);
    ListNode l3 = new ListNode(8);
    l3.next = new ListNode(8);
    l3.next.next = new ListNode(8);
    ListNode l4 = new ListNode(8);
    l4.next = new ListNode(8);
    l4.next.next = new ListNode(8);
    s.addTwoNumbers(l3, l4);
  }
}