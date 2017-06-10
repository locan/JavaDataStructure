package com.locan.btree;

/**
 * Created by luan on 2017/6/1.
 */
public class BinaryNode {
    private Object element;
    private BinaryNode left;
    private BinaryNode right;




    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public TreeIterator iterator(){
        return new MyTreeIterator(this);
    }


    /**
     * 比较两个二叉树是否相等，每个节点上的Element的equals为true
     * @param node
     * @return
     */

    public boolean equals(BinaryNode node){
        if((this==null&&node==null)||(this!=null&&node==null)){
            return true;
        }else if(this==null&&node!=null){
            return false;
        }else if(!this.getElement().equals(node.getElement()))
            return false;
        else
            return getLeft().equals(node.getLeft())&&getRight().equals(node.getRight());
    }

    public boolean isSubtree(BinaryNode root2) {
        if(this==null||root2==null)
            return false;
        if(equals(root2)){

            // 找到相同的结点，开始匹配下边的分支相不相同
            return true;
        }else{
            return getLeft().isSubtree(root2)||getRight().isSubtree(root2);
        }
    }

    public void mirror() {
        if(this==null)
            return;
        getLeft().mirror();
        getRight().mirror();
        BinaryNode temp = getLeft();
        setLeft(getRight());
        setRight(temp);
    }

}
