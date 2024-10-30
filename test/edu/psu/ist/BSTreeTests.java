package edu.psu.ist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class BSTreeTests {

    @Test public void testInsert01() {
        BSTree myTree = new Empty();
        Assertions.assertEquals(0, myTree.size());
    }

    @Test public void testInsert02() {
        BSTree myTree = new Empty();
        myTree = myTree.insert(10);
        myTree = myTree.insert(5);
        Assertions.assertEquals("10 5", myTree.preOrder());

        myTree = myTree.insert(20);

        Assertions.assertEquals("10 5 20", myTree.preOrder());
        Assertions.assertEquals(3, myTree.size());
    }

    @Test public void testInsertDupFail01() {
        var myTree = new Empty().insert(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> myTree.insert(10));
    }

    @Test public void testInsertDupFail02() {
        var myTree = new Empty().insert(10).insert(5);
        Assertions.assertEquals("10 5", myTree.preOrder());
        Assertions.assertThrows(IllegalArgumentException.class, () -> myTree.insert(10));
    }

    @Test public void testInsert03() {
        BSTree myTree = new Empty();
        myTree = myTree.insert(10);
        myTree = myTree.insert(5);
        Assertions.assertEquals("10 5", myTree.preOrder());

        myTree = myTree.insert(24);

        Assertions.assertEquals("10 5 24", myTree.preOrder());
        Assertions.assertEquals(3, myTree.size());

        myTree = myTree.insert(20);
        Assertions.assertEquals("10 5 24 20", myTree.preOrder());
        Assertions.assertEquals(4, myTree.size());
    }

    @Test public void testLopsidedTree() {
        var myTree = BSTree.empty()//
                .insert(10)//
                .insert(5)//
                .insert(2)//
                .insert(0);
        Assertions.assertEquals("10 5 2 0", myTree.preOrder());
    }

}
