package edu.psu.ist;

public interface BSTree {

    // "static factory"
    static BSTree empty() {
        return new Empty();
    }

    /** Inserts {@code item} into the binary search tree. */
    BSTree insert(Integer toAdd);

    String preOrder();

    //String inOrder();
    //String postOrder();

    /** returns the number of nodes in {@code this} tree */
    int size();
}
