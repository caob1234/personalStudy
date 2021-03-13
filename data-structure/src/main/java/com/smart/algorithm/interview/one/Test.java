package com.smart.algorithm.interview.one;

public class Test {
    /*In-place reverse order*/
    public static void Reverse(LNode head){
        if (head==null||head.next==null){
            return;
        }
        LNode pre=null;
        LNode cur=null;
        LNode next=null;
        cur=head.next;
        next=cur.next;
        cur.next=null;
        pre=cur;
        cur=next;
        while (cur.next!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=cur.next;
            cur=next;
        }
        cur.next=pre;
        head.next=cur;
    }
    /*Recursion*/
    private static LNode recursiveReverse(LNode head){
        if (head==null||head.next==null){
            return head;
        }else {
            LNode newhead=recursiveReverse(head.next);
            head.next.next=head;
            head.next=null;
            return newhead;
        }
    }
    public static void Reverse1(LNode head){
        if (head==null){
            return;
        }
        LNode firstNode=head.next;
        LNode newhead=recursiveReverse(firstNode);
        head.next=newhead;
    }
    public static void Reverse2(LNode head){
        if (head==null||head.next==null){
            return;
        }
        LNode cur=null;
        LNode next=null;
        cur=head.next.next;
        head.next.next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=head.next;
            head.next=cur;
            cur=next;
        }
    }
    public static void main(String[] args){
        LNode head=new LNode();
        head.next=null;
        LNode tmp=null;
        LNode cur=head;
        for (int i=0; i <8 ; i++) {
            tmp=new LNode();
            tmp.data=i;
            tmp.next=null;
            cur.next=tmp;
            cur=tmp;
        }
        System.out.print("before reverse: ");
        for (cur=head.next; cur !=null ; cur=cur.next) {
            System.out.print(cur.data+" ");
        }
        System.out.print("\nAfter reverse: ");
        Reverse(head);
        for (cur=head.next; cur !=null ; cur=cur.next) {
            System.out.print(cur.data+" ");
        }
    }
}
