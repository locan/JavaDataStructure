package com.locan.btree;

import java.util.Comparator;

/**
 * Created by locan on 17/6/1.
 */
public class BinarySearchTree2<AnyType> {

    private BinaryNode<AnyType> root;
    private Comparator<? super AnyType> cmp;

    public BinarySearchTree2(){
        this(null);
    }

    public BinarySearchTree2(Comparator<? super AnyType> c){
        this.cmp = c;
        this.root = null;
    }

    private int myCompare(AnyType lhs,AnyType rhs){
        if(cmp!=null)
            return cmp.compare(lhs,rhs);
        else
            return ((Comparable)lhs).compareTo(rhs);
    }

    private boolean contains(AnyType x,BinaryNode<AnyType> t){
        if(x ==null)
            return false;
        int compareResult = myCompare(x,t.element);
        if(compareResult<0){
            return contains(x,t.left);
        }else if(compareResult>0){
            return contains(x,t.right);
        }else{
            return true;
        }
    }


    private static class BinaryNode<AnyType>{
        public BinaryNode(AnyType theElement) {
            this(theElement,null,null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }
}
