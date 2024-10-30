package edu.psu.ist;

public record NonEmpty(
        BSTree left,
        Integer data,
        BSTree right) implements BSTree {

    @Override public BSTree insert(Integer toAdd) {
        if (toAdd < this.data) {
            // insert into left subtree
           return new NonEmpty(left.insert(toAdd), data, right);
        }
        else if (toAdd > this.data) {
            return new NonEmpty(left, data, right.insert(toAdd));
        }
        else { // toAdd == this.data
            throw new IllegalArgumentException("dup key");
        }
    }

    @Override public String preOrder() {

        String result = data + "";
        // next: does the left subtree have any kids?
        if (left.size() != 0) {
            result += " " + left.preOrder();
        }
        if (right.size() != 0) {
            result += " " + right.preOrder();
        }
        return result;
    }

    @Override public int size() {
        int numNodesLeft = left.size(); // save number of nodes in left subtree
        int numNodesRight = right.size(); // save number of nodes in right subtree
        return 1 + numNodesLeft + numNodesRight;
    }
}
