/* Michael Quick
 *  Feb 21 2023
 *  Creates a simple collection using a singly-linked list
 */
package assign2;

public class Set<T> {
    private LinearNode<T> setStart;

    public Set() {
        setStart = null;
    }

    public void add(T element) {
        // Create temporary new node to store new element
        LinearNode<T> currentNode = new LinearNode<>(element);

        // Make the new node previous to the old node
        currentNode.setNext(setStart);

        // Set old node to new node
        setStart = currentNode;
    }

    public int getLength() {
        LinearNode<T> currentNode = setStart;

        int length = 0;
        if (currentNode != null) {
            // Add 1 for the first element in the set
            length++;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                // Add 1 to length for each node
                length++;
            }
        }
        return length;
    }

    public T getElement(int i) {
        LinearNode<T> currentNode = setStart;

        // Find node at i
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.getNext();
        }

        // Return element at i
        return currentNode.getElement();
    }

    public boolean contains(T element) {

        // Loop through every element in the set
        for (int i = 0; i < getLength(); i++) {

            // Compare the string values of the elements
            if (getElement(i).toString().equals(element.toString())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String str = "";

        // Loop through the entire set
        for (int i = 0; i < getLength(); i++) {
            // Add each element in the set with a space
            str += this.getElement(i) + " ";
        }

        // Return the string with the ending space removed
        return str.strip();
    }
}
