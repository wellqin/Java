package design.patterns.sevenprinciple;

/**
 * @Author: Wellqin
 * @Date: 2020/8/16 15:46
 *
 * 接口隔离（Interface Segregation Principle）
 * 意思是说，如果某一个类对另一个类的依赖通过的是接口，那么这个类对另一个类的依赖应该建立在最小的接口上，如果不是最小接口，则需要拆。
 */


/*
* A 和 B 是 Interface1 的实现类，所以必须实现它的 4 个方法，C 和 D 分别依赖于这个接口，使用 A 和 B 里面对应的方法，但不是全部，
* C 使用前三个方法，D 使用后三个方法，如果按照类图实现，代码会如下所示。
*
* 显然，A 和 B 两个实现类都做了多余的工作，也就是 C 和 D 依赖的这个接口有些方法是他们不需要的，这个接口写的不好。
* */

interface Interface1{
    void fuc1();
    void fuc2();
    void fuc3();
    void fuc4();
}

class A implements Interface1{
    @Override
    public void fuc1() {System.out.println("A实现了fuc1");}
    @Override
    public void fuc2() {System.out.println("A实现了fuc2");}
    @Override
    public void fuc3() {System.out.println("A实现了fuc3");}
    @Override
    public void fuc4() {System.out.println("A实现了fuc4");}
}

class B implements Interface1{
    @Override
    public void fuc1() {System.out.println("B实现了fuc1");}
    @Override
    public void fuc2() {System.out.println("B实现了fuc2");}
    @Override
    public void fuc3() {System.out.println("B实现了fuc3");}
    @Override
    public void fuc4() {System.out.println("B实现了fuc4");}
}

// C通过接口Interface1依赖，使用A这个实现类，但是只用A的前两个方法

class C {
    public void depend1(Interface1 i){
        i.fuc1();
    }
    public void depend2(Interface1 i){
        i.fuc2();
    }
    public void depend3(Interface1 i){
        i.fuc3();
    }
}

// D通过接口Interface1依赖，使用B这个实现类，但是只用B的后两个方法

class D {
    public void depend2(Interface1 i){
        i.fuc2();
    }
    public void depend3(Interface1 i){
        i.fuc3();
    }
    public void depend4(Interface1 i){
        i.fuc4();
    }
}

/*
改进

根据接口隔离原则，我们应该将其拆成满足最小接口的类型，也就是说多余的我们全都不应要，
所以接口 Interface1 应该拆分为三个接口，
接口 1 里面有方法 1 ，接口 2 里面有方法 23，接口 3 里面有方法 4，这样实现的时候A和B两个类就更加清晰
那么，这样 A 和 B 实现的方法就是需要的方法，不会有多余的方法，C 和 D 的依赖也就更加清楚，满足 最小接口
* */

// 这种写法就是遵循了接口隔离原则

interface Interface11{
    void fuc1();
}
interface Interface12{
    void fuc2();
    void fuc3();
}
interface Interface13{
    void fuc4();
}

class A1 implements Interface11,Interface12{
    @Override
    public void fuc1() {System.out.println("A实现了接口1的fuc1");}
    @Override
    public void fuc2() {System.out.println("A实现了接口2的fuc2");}
    @Override
    public void fuc3() {System.out.println("A实现了接口2的fuc3");}
}

class B1 implements Interface12,Interface13{
    @Override
    public void fuc2() {System.out.println("B实现了接口2的fuc2");}
    @Override
    public void fuc3() {System.out.println("B实现了接口2的fuc3");}
    @Override
    public void fuc4() {System.out.println("B实现了接口3的fuc4");}
}

class C1{
    public void depend1(Interface11 i){
        i.fuc1();
    }
    public void depend2(Interface12 i){
        i.fuc2();
    }
    public void depend3(Interface12 i){
        i.fuc3();
    }
}
class D1{
    public void depend2(Interface12 i){
        i.fuc2();
    }
    public void depend3(Interface12 i){
        i.fuc3();
    }
    public void depend4(Interface13 i){
        i.fuc4();
    }
}

class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        C1 c = new C1();

        //C类通过接口依赖（使用）的是A类

        c.depend1(new A1());
        c.depend2(new A1());
        c.depend3(new A1());

        D1 d = new D1();

        //D类通过接口依赖（使用）的是B类

        d.depend2(new B1());
        d.depend3(new B1());
        d.depend4(new B1());

    }
}

