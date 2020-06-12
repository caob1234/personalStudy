package com.smart.test;

import java.util.ArrayList;

public class ChildNode {
    int data;
    ArrayList<ChildNode> childNodes;

    public ChildNode(int data) {
        this.data = data;
    }

    public ChildNode(int data, ArrayList<ChildNode> childNodes) {
        this.data = data;
        this.childNodes = childNodes;
    }
}
