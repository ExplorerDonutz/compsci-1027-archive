package assign4;

import java.util.ArrayList;
import java.util.Iterator;

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
        if (!r.getData().isFile()) {
            // Recursive case: r was a directory
            Iterator<FileObject> iterator = r.getData().directoryFiles();

            // Loop through all the files in the directory
            while (iterator.hasNext()) {
                FileObject fileObject = iterator.next();
                NLNode<FileObject> newNode = new NLNode<>();
                newNode.setData(fileObject);

                // Connect the new node to its parent
                newNode.setParent(root);
                root.addChild(newNode);

                // Recursively continue down the file structure until a file is found instead of a directory
                createFolderStructure(newNode);
            }
        }
    }

    public NLNode<FileObject> getRoot() {
        return root;
    }

    public Iterator<String> filesOfType(String type) {
        ArrayList<String> filesOfType = new ArrayList<>();

        FileObject fileObject = root.getData();

        // Best case: root is a file of specified type
        if (fileObject.getLongName().endsWith(type)) {
            filesOfType.add(root.getData().getLongName());
            return filesOfType.iterator();
        }

        // Recursive case: search through the tree finding all files of specified type
        Iterator<NLNode<FileObject>> iterator = root.getChildren();
        while (iterator.hasNext()) {
            NLNode<FileObject> child = iterator.next();
            inorder(child, filesOfType, type);
        }

        return filesOfType.iterator();
    }

    private void inorder(NLNode<FileObject> node, ArrayList<String> filesOfType, String type) {
        if (node.getData().isFile() && node.getData().getLongName().endsWith(type)) {
            filesOfType.add(node.getData().getLongName());
        } else {

        }
    }

    public String findFile(String name) {

        return null;
    }


}
