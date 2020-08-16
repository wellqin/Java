package design.patterns.sevenprinciple;

/**
 * @Author: Wellqin
 * @Date: 2020/8/16 16:32
 *
 * 开闭原则（Open Closed Principle）是编程中最基础、最重要的设计原则。
 * -- 当我们给类增加新功能的时候，尽量不修改代码，或者尽可能少修改代码
 *
 *     一个软件实体、如类，模块和函数应该对扩展开放（对提供方），对修改关闭（对使用方）。用抽象构建框架，用实现扩展细节；
 *     当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过已有代码实现变化；
 *     编程中遵循其他原则的目的就是遵循开闭原则。
 */

public class OpenClosedPrinciple {
}

//绘图类，根据接受的shape不同来绘制图形，【使用方】

class GraphicEidtor{
    public void drawShape(Shape s){
        if(s.type == 1) {
            drawRec(s);
        }
        if (s.type == 2) {
            drawCir(s);
        }
    }
    public void drawRec(Shape r){
        System.out.println("矩形");
    }
    public void drawCir(Shape c){
        System.out.println("圆形");
    }
}

//基类

class Shape{
    int type;
}

//【提供方】

class Rectangle extends Shape{
    Rectangle(){
        super.type = 1;
    }
}
class Circle extends Shape{
    Circle(){
        super.type = 2;
    }
}

// 调用的时候，给draw方法传入不同的参数，会根据类型画出不同的图形，我们调用一下：
//    GraphicEidtor graphicEidtor = new GraphicEidtor();
//    graphicEidtor.drawShape(new Rectangle());
//    graphicEidtor.drawShape(new Circle());
/*这种写法还是比较好理解的，但是这种写法很不好。
那么，这种写法的问题在哪里呢？
违反了设计模式的 OCP 开闭原则，也就是不满足对扩展开放，对修改关闭。这个原则希望当我们给类增加新功能的时候，尽量不修改代码，或者尽可能少修改代码。
比如我们想加一个图形种类，那就要将这个图形多写一个类作为【提供方】，在画图类【使用方】里增加一个对应shape类型的调用，
再增加一个方法。这就是违背原则了。
*/


// 改进

/* 改进
思路就是：创建shape作为抽象类，提供一个抽线的draw方法，那么子类实现的时候去实现draw方法，
这样的话，【使用方】就不用修改代码，满足了开闭原则。

（其实说白了就是面向对象的意思，这个对象自己本身需要向外提供方法，而不是让使用方去提供方法，
同时，前面四个原则里也多多多少少有用到这个思路，就是让使用方不要改动）

这样的话，调用的写法是没有任何改变的。
但是呢，如果我们要加一个新的形状，那么就让他自己去实现方法就可以了，对于【使用方】GraphicEidtor 是修改关闭的。
*/

class GraphicEidtor1{
    public void drawShape(Shape1 s){
        s.draw();
    }
}

abstract class Shape1{
    int type;
    public abstract void draw();
}

class Rectangle1 extends Shape1{
    Rectangle1(){
        super.type = 1;
    }
    @Override
    public void draw(){
        System.out.println("矩形");
    }
}
class Circle1 extends Shape1{
    Circle1(){
        super.type = 2;
    }
    @Override
    public void draw(){
        System.out.println("圆形");
    }
}







