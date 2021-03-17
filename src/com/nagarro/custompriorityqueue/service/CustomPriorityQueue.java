/*
* Class name: CustomPriorityQueue
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
* Description: Priority Queue class for creating and do operations
*/
package com.nagarro.custompriorityqueue.service;

import java.util.Iterator;

import com.nagarro.custompriorityqueue.exception.InvalidStateException;
import com.nagarro.custompriorityqueue.model.Node;

public class CustomPriorityQueue implements Iterable<Object> {
    private static final String QUEUE_IS_EMPTY = "Queue is Empty!";
    private Node[] nodeList;
    private int length;
    private boolean reversed;
    private int capacity;
    private float growthRate = 0.5f;

    /**
     * @param capacity
     */
    public CustomPriorityQueue(int capacity) {
        this.capacity = capacity;
        nodeList = new Node[this.capacity];
        length = 0;
        reversed = false;
    }

    /**
     * check priority queue is empty or not
     * 
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Enqueue/insert a value in the priority queue
     * 
     * @param value
     */
    public void enqueue(int value) {
        Node node = new Node();
        node.setValue(value);
        if (isEmpty()) {
            nodeList[0] = node;
            length++;
            return;
        }
        if (length + 1 == capacity) {
            System.out.println("New Created");
            int newCapacity = capacity + (new Float(capacity * growthRate)).intValue();
            Node[] newNodeList = new Node[newCapacity];
            capacity = newCapacity;
            for (int i = 0; i < nodeList.length; i++) {
                newNodeList[i] = nodeList[i];
            }
            nodeList = newNodeList;
        }
        int position = 0;
        for (position = length - 1; position >= 0; position--) {
            if ((!reversed) && (value > nodeList[position].getValue())) {
                nodeList[position + 1] = nodeList[position];
            } else if (reversed && (value < nodeList[position].getValue())) {
                nodeList[position + 1] = nodeList[position];
            } else {
                break;
            }
        }
        nodeList[position + 1] = node;
        length++;
    }

    /**
     * dequeue the value that has high priority from priority queue
     * 
     * @return
     */
    public int dequeue() {
        if (isEmpty()) {
            new InvalidStateException(QUEUE_IS_EMPTY);
        }
        return nodeList[--length].getValue();

    }

    /**
     * return the highest priority value
     * 
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            new InvalidStateException(QUEUE_IS_EMPTY);
        }

        return nodeList[length - 1].getValue();
    }

    /**
     * Search value in the priority queue
     * 
     * @param searchValue
     * @return
     */
    public boolean contains(int searchValue) {
        for (int i = 0; i < length - 1; i++) {
            if (searchValue == nodeList[i].getValue())
                return true;
        }
        return false;
    }

    /**
     * give the size of the queue
     * 
     * @return
     */
    public int size() {
        return length;
    }

    /**
     * reverse the priority queue
     */
    public void reverse() {
        int left = 0;
        int right = length - 1;
        while (left < right) {
            Node tempValue = nodeList[right];
            nodeList[right] = nodeList[left];
            nodeList[left] = tempValue;
            left++;
            right--;
        }
        reversed = !reversed;
    }

    /**
     * Iterator for priority queue
     * 
     * @param queue
     */
    public void customIterator(CustomPriorityQueue queue) {
        Iterator<Object> itr = queue.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    /**
     * traverse the priority queue
     */
    public void traverse() {
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(nodeList[i].getValue() + "  ");
        }
        System.out.println();
    }

    @Override
    public Iterator<Object> iterator() {
        return new PriorityQueueIterator(nodeList, length);
    }
}
