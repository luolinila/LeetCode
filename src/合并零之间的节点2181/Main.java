package 合并零之间的节点2181;

import java.util.ArrayList;

public class Main {
    public ListNode mergeNodes(ListNode head) {
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            if (head.val == 0) {
                list.add(temp);
                temp = 0;
            }else {
                temp += head.val;
            }
            head = head.next;
        }
        ListNode newHead = new ListNode(temp);
        ListNode cur = newHead;
        for (int i = 0; i < list.size(); i++) {
            newHead.next = new ListNode(list.get(i));
            newHead = newHead.next;
        }
        return cur.next.next;
    }
}
