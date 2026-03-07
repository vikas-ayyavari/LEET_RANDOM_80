// 23. Merge k Sorted Lists
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
        if(lists.length == 0) return null;
        ListNode res  = new ListNode(0); 
        res.next = lists[0];       
        for(int i =1;i < lists.length;i++){
            ListNode first = res.next;
            ListNode second = lists[i];
            ListNode temp = new ListNode(0);
            ListNode t = temp;
            while(first != null && second != null){
                if(first.val < second.val){
                    t.next  = first;
                    first   = first.next;
                    t = t.next;
                }else{
                    t.next = second;
                    second = second.next;
                    t = t.next;
                }
            }
            while(first != null){
                t.next = first;
                first = first.next;
                t = t.next;
            }
            while(second != null){
                t.next = second;
                second = second.next;
                t = t.next;
            }
            res.next = temp.next;
        }
        return res.next; 
    }
}

/**
class Solution {
    static {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try (FileWriter writer = new FileWriter("display_runtime.txt")) {
            writer.write("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }));
}
        public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null ){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();

        int n = lists.length;

        for(int i=0;i<n;i++){
            ListNode curr = lists[i];
            while(curr!=null){
                res.add(curr.val);
                curr = curr.next;
            }
        }
        Collections.sort(res);

        int size = res.size();
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        
        for(int val:res){
            start.next = new ListNode(val);
            start = start.next;

        }
        return dummy.next;
    }
}

*/
