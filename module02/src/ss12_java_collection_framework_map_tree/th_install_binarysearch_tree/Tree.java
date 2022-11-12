package ss12_java_collection_framework_map_tree.th_install_binarysearch_tree;

public interface Tree<E> {
    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    public boolean insert(E e);
    /**
     * Inorder traversal from the root
     */
    public void inorder();
    /**
     * Get the number of nodes in the tree
     */
    public int getSize();
}
