package assign3;

/**
 * Node for a doubly linked list
 * @param <T> The data type stored in this node
 * @author Michael Quick
 * @version 1.0, 2023/03/18
 */
public class DLinkedNode<T> {
    private T dataItem;
    private double priority;
    private DLinkedNode<T> next;
    private DLinkedNode<T> prev;

    /**
     * Creates a node with a data item and priority
     * @param data Data item being stored in this node
     * @param prio The priority of this node
     */
    public DLinkedNode(T data, double prio) {
        dataItem = data;
        priority = prio;
    }

    /**
     * Creates an empty node
     */
    public DLinkedNode() {
        dataItem = null;
        priority = 0;
    }

    // Getters and setters

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public T getDataItem() {
        return dataItem;
    }

    public void setDataItem(T dataItem) {
        this.dataItem = dataItem;
    }

    public DLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DLinkedNode<T> next) {
        this.next = next;
    }

    public DLinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DLinkedNode<T> prev) {
        this.prev = prev;
    }
}
