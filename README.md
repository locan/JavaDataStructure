# JavaDataStructure

使用Java实现一些数据结构
> 主要参考的书籍《数据结构与算法分析》
### 二叉树搜索树
```java
public interface BST{
    /*置空二叉树*/
    public void makeEmpty();
    /*判断二叉树是否为空*/
    public boolean isEmpty();
    /*判断是否包含某个元素*/
    public boolean contains(AnyType x);
    /*最小值*/
    public AnyType findMin();
    /*最大值*/
    public AnyType findMax();
    /*将元素插入二叉树*/
    public void insert(AnyType x);
    /*将元素从二叉树中移除*/
    public void remove(AnyType x);
}

```

### 图

目前实现了两种，邻接矩阵（DenseGraph）和邻接表（SparseGraph）

使用了接口编程

```java
public interface Graph {
    public Integer V();
    public Integer E();
    public void addEdge(int v,int w);
    boolean hasEdge(int v,int w);
    public GraphIterator iterator(int v);
}
```
实现是了图的迭代器,继承了java.util 中的Iterator

```java
public interface GraphIterator extends Iterator{
    public int begin();
    public boolean hasNext();
    public Integer next();
    public boolean end();
}

```

Component.java 中实现了图的深度遍历dfs
 
 
* 链表
* 队列
* MAP

