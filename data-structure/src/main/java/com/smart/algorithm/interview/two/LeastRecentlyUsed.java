package com.smart.algorithm.interview.two;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * java程序员面试宝典-算法宝典——page76
 */
public class LeastRecentlyUsed {
    private int cacheSize;
    private ArrayDeque<Integer> queue=new ArrayDeque<>();
    private HashSet<Integer> hashSet=new HashSet<>();

    public LeastRecentlyUsed(int cacheSize) {
        this.cacheSize = cacheSize;
    }
    /*Determine whether the cache queue is full?*/
    private boolean isQueueFull(){
        return queue.size()==cacheSize;
    }
    private void enqueue(int pageNum){
        if (isQueueFull()){
            hashSet.remove(queue.getLast());
            queue.pollLast();
        }
        queue.addFirst(pageNum);
        hashSet.add(pageNum);
    }
    public void accessPage(int pageNum){
        if (!hashSet.contains(pageNum)){
            enqueue(pageNum);
        }else if (pageNum!=queue.getFirst()){
            queue.remove(pageNum);
            queue.addFirst(pageNum);
        }
    }
    public void printQueue(){
        while (!queue.isEmpty()){
            System.out.print(queue.pop()+" ");
        }
    }
    public static void main(String[] args){
        LeastRecentlyUsed lru=new LeastRecentlyUsed(3);
        lru.accessPage(1);
        lru.accessPage(2);
        lru.accessPage(5);
        lru.accessPage(1);
        lru.accessPage(6);
        lru.accessPage(7);
        lru.printQueue();
    }
}
