package assign3;

/**
 * A priority queue that holds double values in order of their priority
 *
 * @param <T> The data type stored in the nodes
 * @author Michael Quick
 * @version 1.0, 2023/03/21
 */
public class DLPriorityQueue<T> implements PriorityQueueADT<T> {
    private DLinkedNode<T> front;
    private DLinkedNode<T> rear;
    private int count;

    /**
     * Creates an empty priority queue
     */
    public DLPriorityQueue() {
        count = 0;
    }

    /**
     * Adds a data item to the priority queue based on its priority
     *
     * @param data     item to be added onto the priority queue
     * @param priority the priority of the data being added
     */
    @Override
    public void add(T data, double priority) {
        DLinkedNode<T> newNode = new DLinkedNode<T>(data, priority);

        // This is the only node
        if (isEmpty()) {
            front = rear = newNode;
        } else if (newNode.getPriority() <= front.getPriority()) {
            // The data's priority is lower than front, so make it the new front
            newNode.setNext(front);
            front.setPrev(newNode);
            front = newNode;
        } else {
            // The data's priority is greater than front's priority
            DLinkedNode<T> curr = front;

            // Find where data belongs based on priority
            while (curr.getNext() != null && newNode.getPriority() > curr.getNext().getPriority()) {
                curr = curr.getNext();
            }

            // Data should be the new rear as it has the greatest priority
            if (curr.getNext() == null) {
                curr.setNext(newNode);
                newNode.setPrev(curr);
                rear = newNode;
            } else {
                // Data is somewhere in the middle
                newNode.setNext(curr.getNext());
                newNode.setPrev(curr);
                curr.getNext().setPrev(newNode);
                curr.setNext(newNode);
            }
        }

        // Update count
        count++;
    }

    /**
     * @return The data item removed from the queue
     * @throws EmptyPriorityQueueException if the priority queue is empty
     */
    @Override
    public T removeMin() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            // There is nothing to remove because the queue is empty
            throw new EmptyPriorityQueueException("Empty queue");
        } else {
            // Get the data item from the front of the queue
            T dataItem = front.getDataItem();

            // Remove the item from the queue
            front = front.getNext();
            if (front == null) {
                // Queue is now empty
                rear = null;
            } else {
                front.setPrev(null);
            }
            count--;
            return dataItem;
        }
    }

    /**
     * Reorders the queue based on the given data item and its new priority
     *
     * @param data        item whose priority is to be changed
     * @param newPriority value of the new priority for this data item
     * @throws InvalidElementException if the data item does not exist within the queue
     */
    @Override
    public void updatePriority(T data, double newPriority) throws InvalidElementException {
        // Find the node that holds the data item
        DLinkedNode<T> curr = front;

        while (curr != null && !curr.getDataItem().equals(data)) {
            curr = curr.getNext();
        }

        if (curr == null || !curr.getDataItem().equals(data)) {
            throw new InvalidElementException("Data item does not exist in priority queue: " + data.toString());
        } else {
            // Update the priority of the current node
            curr.setPriority(newPriority);

            // Remove the current node and re-add it to maintain order
            DLinkedNode<T> prev = curr.getPrev();
            DLinkedNode<T> next = curr.getNext();
            if (prev != null) {
                prev.setNext(next);
            } else {
                front = next;
            }
            if (next != null) {
                next.setPrev(prev);
            } else {
                rear = prev;
            }
            add(data, newPriority);
        }
    }

    @Override
    public boolean isEmpty() {
        // Returns true if count is 0
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    /**
     * Concatenates the data items in the priority queue together
     *
     * @return a string representation of the priority queue
     */
    public String toString() {
        String s = "";
        DLinkedNode<T> curr = front;

        // Concatenate each data item's toString return value
        for (int i = 0; i < count; i++) {
            s = s.concat(curr.getDataItem().toString());
            curr = curr.getNext();
        }
        return s;
    }

    public DLinkedNode<T> getRear() {
        return rear;
    }
}
