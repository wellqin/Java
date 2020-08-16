package design.patterns.sevenprinciple;

/**
 * @Author: Wellqin
 * @Date: 2020/8/16 15:28
 *
 * 总结单一职责原则
 *     降低类的复杂度，一个类只负责一项职责（上面的例子因为过于简单，所以看起来第三个写法更有效）；
 *     提高类的可读性、可维护性，降低变更带来的风险；
 *     通常情况下，我们应该遵守这个职责，只有在逻辑足够简单的时候，才可以在代码级别违反这个原则，也就是上面的，改为在方法级别保持单一职责原则。
 */

// 单一职责原则
/*
对于类来说，一个类应该只负责一项职责。
假设A负责两个不同的职责1和2，如果1的内容需要改变，影响了2，那可能2会执行错误，所以需要将A分为两个类。
*/

class SingleResponsibility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("摩托车");
        vehicle.run("飞机");
    }
}

class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在地上跑");
    }
}

/*
对于一个完成交通工具的类Vehicle来说，显然对不同的对象、汽车和飞机，提供的服务不应该都是在地上跑，并且修改之后，
肯定会影响到其中一类对象的功能，所以按照单一职责，那就应该拆开，成两个类。*/

class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在地上跑");
    }
}
class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在天上飞");
    }
}

/*
* 但是这么写又有了新的问题：那就是类分解的时候，客户端代码也要改，调用方式改了。因此可以直接更改本来的Vehicle类，变成我们的第三种写法
* */

class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.runRoad("汽车");
        vehicle2.runWater("轮船");
        vehicle2.runAir("飞机");
    }
}

class Vehicle2{
    public void runRoad(String vehicle){
        System.out.println(vehicle+"在公路上跑");
    }
    public void runAir(String vehicle){
        System.out.println(vehicle+"在天上飞");
    }
    public void runWater(String vehicle){
        System.out.println(vehicle+"在水里游");
    }
}
/*
* 这种写法，显然更加方便，相比第一种，没有更改类的声明方式，只是在类内部增加了方法的各司其职，
* 可以看出来，虽然没有在类级别上严格遵循单一职责原则，但是在方法级别上严格遵循了单一职责原则，相比之下比方法2更合适。
* */
