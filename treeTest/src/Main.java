import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        binaryTreeTest();
        heapTest();
        priorityQueueTest();
    }

    public static void binaryTreeTest() {
        System.out.println("===== BINARY TREE =====");
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);
        tree.insert(17);
        System.out.println("=====");
        tree.traverseInOrder();
        System.out.println("=====");
        System.out.println("Get 27: " + tree.get(27));
        System.out.println("Get 15: " + tree.get(15));
        System.out.println("Get 8888: " + tree.get(8888));
        System.out.println("Min: " + tree.min());
        System.out.println("Max: " + tree.max());

        System.out.println("=====");
        System.out.println("Delete 15");
        tree.delete(15);
        tree.traverseInOrder();

        System.out.println("=====");
        System.out.println("Delete 27");
        tree.delete(27);
        tree.traverseInOrder();

        System.out.println("=====");
        System.out.println("Delete 25");
        tree.delete(25);
        tree.traverseInOrder();

        System.out.println("=====");
        System.out.println("Delete 888");
        tree.delete(888);
        tree.traverseInOrder();
        System.out.println("=====");
    }

    public static void heapTest() {
        System.out.println("===== HEAP =====");
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);
        heap.printHeap();

        System.out.println("=====");
        System.out.println("Peek: " + heap.peek());

        System.out.println("=====");
        System.out.println("Delete index 1 (75)");
        heap.delete(1);
        heap.printHeap();

        System.out.println("=====");
        System.out.println("Delete index 5 (40)");
        heap.delete(5);
        heap.printHeap();

        System.out.println("=====");
        System.out.println("Delete index 0 (root - 80)");
        heap.delete(0);
        heap.printHeap();
        System.out.println("Peek: " + heap.peek());
        System.out.println("=====");

        heap.insert(75);
        heap.insert(40);
        heap.insert(80);
        System.out.println("Re-insert deleted heap values");
        heap.printHeap();
        System.out.println("=====");

        heap.sort();
        System.out.println("Sorted (no longer a heap)");
        heap.printHeap();
        System.out.println("=====");
    }

    public static void priorityQueueTest() {
        System.out.println("===== PRIORITY QUEUE =====");
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        System.out.println("Peek: " + pq.peek());
        System.out.println("Remove: " + pq.remove());
        System.out.println("Peek: " + pq.peek());
        System.out.println("Poll: " + pq.poll());
        System.out.println("Peek: " + pq.peek());
        System.out.println("Remove: " + pq.remove(54)); // True (false if it cannot find it)
        System.out.println("Peek: " + pq.peek());

        pq.add(-1);
        System.out.println("Peek after add -1: " + pq.peek());

        System.out.println("Contents: ");
        Object[] ints = pq.toArray();
        for (Object num: ints) {
            System.out.print(num);
            System.out.print(", ");
        }
        System.out.println("");
    }
}