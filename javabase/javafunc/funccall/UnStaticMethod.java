package javabase.javafunc.funccall;

import javabase.javafunc.common.Utils;

/**
 * @Author: Wellqin
 * @Date: 2020/7/19 23:52
 * @Desc：非静态方法调用其他方法
 */

public class UnStaticMethod {
    public void son1(){//非静态方法
        System.out.println("java大爷，你成功调用了你非静态方法里的儿子1");
    }

    public static void son2(){//静态方法
        System.out.println("java大爷，你成功调用了你静态方法里的儿子2");
    }

    // 在同一类内，非静态方法可以直接调用静态方法和非静态方法
    public void alloutput(){
        son1();//非静态方法直接调用类内的非静态方法△
        son2();//非静态方法直接调用类内的静态方法△
    }

    public void output(){
        son1();
        Son.isSon1();//通过类名直接调用Son类中的静态方法，不建议使用对象调用静态方法
        Son son = new Son();
        son.isSon2();//通过对象调用Son类中的非静态方法

//        Utils.isSon(); TODO

    }

    public static void main(String[] args) {
        /*非静态方法在同一类内调用其他方法， 在同一类内，非静态方法可以直接调用静态方法和非静态方法*/
        UnStaticMethod test = new UnStaticMethod();
        test.alloutput();//前边已学静态方法通过对象调用非静态方法

        //同一类中的静态方法调用非静态方法output，前边已经涉及到
        /*非静态方法在不同类之间调用其他方法
            在不同类之间，非静态方法需要通过对象才能调用非静态方法。
            非静态方法既可以通过对象调用静态方法又可以通过类名直接调用（由于对象的调用方式属于非静态调用方式，
            所以建议使用类名直接调用静态方法）
        * */
        test.output();
    }
}
