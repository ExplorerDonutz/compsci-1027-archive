package assign4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Creates an n-ary tree of files and directories
 *
 * @author Michael Quick
 * @version 1.0, 2023/04/04
 */
public class FileStructure {
    private NLNode<FileObject> root;

    public FileStructure(String fileObjectName) throws FileObjectException {
        FileObject fileObject = new FileObject(fileObjectName);
        root = new NLNode<>();
        root.setData(fileObject);

        // Create the linked tree using a recursive method if necessary
        createFolderStructure(root);
    }

    private void createFolderStructure(NLNode<FileObject> r) {
        // Best case: r is a file, so there is nothing else to traverse
        if (r.getData().isFile())
            return;

        // Recursive case: r was a directory
        Iterator<FileObject> iterator = r.getData().directoryFiles();

        // Loop through all the files in the directory
        while (iterator.hasNext()) {
            FileObject fileObject = iterator.next();
            NLNode<FileObject> newNode = new NLNode<>();
            newNode.setData(fileObject);

            // Connect the new node to its parent
            newNode.setParent(r);
            r.addChild(newNode);

            // Recursively continue down the file structure until a file is found instead of a directory
            createFolderStructure(newNode);
        }
    }

    public NLNode<FileObject> getRoot() {
        return root;
    }

    /**
     * Searches for a file type within the file structure.
     * Best case: The root was the only file in the structure
     * Recursive case: Using inorder, search the tree for any files of specified type
     *
     * @param type the file type to search for
     * @return an iterator of string file names
     */
    public Iterator<String> filesOfType(String type) {
        ArrayList<String> filesOfType = new ArrayList<>();

        inorder(root, filesOfType, type);

        return filesOfType.iterator();
    }

    // Inorder for file type search
    private void inorder(NLNode<FileObject> node, ArrayList<String> filesOfType, String type) {
        // If the node is a file of the specified type, add it to the arraylist
        if (node.getData().isFile() && node.getData().getLongName().endsWith(type)) {
            filesOfType.add(node.getData().getLongName());
        } else if (node.getData().isDirectory()) {
            // Recursively search through the rest of the children in the tree
            Iterator<NLNode<FileObject>> iterator = node.getChildren();
            while (iterator.hasNext()) {
                NLNode<FileObject> child = iterator.next();
                inorder(child, filesOfType, type);
            }
        }
    }

    // Inorder for file search
    private String inorder(NLNode<FileObject> node, String file) {
        // If the node is a file of the specified type, add it to the arraylist
        if (node.getData().isFile() && node.getData().getName().equals(file)) {
            return node.getData().getLongName();
        } else if (node.getData().isDirectory()) {
            // Recursively search through the rest of the children in the tree
            Iterator<NLNode<FileObject>> iterator = node.getChildren();
            while (iterator.hasNext()) {
                NLNode<FileObject> child = iterator.next();
                String result = inorder(child, file);

                // Check if the result of the child are not blank (file found)
                if (!result.equals(""))
                    return result;
            }
        }

        // All files in the tree have been checked, but were not the specified file
        return "";
    }


    /**
     * Find a specified file in the file structure
     *
     * @param name the name of the file that is being looked for
     * @return the absolute path of the file
     */
    public String findFile(String name) {
        // Use inorder algorithm to find the file
        return inorder(root, name);
    }


}
