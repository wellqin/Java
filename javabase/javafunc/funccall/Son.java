package javabase.javafunc.funccall;

/**
 * @Author: Wellqin
 * @Date: 2020/7/19 23:34
 */

public class Son {
    public void isSon(){
        System.out.println("java大爷，你成功的调用了你另一个类里的儿子");
    }//Son类里的非静态方法

    public  static void isSon3(){
        System.out.println("java大爷，你成功的调用了你另一个类里的静态儿子3");
    }//Son类里的静态方法

    public static void isSon1(){//Son类里的静态方法
        System.out.println("java大爷，你成功的调用了你另一个类里的静态儿子1");
    }

    public void isSon2(){//Son类里的非静态方法
        System.out.println("java大爷，你成功的调用了你另一个类里的非静态儿子2");
    }
}
