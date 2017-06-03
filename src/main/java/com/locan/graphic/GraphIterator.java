package com.locan.graphic;

import java.util.Iterator;

/**
 * Created by luan on 2017/6/3.
 */
public interface GraphIterator extends Iterator{
    public int begin();

    public boolean hasNext();

    public Integer next();

    public boolean end();
}
