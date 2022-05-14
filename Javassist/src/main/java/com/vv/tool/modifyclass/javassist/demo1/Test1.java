package com.vv.tool.modifyclass.javassist.demo1;

public class Test1 {

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        int result = t1.addNumber(3, 5);
        System.out.println("result is: " + result);
    }

    public int addNumber(int a, int b) {
        return a + b;
    }
}
