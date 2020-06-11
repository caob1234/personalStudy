package com.smart.test;

import java.util.LinkedList;

public class CSNode {
    int data;
    CSNode firstChild;
    LinkedList<CSNode> nextSibling;

    public CSNode(int data) {
        this.data = data;
    }

    public CSNode(int data, CSNode firstChild) {
        this.data = data;
        this.firstChild = firstChild;
    }

    public CSNode(int data, CSNode firstChild, LinkedList<CSNode> nextSibling) {
        this.data = data;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }
}
