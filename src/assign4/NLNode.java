package assign4;

import java.util.Comparator;
import java.util.Iterator;

/**
 * The nodes used in a non-linear linked structure
 *
 * @param <T> the data type used by this node
 * @author Michael Quick
 * @version 1.0, 2023/04/04
 */
public class NLNode<T> {
    private NLNode<T> parent;
    private ListNodes<NLNode<T>> children;
    private T data;

    /**
     * Creates a blank node
     */
    public NLNode() {
        parent = null;
        data = null;
        children = new ListNodes<>();
    }

    /**
     * Creates a node with data and a parent node
     *
     * @param d the data stored in this node
     * @param p the parent of the node
     */
    public NLNode(T d, NLNode<T> p) {
        children = new ListNodes<>();
        data = d;
        parent = p;
    }

    public NLNode<T> getParent() {
        return parent;
    }

    public void setParent(NLNode<T> p) {
        parent = p;
    }

    public void addChild(NLNode<T> newChild) {
        // Set the child's parent to this node and add the child to the list of children
        newChild.setParent(this);
        children.add(newChild);
    }

    public Iterator<NLNode<T>> getChildren() {
        return children.getList();
    }

    public Iterator<NLNode<T>> getChildren(Comparator<NLNode<T>> sorter) {
        return children.sortedList(sorter);
    }

    public T getData() {
        return data;
    }

    public void setData(T d) {
        data = d;
    }
}
