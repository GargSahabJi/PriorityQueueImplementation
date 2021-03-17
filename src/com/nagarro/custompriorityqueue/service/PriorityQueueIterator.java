/*
* Class name: PriorityQueueIterator
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 16/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Mar/2021
*
* Description: Iterator class for Priority Queue
*/
package com.nagarro.custompriorityqueue.service;

import java.util.Iterator;

import com.nagarro.custompriorityqueue.model.Node;

public class PriorityQueueIterator implements Iterator<Object> {
    private Node[] nodeList;
    private int nextElement = 0;
    private int length;

    public PriorityQueueIterator(Node[] nodeList, int length) {
        this.nodeList = nodeList;
        this.length = length;
    }

    /**
     * check hash table has next element or not
     */
    @Override
    public boolean hasNext() {
        if (nextElement > (length - 1)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        return nodeList[nextElement++].getValue();
    }

}
