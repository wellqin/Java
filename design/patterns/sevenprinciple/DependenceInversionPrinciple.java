package design.patterns.sevenprinciple;

/**
 * @Author: Wellqin
 * @Date: 2020/8/16 15:52
 * 依赖倒转原则 ( Dependence Inversion Principle ) 指的是：
 *     高层模块不应该依赖低层模块，二者都应该依赖其抽象；
 *     抽象不应该依赖细节，细节应该依赖抽象；
 *     依赖倒转的核心思想是面向接口编程。
 *
 * 为什么要有依赖倒转原则：主要是因为，相对于细节的多变，抽象的东西要稳定的多，以抽象为基础搭建的架构比以细节为基础的架构稳定的多，
 * 在java种，抽象指的就是接口或者抽象类，细节就是具体的实现类，抽象类制定好规范，展现细节的任务交给实现类去做。
 *
 * 依赖倒转原则需要注意：
 *
 *     底层模块尽量都要有抽象类或接口，或者两者都有，程序的稳定性会更好；
 *     变量的声明类型尽量是抽象类或接口，这样我们的变量引用和实际对象之间，就存在一个缓冲层，利于程序扩展和优化；
 *     继承时遵循里氏替换原则。
 */

// 抽象指的就是接口或者抽象类，细节就是具体的实现类，抽象类制定好规范，展现细节的任务交给实现类去做。
// 对这个抽象接口的依赖，而不是直接依赖这些不同的实现类

public class DependenceInversionPrinciple {
}

// 例如：有一个功能，一个Person类，要有一个接收消息的功能。
/*
因为Person类需要的接受是一个功能，消息应该是另一个类，所以还有一个Email类。
那么这种写法，显然直接犯在Person类里依赖了Email类，也就是上面所说的”高层模块依赖底层模块“。
那么这么写可能会带来哪些问题呢？
对于Person类，接受的这个动作可以扩展，如果要接受的不仅仅是Email，是很多短信、微信等信息，那么在新增短信、微信类的同时，
Person类里要新增对应的方法，改动基本是所有的都改动。

按照依赖倒转原则，对于Email、短信这些不同的类，应该将他们抽象出一个接口，然后他们实现接口，这样的话，对于Person类，他的接受方法，
就是对这个抽象接口的依赖，而不是直接依赖这些不同的实现类。
*/

class DependencyInversion1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}
class Email{
    public String getInfo(){
        return "电子邮件信息";
    }
}
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}

//  改进
/*
* 在客户端的调用方式也是几乎一样的，运行结果是一样的，同时，因为Person依赖的是抽象的接口而不是具体的Email。
当我们想要增加一个接受的类的时候，平行增加，同时都去实现接口里面的方法就可以，Person类不用做改变，那么调用的时候传入参数去变成具体的实现类就可以。*/

class Dependency1 {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        person1.receive(new Email1());
        // 扩展Wechat
        person1.receive(new Wechat());
    }
}

interface IReceiver{
    public String getInfo();
}

class Email1 implements IReceiver{
    @Override
    public String getInfo() {
        return "电子邮件信息:";
    }
}

// 扩展Wechat

class Wechat implements IReceiver{
    @Override
    public String getInfo() {
        return "微信消息：";
    }
}

class Person1{
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}


/*扩展：依赖关系传递的三种方式：依赖关系的传递一般有三种方式：
    接口传递；
    构造方法传递；
    setter方法传递。
*/

// 方式1：通过接口传递依赖
// 可以看到，因为第一个接口依赖于第二个接口，那么实现第一个接口的时候，就需要实现对应的方法，把接口作为参数，实现了依赖的传递。

interface IOpenandClose{
    public void open(ITV itv);
}
interface ITV{
    public void play();
}
class OpenandClose implements IOpenandClose{
    @Override
    public void open(ITV itv) {
        itv.play();
    }
}
// 调用方式
// OpenandClose close = new OpenandClose();
// close.open(new Sumsang());
class Sumsang implements ITV{
    @Override
    public void play() {
        System.out.println("三星电视开机啦");
    }
}

// 方式2，通过构造方法传递依赖
// 通第一个接口和第二个接口虽然没有直接写明依赖，但是依赖体现在实现类里，
// 实现类里通过构造方法传入一个参数，才能进行open方法的实现，所以在构造方法的部分体现了依赖关系。
// OpenandClose2 close2 = new OpenandClose2(new Sony());
// close2.open();  虽然open没有参数，但是依赖是通过构造方法传递的。

interface IOpenandClose2{
    public void open();
}
interface ITV2{
    public void play();
}
class OpenandClose2 implements IOpenandClose2{
    public ITV2 itv2;
    public OpenandClose2(ITV2 itv2){
        this.itv2 = itv2;
    }
    @Override
    public void open() {
        this.itv2.play();
    }
}

// 方式3，通过set方法传递依赖
// 其实和第一种类似，不过没有在open的地方直接依赖，而是分成两个步骤，先给声明的ITV初始化，再进行使用，这样依赖也就传递成功了。
// OpenandClose3 close3 = new OpenandClose3();
// close3.setTv(new Xiaomi());//如果不先set，就会报空指针close3.open();

interface IOpenandClose3{
    public void open();
    public void setTv(ITV3 itv3);
}
interface ITV3{
    public void play();
}
class OpenandClose3 implements IOpenandClose3{
    private ITV3 itv3;
    @Override
    public void setTv(ITV3 itv3) {
        this.itv3 = itv3;
    }
    @Override
    public void open() {
        this.itv3.play();
    }
}






