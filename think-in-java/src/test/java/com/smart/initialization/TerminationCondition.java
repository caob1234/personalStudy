package com.smart.initialization;

class Book {
    boolean checkedOut = false;

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    //重写，是子类对父类方法的重写编写；而重载(overloading) 是在一个类里面，
    // 方法名字相同，而参数不同。返回类型可以相同也可以不同。
    //https://www.runoob.com/java/java-override-overload.html
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error:checked out");
            super.finalize();
        }
    }
}

public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        //Proper cleanup
        novel.checkIn();
        new Book(true);
        System.gc();//Force garbage collection&finalization
    }
}
