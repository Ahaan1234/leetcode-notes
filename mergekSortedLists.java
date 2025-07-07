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
        if (lists.length == 0) return null;
        ListNode[] heap = new ListNode[lists.length + 1];
        for (int i = 0; i < lists.length; i++) {
            heap[i + 1] = lists [i];
        }
        buildHeap(heap);
        ListNode ret = listHeap(heap);
        return ret;
    }

    private ListNode listHeap (ListNode[] heap) {
        if (heap == null) return null; // edge case
        ListNode merged = new ListNode(0);
        ListNode head = merged;
        int i = 1;
        while (heap[1] != null) {
            merged.next = heap[1];
            merged = merged.next;
            heap[1] = heap[1].next;

            downHeap(heap, 1);
        }
        return head.next;
    }

    private void buildHeap(ListNode[] heap) {
        for (int i = (heap.length - 1) / 2; i >= 1; i--) {
            downHeap(heap, i);
        }
    }

    private void downHeap(ListNode[] heap, int i) {
        int swapIndex;
        ListNode temp;

        while (2 * i < heap.length) {
            swapIndex = 2 * i;
            if (swapIndex + 1 < heap.length && heap[swapIndex + 1] != null && heap[swapIndex] != null) {
                if (heap[swapIndex].val > heap[swapIndex + 1].val){
                    swapIndex++;
                }
            } else if (swapIndex + 1 < heap.length && heap[swapIndex] == null && heap[swapIndex + 1] != null){
                swapIndex++;
            } 
            
            if (heap[swapIndex] == null) {
                break;
            }

            if (heap[i] == null || heap[i].val > heap[swapIndex].val) {
                temp = heap[swapIndex];
                heap[swapIndex] = heap[i];
                heap[i] = temp;

                i = swapIndex;
            } else break;
        }
    }
}