package com.smart.test;


class ListNode<E> {
    public static class Node<E> {

        public E getE() {
            return e;
        }

        private E e;


        public Node<E> getPrev() {
            return prev;
        }

        private Node<E> prev;

        public Node(E e, Node<E> prev) {
            this.e = e;
            this.prev = prev;
        }
    }

    private int size;
    private int length = 1;
    private Node<E> headNode;

    public Node<E> getLastNode() {
        return lastNode;
    }

    private Node<E> lastNode;

    public ListNode(int size, E head) {
        this.size = size;
        this.headNode = new Node<E>(head, null);
        this.lastNode = this.headNode;
    }

    public Node<E> get(E e) {
        if (e.equals(this.headNode.e)) {
            return headNode;
        }
        Node<E> currentNode = null;
        Node<E> p = getLastNode();
        while (p.prev != null) {
            if (e.equals(p.e)) {
                currentNode = p;
                break;
            }
            p = p.prev;
        }
        return currentNode;
    }

    public void add(Node<E> p, E e) {
        Node<E> newNode = new Node<>(e, p);
        Node<E> p1 = getLastNode();
        Node<E> currentNode = null;
        while (p1.prev != null) {// loop check previous node whether already had a current node equals p
            if (p.e.equals(p1.prev.e)) {
                currentNode = p1;
                break;
            }
            p1 = p1.prev;
        }
        if (currentNode!=null){
            newNode.prev=p;
            currentNode.prev=newNode;
//            lastNode=currentNode;
        }else {
            lastNode = newNode;
        }
        length++;
    }
    public String getStrs(){
        Node node=lastNode;
        StringBuffer s=new StringBuffer();
        while (node.prev!=null){
            s=s.append(node.e+" ");
            node=node.prev;
        }
        return s.append(headNode.e).reverse().toString();
    }
}

public class Main7 {
    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>(5, 2);
        if (listNode.get(2) != null) {
            listNode.add(listNode.get(2), 1);
            System.out.println(listNode.getStrs());

        }
        if (listNode.get(2) != null) {
            listNode.add(listNode.get(2), 3);
            System.out.println(listNode.getStrs());

        }
        listNode.add(listNode.get(1), 5);
        System.out.println(listNode.getStrs());
        listNode.add(listNode.get(5), 4);
        System.out.println(listNode.getStrs());
        listNode.add(listNode.get(2), 7);
        System.out.println(listNode.getStrs());
    }
}
