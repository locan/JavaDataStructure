package com.locan.btree;

/**
 * Created by locan on 17/6/10.
 */
public class MyTreeIterator implements TreeIterator<BinaryNode>{

    private BinaryNode root;


    public MyTreeIterator(BinaryNode root) {
        this.root = root;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public BinaryNode next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
