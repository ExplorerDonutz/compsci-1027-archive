package assign3;

/**
 * A priority queue that holds double values in order of their priority
 *
 * @param <T> The data type stored in the nodes
 * @author Michael Quick
 * @version 1.0, 2023/03/18
 */
public class DLPriorityQueue<T> implements PriorityQueueADT<T> {
    private DLinkedNode<T> front;
    private DLinkedNode<T> rear;
    private int count;

    /**
     * Creates an empty priority queue
     */
    public DLPriorityQueue() {

    }

    /**
     * Adds a data item to the priority queue based on its priority
     *
     * @param data     item to be added onto the priority queue
     * @param priority the priority of the data being added
     */
    @Override
    public void add(T data, double priority) {
        DLinkedNode<T> newNode = new DLinkedNode<>(data, priority);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else if (priority <= front.getPriority()) {
            // The new node has a lower priority than front, so it should go in the front of the queue
            newNode.setNext(front);
            front.setPrev(newNode);
            front = newNode;
        } else if (priority > rear.getPriority()) {
            // The new node has a higher priority than rear, so it should go in the rear
            rear.setNext(newNode);
            newNode.setPrev(rear.getNext());
            rear = newNode;
        } else {
            // The priority lies somewhere within the middle of the queue
            DLinkedNode<T> start = front.getNext();
            while (start.getPriority() > priority) {
                start = start.getNext();
            }

            start.getPrev().setNext(newNode);
            newNode.setNext(start.getPrev());
            newNode.setPrev(start.getPrev().getNext());
            start.setPrev(newNode.getNext());
        }
    }

    /**
     * @return The data item removed from the queue
     * @throws EmptyPriorityQueueException if the priority queue is empty
     */
    @Override
    public T removeMin() throws EmptyPriorityQueueException {
        T minData = front.getDataItem();

        // Replace front with the next item in queue
        front = front.getNext();

        // If front is now null, then the queue is now empty
        if (front == null)
            rear = null;

        return minData;
    }

    @Override
    public void updatePriority(T data, double newPriority) throws InvalidElementException {

    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public int size() {
        if (front != null) {
            // Loop through the queue until the last item is found
            int size = 1;
            DLinkedNode<T> start = front.getNext();
            while (start != null) {
                size++;
                start = start.getNext();
            }
            return size;
        }
        // Queue is empty
        return 0;
    }

    public String toString() {
        return "";
    }

    public DLinkedNode<T> getRear() {
        return rear;
    }
}
