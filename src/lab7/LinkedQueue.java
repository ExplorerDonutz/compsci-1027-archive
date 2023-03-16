package lab7;

/**
 * LinkedQueue represents a linked implementation of a queue.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/12/08
 */

public class LinkedQueue<T> implements QueueADT<T> {
    private int count;
    private LinearNode<T> front, rear;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    /**
     * Adds the specified element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (front == null)
            front = newNode;
        else {
            rear.setNext(newNode);
        }
        rear = newNode;
        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a
     * reference to it. Throws an EmptyCollectionException if the
     * queue is empty.
     *
     * @return the element at the front of this queue
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T dequeue() throws EmptyCollectionException {
        if (front == null) throw new EmptyCollectionException("Empty Queue");
        T result = front.getElement();
        front = front.getNext();
        if (front == null) rear = null;
        count--;
        return result;
    }

    /**
     * Returns a reference to the element at the front of this queue.
     * The element is not removed from the queue.  Throws an
     * EmptyCollectionException if the queue is empty.
     *
     * @return a reference to the first element in
     * this queue
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T first() throws EmptyCollectionException {
        if (front == null) throw new EmptyCollectionException("Empty Queue");
        return front.getElement();
    }

    /**
     * Returns true if this queue is empty and false otherwise.
     *
     * @return true if this queue is empty and false if otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of elements currently in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    public int size() {
        return count;
    }

    public String toString() {
        String s = "Queue: ";
        LinearNode<T> curNode = front;

        for (int i = 0; i < count; i++) {
            s += curNode.getElement() + " ";
            curNode = front.getNext();
        }

        return s;
    }
}
