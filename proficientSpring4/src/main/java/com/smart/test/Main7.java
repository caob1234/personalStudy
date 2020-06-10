package com.smart.test;

import java.util.Scanner;
class Node<E> {

    public E getE() {
        return e;
    }

    private E e;


    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    private Node<E> prev;

    public Node(E e, Node<E> prev) {
        this.e = e;
        this.prev = prev;
    }
}

class ListNode<E> {

    private int size;

    public int getLength() {
        return length;
    }

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
        if (e.equals(this.headNode.getE())) {
            return headNode;
        }
        Node<E> currentNode = null;
        Node<E> p = getLastNode();
        while (p.getPrev() != null) {
            if (e.equals(p.getE())) {
                currentNode = p;
                break;
            }
            p = p.getPrev();
        }
        return currentNode;
    }

    public void add(Node<E> p, E e) {
        Node<E> newNode = new Node<>(e, p);
        Node<E> p1 = getLastNode();
        Node<E> currentNode = null;
        while (p1.getPrev() != null) {// loop check previous node whether already had a current node equals p
            if (p.getE().equals(p1.getPrev().getE())) {
                currentNode = p1;
                break;
            }
            p1 = p1.getPrev();
        }
        if (currentNode != null) {
            newNode.setPrev(p);
            currentNode.setPrev(newNode);
        } else {
            lastNode = newNode;
        }
        length++;
    }

    public Node<E> getNext(E e) {
        Node p = lastNode;
        Node nextNode = null;
        if (e.equals(p.getE())) {
            return null;
        }
        while (p.getPrev() != null) {
            if (e.equals(p.getPrev().getE())) {
                nextNode = p;
                break;
            }
            p = p.getPrev();
        }
        return nextNode;
    }

    public void delete(E e) {
        Node node = get(e);
        Node previousNode = node.getPrev();
        Node nextNode = getNext(e);
        if (nextNode != null) {
            nextNode.setPrev(previousNode);
        } else {
            lastNode = previousNode;
        }
        length--;
    }

    public String getStrs() {
        Node node = lastNode;
        StringBuffer s = new StringBuffer();
        while (node.getPrev() != null) {
            s = s.append(node.getE() + " ");
            node = node.getPrev();
        }
        return s.append(headNode.getE()).reverse().toString();
    }
}

public class Main7 {
    public static Integer convertToInt(String s) {
        if (s == null || s.isEmpty()) {
            System.out.println("input a null");
            return null;
        } else if (s.toCharArray()[0] > 47 && s.toCharArray()[0] < 58) {
            return Integer.parseInt(s);
        } else {
            System.out.println("input a not resolve data");
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            Integer count=input.nextInt();
            Integer h=input.nextInt();
            ListNode<Integer> listNode = new ListNode<>(count, h);
            for (int i = 0; i < count; i++) {
                Integer pre = input.nextInt();;
                Integer e = input.nextInt();;
                if (listNode.get(pre) == null) {
                    listNode.add(listNode.getLastNode(), pre);
                }
                listNode.add(listNode.get(pre), e);
            }
            listNode.delete(input.nextInt());
            System.out.println(listNode.getStrs());
        }
        input.close();
    }
}
