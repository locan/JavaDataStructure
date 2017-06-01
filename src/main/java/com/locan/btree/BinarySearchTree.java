package com.locan.btree;

import java.util.Comparator;

/**
 * Created by locan on 17/6/1.
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType>{
        public BinaryNode(AnyType theElement) {
            this(theElement,null,null);
        }
        BinaryNode(AnyType theElement,BinaryNode<AnyType> lt,BinaryNode<AnyType> rt){
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }


    private BinaryNode<AnyType> root;

    private Comparator<? super AnyType> cmp;



    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(Comparator<? super AnyType> c){
        root = null;
        cmp = c;
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }

    public AnyType findMin(){
        if(isEmpty())
            return null;
        return findMin(root).element;
    }

    public AnyType findMax(){
        if(isEmpty())
            return null;
        return findMax(root).element;
    }

    public void insert(AnyType x){
        root = insert(x,root);
    }

    public void remove(AnyType x){
        root = remove(x,root);
    }

    public void printTree(){

    }
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> root) {
        return null;
    }

    /**
     * AnyType 是继承 Comparable
     * @param x
     * @param node
     * @return
     */
    private boolean contains(AnyType x,BinaryNode<AnyType> node){
        if(node==null){
            return false;
        }
        int compareResult = x.compareTo(node.element);
        if(compareResult<0){
            return contains(x,node.left);
        }else if(compareResult>0){
            return contains(x,node.right);
        }else {
            return true;
        }
    }

    private int myCompare(AnyType lhs,AnyType rhs){
        if(cmp!=null){
            return cmp.compare(lhs,rhs);
        }else{
            return ((Comparable)lhs).compareTo(rhs);
        }
    }

    /**
     * 这种方式是通过使用一个函数对象而不是要求这些项是Comparable的。
     * @param x
     * @param t
     * @return
     */
    private boolean contains2(AnyType x,BinaryNode<AnyType> t){
        if(t == null ){
            return false;
        }
        int compareResult = myCompare(x,t.element);

        if(compareResult<0)
            return contains2(x,t.left);
        else if(compareResult>0)
            return contains2(x,t.right);
        else return true;
    }

    /**
     * 使用递归的方法查找最小的node
     * @param node
     * @return
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node){
        if(node == null)
            return null;
        else if(node.left==null)
            return node;
        return findMin(node.left);
    }

    /**
     * 通过while循环的方式查找最大的node
     * @param node
     * @return
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> node){
        if(node!=null){
            while(node.right!=null){
                node = node.right;
            }
        }
        return node;
    }
    public BinaryNode<AnyType> insert(AnyType x,BinaryNode<AnyType> t){
        if(t == null)
            return new BinaryNode<>(x,null,null);
        int compareResult = x.compareTo(t.element);
        if(compareResult < 0){
            t.left = insert(x,t.left);
        }
        else if(compareResult > 0){
            t.right = insert(x,t.right);
        }
        else{
            // 这个分支 是找到了相同的结点

        }
        return t;
    }




}
