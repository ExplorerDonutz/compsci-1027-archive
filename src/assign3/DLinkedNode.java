package assign3;

public class DLinkedNode <T>{
    private T dataItem;
    private double priority;
    private DLinkedNode<T> next;
    private DLinkedNode<T> prev;

    public DLinkedNode(T data, double prio) {
        dataItem = data;
        priority = prio;
    }

    public DLinkedNode() {
        dataItem = null;
        priority = 0;
    }

    public double getPriority() {
        return priority;
    }

    public T getDataItem() {
        return dataItem;
    }

    public DLinkedNode<T> getNext() {
        return next;
    }

    public DLinkedNode<T> getPrev() {
        return prev;
    }

    public void setDataItem(T dataItem) {
        this.dataItem = dataItem;
    }

    public void setNext(DLinkedNode<T> next) {
        this.next = next;
    }

    public void setPrev(DLinkedNode<T> prev) {
        this.prev = prev;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }
}
