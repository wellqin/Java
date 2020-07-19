package javabase.datatype;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: Wellqin
 * @Date: 2020/7/20 0:26
 * @Desc 数组在java中它就是对象。一个比较特殊的对象。
 */

class Point{
    int id;
    int age;
}

/**
 * @author QWust
 */
public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList<类名> list = new ArrayList<类名>();  不能是基本类型，必须是类，需要使用到基本类型的包装类
        ArrayList<Point> list1 = new ArrayList<Point>();
        Point p = new Point();
        p.id = 10086;
        p.age = 25;
        list1.add(p);
        p.id = 10088;
        p.age = 33;
        list1.add(p);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("i=" + i + " id=" + list1.get(i).id + " age=" + list1.get(i).age);
        }

        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);

        // 第一个参数为索引位置，第二个为要修改的值
        sites.set(2, "Wiki");

        // 访问第二个元素
        System.out.println(sites.get(1));

        // 删除第四个元素
        sites.remove(3);
        System.out.println(sites);

        // 计算元素数量可以使用 size() 方法
        System.out.println(sites.size());

        // Collections 类也是一个非常有用对类，位于 java.util 包中，提供的 sort() 方法可以对字符或数字列表进行排序。
        Collections.sort(sites);

        for (String i : sites) {
            System.out.println(i);
        }

    }
}

/*
  加入的东西是对象，一个对象在堆中各自有一片内存，在访问的时候利用栈中的地址指向堆，从堆中获取数值，
  通过改变一个对象的值再次用add加入数组，是将同一个对象加入两次，至于使用的时候，获取的数值是最后对象的数值。
  上面代码结果
  i=0 id=10088 age=33
  i=1 id=10088 age=33

    1.导入
    import java.util.ArrayList;

    2.定义数组list
    ArrayList<类名> list = new ArrayList<类名>();  不能是基本类型，必须是类

    3.获取集合大小
    size()

    4.存入数据
    add(Object object);从下标0开始加入

    5.删除
    remove(int idx);删除索引为idx的元素，返回该元素，可以用变量去接收，也可不接收

    6.清空
    clear(); 清空数组

    7.替换
    set(int idx,Object object); 把object元素和原本索引为idx的元素替换

    8.获取指定位置元素
    Object get(int idx);

    9.判空
    bool isEmpty(); 一般不用，size()可以用于判空

    10.判断是否有某元素
    bool contains(Object object); 基本不用，可以通过查找元素的索引来解决

    11.查找元素的索引
    int indexOf(Object object); 如果元素存在，则返回索引，否则返回-1，通过是不是-1判断元素在不在数组里

    12..对数组list排序
        导入Collections类；
        import java.util.Collections;
            1）默认自然排序，从小到大
            Collections.sort(list); //不可以new出Collections的对象，直接用

            2）自定义排序
            导入Comparator类；
            import java.util.Comparator;
            创建对象的时候需要实现抽象方法compare(),实现自定义排序


 */


/*
*  ArrayList原理
    1.数据结构
    ArrayList底层是数组，都说它是动态数组，所谓的动态就是不够的时候扩容，扩容是新开一个原来数组长度1.5倍数组，
    再把原来的值复制过去，用Arrays.copyOf()方法，速度比常规写的遍历快很多。可以存null值。

    2.添加操作add()
    先判断这个数组是否为空，
    如果空就新开一个数组，默认容量为10；然后赋值改大小。
    如果不为空，判断当前容量是否满足size+1，如果不满足就动态增长为1.5倍，然后赋值改大小。

    3.删除remove()
    删除指定位置元素E remove(int index):检查index合法性，获取指定位置的对象，计算后面需要往前移动位数，
    然后再调用移动元素的方法System.arraycopy()。（如果是普通人写就是遍历，调用这些方法会更快，具体源码就没继续深入下去看了）
    原来位置对象赋null让GC去回收，返回删除的对象。
    删除第一个指定内容的元素boolean remove(Object object):查找，再移位。找得到元素就返回真，找不到返回假。

    4.清空clear()
    将所有元素赋值null，让GC回收

    5.其他的方法例如插入set()等大多类似，原理很简单的，应该是调用很多底层的方法编写，提高效率。

* */