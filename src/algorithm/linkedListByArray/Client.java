package algorithm.linkedListByArray;

public class Client {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add_to_head(1);
        linkedList.add_to_head(2);
        linkedList.add_to_head(3);
        linkedList.add_to_head(4);
        linkedList.add_to_head(5);
        linkedList.print();
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

        int newHead = linkedList.reverse();
        linkedList.print(newHead);
    }
}
