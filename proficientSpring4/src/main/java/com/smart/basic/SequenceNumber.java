package com.smart.basic;

public class SequenceNumber {
    private static SimpleThreadLocal seqNum = new SimpleThreadLocal(){
        public Integer initialValue(){
            return 0;
        }
    };
    public int getNextNum(){
        seqNum.set(1 + (int)seqNum.get());
        return (int) seqNum.get();
    }
    public static void main(String[] args){
        SequenceNumber sn = new SequenceNumber();

        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread{
        private SequenceNumber sn;
        public TestClient(SequenceNumber sn){
            this.sn = sn;
        }
        public void run(){
            for (int i=0; i<3;i++){
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["
                        +sn.getNextNum()+"]");
            }
        }
    }
}
