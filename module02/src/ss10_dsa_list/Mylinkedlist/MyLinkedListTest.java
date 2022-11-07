package ss10_dsa_list.Mylinkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>(Collections.singleton(10));
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.addLast(20);
        ll.add(4, 8);
    }
}
