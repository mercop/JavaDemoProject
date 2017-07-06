package solution;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/5.
 * 有序链表的合并
 */
public class mergeLinkedList {

    @Test
    public void test(){
        ListNode list1 = new ListNode(10);
        list1.next = new ListNode(15);
        list1.next.next = new ListNode(20);

        ListNode list2 = new ListNode(8);
        list2.next = new ListNode(16);
        list2.next.next = new ListNode(18);
        list2.next.next.next = new ListNode(22);

        ListNode list3 = Merge(list1,list2);
        while(list3!=null){
            System.out.println(list3.val);
            list3 = list3.next;
        }

    }



    public ListNode Merge(ListNode list1,ListNode list2) {

        //判空逻辑
        if(list1 ==null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode headNode = new ListNode(0);
        ListNode preNode = headNode;
        while(list1!=null && list2!=null){
            if(list1.val >= list2.val){
                preNode.next = new ListNode(list2.val);
                list2 = list2.next;
            } else{
                preNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            preNode = preNode.next;
        }

        if(list1!=null)
            preNode.next = list1;
        if(list2!=null)
            preNode.next = list2;
        return headNode.next;
    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

