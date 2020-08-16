package design.patterns.sevenprinciple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wellqin
 * @Date: 2020/8/16 16:37
 */

/*
Demeter Principle 迪米特法则，又叫最少知道原则：

即一个类对自己依赖的类知道的越少越好，也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装再类的内部。对外提供public方法，不对外泄露任何信息。

迪米特法则还有个更简单的定义：只与直接的朋友通信。

    什么是直接朋友？每个对象都会和其他对象之间有耦合关系，只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系，
    耦合的方式有很多，依赖、关联、组合、聚合等。
    其中我们称出现在成员变量、方法参数、方法返回值中的类为直接的朋友，而出现在局部变量中 的类不是直接的朋友，
    也就是说，陌生的类最好不要以局部变量的形式出现在类的内部。

    比如A类里面直接有用到一个B b，或者某个方法有参数fuc1(B b)；或者返回值类型是B，那么这叫做B以直接朋友的形式出现在了A里面。

    比如A类里面有个方法 fuc1，fuc1用到一个 B b = new B()；这样的局部变量形式让A里面出现了B，这就是陌生的类，而不是直接朋友。

* */

// 比如一个应用实例：
//
// 有一个学校，下属各个学院和总部，现在要求打印出学校总部的员工ID和学院员工的ID。
// 代码略长，但是逻辑很简单：

// 这里面的问题，关于直接朋友和非直接朋友已经标注。
// 按照迪米特法则，上面出现了 SchoolEmployee 是陌生朋友，出现在了 SchoolManager 类里。
// 这是非直接朋友关系的耦合，根据迪米特法则是应该避免的。

class Demeter1 {
    public static void main(String[] args) {
        CollegeManager collegeManager = new CollegeManager();
        collegeManager.printAllEmp(new SchoolManager());
    }
}

//学校总员工

class Employee{
    private String id;
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}

//学院员工

class SchoolEmployee{
    private String id;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}

//管理学院员工

class SchoolManager{

    //添加学院员工

    public List<SchoolEmployee> getAllEmployee(){
        List<SchoolEmployee> list = new ArrayList<>();
        for( int i=0; i<10; i++){
            SchoolEmployee employee = new SchoolEmployee();
            employee.setId("学院员工:"+i);
            list.add(employee);
        }
        return list;
    }
}

//学校管理类
//直接朋友类有：Employee、SchoolManager，第一个作为添加方法返回值，第二个作为输出方法的参数
//陌生类：SchoolEmployee，违背了迪米特法则

class CollegeManager{
    //添加学校员工，返回值参数Employee：直接朋友

    public List<Employee> getAllEmployee(){
        List<Employee> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            Employee employee = new Employee();
            employee.setId("学校总部员工："+i);
            list.add(employee);
        }
        return list;
    }
    //输出所有员工信息
    //参数SchoolManager：直接朋友

    public void printAllEmp(SchoolManager sub){
        //SchoolEmployee：陌生朋友，局部变量的方式
        List<SchoolEmployee> list1 = sub.getAllEmployee();
        System.out.println("-----学院员工-----");
        for(SchoolEmployee e: list1){
            System.out.println(e.getId());
        }
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("-----学校员工-----");
        for(Employee e: list2){
            System.out.println(e.getId());
        }
    }
}

// 改进
/*
其实例子写的有点故意，显然出问题的那一段，学校的输出信息部分，要输出学院的信息，没必要，
解决起来把输出学院员工信息的那段，放到学院员工自己的类里面就可以了。也就是遵守了前面说的 " 尽量将逻辑封装在类的内部 "。

那么就可以把 SchoolManager 部分输出学院信息部分改成：

//学院员工
sub.printEmployee();

然后对应的输出方法，写去CollegeManager类里面，添加一个方法：
*/

/*
//输出学院所有员工的信息
public void printEmployee(){
    List<SchoolEmployee> list1 = this.getAllEmployee(); //不用this也行
    System.out.println("-----学院员工-----");
    for(SchoolEmployee e: list1){
        System.out.println(e.getId());
    }
}

这样的话，逻辑在自己类内部，提供一个public方法供外部使用。

注意：每个类之间多多少少都会有耦合，
迪米特法则只是要求降低耦合关系，而不是要求完全没有依赖关系。完全没有，就相当于每个对象干个啥都在自己类里写完，也用不着直接朋友了。
*/

