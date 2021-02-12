package com.smart.data.structure.listStackQueue;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;
    private int theSize;
    private int modCount=0;

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }

    }

    public MyLinkedList() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize=0;
        modCount++;
    }
    public int size(){
        return theSize;
    }
    public boolean isEmpty(){
        return size()==0;
    }

    public void add(int idx,AnyType x){
        addBefore(getNode(idx,0,size()),x);
    }

    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;
        if (idx<lower||idx>upper)
            throw new IndexOutOfBoundsException();
        if (idx<size()/2){
            p=beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p=p.next;
            }
        }else {
            p=endMarker;
            for (int i = size(); i >idx ; i--) {
                p=p.prev;
            }
        }
        return p;
    }

    private void addBefore(Node<AnyType> p,AnyType x){
        Node<AnyType> newNode=new Node<AnyType>(x,p.prev,p);
        newNode.prev.next=newNode;
        p.prev=newNode;
        theSize++;
        modCount++;
    }
    private AnyType remove(Node<AnyType> p,AnyType x){
        p.next.prev=p.prev;
        p.prev.next=p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    public Iterator<AnyType> iterator() {
        return null;
    }
}
