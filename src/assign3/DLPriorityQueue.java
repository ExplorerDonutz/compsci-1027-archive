package assign3;

public class DLPriorityQueue<T> implements PriorityQueueADT<T>{
   private DLinkedNode<T> front;
   private DLinkedNode<T> rear;
   private int count;

   public DLPriorityQueue() {

   }

    @Override
    public void add(T data, double priority) {

    }

    @Override
    public T removeMin() throws EmptyPriorityQueueException {
        return null;
    }

    @Override
    public void updatePriority(T data, double newPriority) throws InvalidElementException {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public String toString() {
       return "";
    }

    public DLinkedNode<T> getRear() {
       return rear;
    }
}
