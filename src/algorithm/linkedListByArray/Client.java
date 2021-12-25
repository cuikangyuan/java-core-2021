package algorithm.linkedListByArray;

public class Client {

    public static void main(String[] args) {

        // LinkedList linkedList = new LinkedList();
        // linkedList.add_to_head(1);
        // linkedList.add_to_head(2);
        // linkedList.add_to_head(3);
        // linkedList.add_to_head(4);
        // linkedList.add_to_head(5);
        // linkedList.print();
//
//        linkedList.add(1, 6);
//        linkedList.add(2, 7);
//        linkedList.add(3, 8);
//        linkedList.print();
//
//        linkedList.remove(1);
//        linkedList.remove(2);
//        linkedList.remove(3);
//        linkedList.print();

        // int newHead = linkedList.reverse();
        // linkedList.print(newHead);

        DeLinkedList deLinkedList = new DeLinkedList();
        // deLinkedList.add(0, 1);
        // deLinkedList.add(0, 2);
        // deLinkedList.add(0, 3);
        // deLinkedList.add(0, 4);
        // deLinkedList.add(0, 5);

        deLinkedList.add(0, 1);
        deLinkedList.add(2, 2);
        deLinkedList.add(3, 3);
        deLinkedList.add(4, 4);
        deLinkedList.add(5, 5);

        deLinkedList.print();

    }
}
