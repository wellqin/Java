package design.patterns.sevenprinciple;

/**
 * @Author: Wellqin
 * @Date: 2020/8/16 16:10
 * 面向对象中继承的问题：
 *
 *     父类实现好的方法，实际上设定了规范，虽然不强制要求子类都要遵守，到那时如果子类对这些方法进行了修改，会对整个继承体系造成破坏；
 *     如果使用继承会给程序带来入侵性，使得移植性降低，增加对象之间的耦合性，如果一个类被其他的类所继承，则当这个类需要修改时，会影响所有子类；
 *     那么，如何在编程中正确使用继承呢？=> 里氏替换原则
 *
 * 里氏替换：也就是尽量不要重写父类的方法
 *
 *     里氏替换原则：如果每个类型 T1 的对象 o1 ，都有类型 T2 的对象 o2，使得以 T1 定义的所有程序 P 在所有的对象 o1 都换成 o2 时，
 *     程序 P 的行为没有发生变化，那么类型 T2 是类型 T1 的子类型，也就是说，引用基类（父类）的地方必须能透明的使用其子类（派生类）的对象。
 *     使用继承的时候，遵循里氏替换原则，也就是尽量不要重写父类的方法；
 *     这个原则告诉我们，继承让两个类的耦合性增强了，适当情况下，可以通过聚合、组合、依赖来解决问题。
 *
 * 如何理解这个原则呢，假如一个父类是 A，B extends A，结果把 A 类的所有方法都重写了，那肯定A类的对象所有行为都变化了，
 * 另一方面，B 还要继承 A 类纯属有病。适当的，A 和 B 更适合于，继承同一个更加基础的类 C，重新整理，这样解决这个问题会比较合适。
 */

class AA{
    public int func1(int a, int b){
        return a - b;
    }
}
class BB extends AA{
    @Override
    public int func1(int a, int b){
        return a + b;
    }
    public int func2(int a, int b){
        return func1(a, b)+9;
    }
}

/*
不管是无意还是有意，B 继承 A 的时候把 func1 重写了。
显然，这样 B 以为被正常调用的时候，求a-b的 func1 ，却输出了和调用 a 的 func 1不一样的结果。
（可能例子不是很恰当，但是如果更复杂的情况下，调用一个子类的某一个方法，方法名是一样的，肯定会认为功能是一样的）

实际开发过程中，就是因为一些重写父类方法来完成新功能的操作，让整个继承体系的复用性变差，特别是用到多态比较多的时候。
通用的做法就是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖、聚合、组合等关系来替代。

那么，这样的话A和B已经没有耦合的依赖关系了，
那么调用的时候，想要减法的方法就可以调用fuc3，使用加法可以调用fuc1，此时不会和A的fuc1打架或者覆盖。
* */

// 更加基础的类

class Base{

}
class AA1 extends Base{
    public int func1(int a, int b){
        return a - b;
    }
}
class BB1 extends Base{
    public int func1(int a, int b){
        return a + b;
    }
    public int func2(int a, int b){
        return func1(a, b)+9;
    }
    //如果b要使用到A的方法，使用组合的关系

    private AA1 a1 = new AA1();

    //仍然使用A的方法

    public int func3(int a, int b){
        return this.a1.func1(a, b);
    }
}


