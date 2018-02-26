package heap;

/** A driver class for MinHeap */
public class MinHeapDriver {

        public static void main(String[] args) {
            MinHeap heap = new MinHeap(10);
            heap.insert(5);
            heap.insert(2);

            heap.insert(15);
            heap.insert(1);
            heap.insert(13);
            heap.print();

        }

}
