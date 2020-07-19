package javabase.javafunc.funccall;

import javabase.javafunc.common.Utils;

/**
 * @Author: Wellqin
 * @Date: 2020/7/19 23:29
 */

public class StaticMethod {
    // 非静态方法
    public void isSon1(){
        System.out.println("java大爷，你成功调用了你非静态方法里的儿子1");
    }

    // 静态方法
    public static void isSon2(){
        System.out.println("java大爷，你成功调用了你静态方法里的儿子2");
    }


    public static void main(String[] args) {
        /*静态方法调用非静态方法, 无论是否在同一类内，均需要通过对象调用*/
        StaticMethod son1 = new StaticMethod();
        //静态方法通过对象调用此类中的非静态方法
        son1.isSon1();
        //静态方法通过对象调用Son类中的非静态方法
        Son son = new Son();
        son.isSon();

        Utils util = new Utils();
        util.isSon(); // Son类里的非静态方法

        /*静态方法调用静态方法, 同一类内直接调用，不同类内直接通过类名.方法名（参数表）调用*/
        isSon2();//静态方法直接调用类内的静态方法
        Son.isSon3();//静态方法通过类名直接调用Son类中的静态方法


    }
}
