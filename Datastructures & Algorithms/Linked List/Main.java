public class Main {
    public static void main(String[] args) {
        // Basic build and traverse
        SingleLinkedList list = new SingleLinkedList();
        list.insertLinkedList(1,0);
        list.insertLinkedList(2,1);
        list.insertLinkedList(3,2);
        list.insertLinkedList(4,3);
        System.out.println("Initial list:");
        list.traverseLinkedList();

        // Run search tests
        testSearch();

        // Run delete tests
        testDelete();
    }

    private static void testSearch() {
        System.out.println("\n== Search tests ==");
        SingleLinkedList list = new SingleLinkedList();
        list.insertLinkedList(10, 0);
        list.insertLinkedList(20, 1);
        list.insertLinkedList(30, 2);
        list.insertLinkedList(40, 3);
        list.traverseLinkedList();

        System.out.println("Search 30: " + list.search(30)); // true
        System.out.println("Search 99: " + list.search(99)); // false
    }

    private static void testDelete() {
        System.out.println("\n== Delete tests ==");
        SingleLinkedList list = new SingleLinkedList();
        list.insertLinkedList(5, 0);
        list.insertLinkedList(6, 1);
        list.insertLinkedList(7, 2);
        list.insertLinkedList(8, 3);
        list.insertLinkedList(9, 4);
        System.out.println("Original:");
        list.traverseLinkedList();

        // Delete head
        list.deleteNode(0);
        System.out.println("After delete head (0):");
        list.traverseLinkedList();

        // Delete middle (current size is 4, delete index 1)
        list.deleteNode(1);
        System.out.println("After delete middle (1):");
        list.traverseLinkedList();

        // Delete tail via out-of-range index
        list.deleteNode(100);
        System.out.println("After delete tail (>= size-1):");
        list.traverseLinkedList();

        // Delete remaining nodes until empty
        while (list.size > 0) {
            list.deleteNode(list.size - 1);
        }
        System.out.println("After deleting all nodes:");
        list.traverseLinkedList();
    }
}

