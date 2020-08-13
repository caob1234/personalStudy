package com.smart.initialization;
class Rock{
    public String getStr2() {
        return str2;
    }

    private String str2;
    public Rock(String s) {
        this.str2=s;
        System.out.println("This a value in constructor.");
    }
}
public class SimpleConstructor3 {
    public static void main(String[] args){
        String s="This is a common value.";
        Rock rock=new Rock(s);
        System.out.println(rock.getStr2());
    }
}
