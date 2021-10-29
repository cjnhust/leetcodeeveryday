/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ) return null;
        ListNode result = null;
        for(int i=0;i<lists.length;i++){
            result = merge2lists(result,lists[i]);
        }
        return result;

    }

    private ListNode merge2lists(ListNode first,ListNode second){
        if(first == null && second==null) return null;
        if(first == null) return second;
        if(second == null) return first;
        ListNode p1 = first;
        ListNode p2 = second;
        ListNode result = new ListNode();
        ListNode p3 = result;
        while(first!=null||second!=null){
            if(first!=null&&second!=null){
                if(first.val<second.val){
                    p3.val = first.val;
                    first = first.next;
                }else{
                    p3.val = second.val;
                    second = second.next;
                }
            }else if(first!=null){
                p3.val = first.val;
                first = first.next;

            }else if(second!=null){
                p3.val = second.val;
                second = second.next;
            }
            if(!(first==null&&second == null)){
            p3.next = new ListNode();
            }
            p3 =p3.next;
        }
        return result;
    }
}
