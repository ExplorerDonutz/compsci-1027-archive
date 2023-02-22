/* Michael Quick
 *  Feb 21 2023
 *  Creates sets for every combination of a given set of elements
 */
package assign2;

public class PowerSet<T> {
    private Set<T>[] set;

    public PowerSet(T[] elements) {
        set = new Set[(int) Math.pow(2, elements.length)];

        // Create string array to hold the binary representations of each set
        String[] binaries = new String[(int) Math.pow(2, elements.length)];
        int num = 0;

        for (int i = 0; i < binaries.length; i++) {
            // Convert number to binary
            String binary = Integer.toBinaryString(num);

            // If binary length is not equal to the number of items in elements, it needs to be padded
            while (binary.length() < elements.length) {
                // Add zeroes to pad the binary
                binary = "0" + binary;
            }
            binaries[i] = binary;
            num++;
        }

        for (int i = 0; i < set.length; i++) {
            // Make a new set
            Set<T> currentSet = new Set<>();

            // Check for 1s in the current binary and add the elements to the current set
            for (int j = 0; j < binaries[i].length(); j++) {
                // If there is a one then add the element at index j
                if (binaries[i].split("")[j].equals("1")) {
                    currentSet.add(elements[j]);
                }
            }
            // Add the set to the array
            set[i] = currentSet;
        }
    }

    public int getLength() {
        return set.length;
    }

    public Set<T> getSet(int i) {
        return set[i];
    }
}
