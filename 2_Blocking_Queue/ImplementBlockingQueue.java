
/*
A blocking queue allows threads to wait for the queue to become non-empty
when retrieving an element or for space to become available when adding an element.
*/

class ImplementBlockingQueue<T> {

    private final LinkedList<T> queue = new LinkedList<>();
    private final int limit;

    public ImplementBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == limit) {
            wait();  // Wait until space is available
        }
        queue.add(item);
        notifyAll();  // Notify other threads that an item has been added
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();  // Wait until an item is available
        }
        T item = queue.removeFirst();
        notifyAll();  // Notify other threads that an item has been removed
        return item;
    }

    public static void main(String... args) {

        ImplementBlockingQueue<Integer> queue = new ImplementBlockingQueue<>(5);

    }
}