package javabase.datatype;

import java.util.Arrays;

/**
 * @Author: Wellqin
 * @Date: 2020/8/2 23:46
 *
 * 数组的定义：
 * 　　数组是相同类型数据的有序集合。数组描述的是相同类型的若干个数据，按照一定的先后次序排列组合而成。
 *    其中，每一个数据称作一个元素，每个元素可以通过一个索引(下标)来访问它们。
 *
 * 数组的基本特点：
 * 1. 长度是确定的。数组一旦被创建，它的大小就是不可以改变的。
 * 2. 其元素必须是相同类型，不允许出现混合类型。元素的类型可以是java 支持的任意类型
 * 3. 数组类型可以是任何数据类型，包括基本类型和引用类型。
 * 4. 数组的元素在堆内存中被分配空间，并且是连续分配的
 * 5. 使用new 关键字对数组进行 内存的分配。每个元素都会被jvm 赋予默认值。
 *    默认规则：整数：0 浮点数：0.0 字符：\u0000 布尔：false 引用数据类型：null。
 * 6. 数组的元素都是有序号的，序号从0开始，0序的。称作数组的下标、索引、角标
 *
 * 数组的声明：
 * 1. 声明的时候并没有实例化任何对象，只有在实例化数组对象时，JVM才分配空间，这时才与长度有关。
 * 2. 声明一个数组的时候并没有数组真正被创建。
 * 3. 构造一个数组，必须指定长度。
 *    double[] myList;         // 首选的方法
 *    double myList[];         // 效果相同，但不是首选方法
 *
 * 数组格式：
 * 元素类型[ ] 数组名 = new 元素类型 [元素个数或数组长度];   //  int [] arr = new int [3];
 * []：代表这是数组类型。
 * 数组名：一个合法的标识符，命名规范 和 局部变量 规范一致。
 * new：是java 的关键字。用来向JVM申请内存的。
 * 元素类型[元素个数] ：决定了向JVM申请的内存空间的大小。
 * 　　　　　　　　　    大小：元素类型字节数 * 元素个数
 * 元素的个数：只要是一个合法的java 表达式就可以。 返回一个int 类型的值即可
 *
 * dataType[] arrayRefVar = new dataType[arraySize];
 * dataType[] arrayRefVar = {value0, value1, ..., valuek};
 *
 *
 * 数组的优缺点：
 * 优点：
 * 1：可以保存若干个数据。
 * 2：随机访问的效率很高。根据下标访问元素效率高（元素连续分配空间）。
 * 缺点：
 * 1：数组的元素的类型必须一致。元素类型必须一致。
 * 2：连续分配空间在堆中，如果数组的元素很多，对内存的要求更加的严格。
 * 3：根据内容查找元素效率比较低，需要逐个比较个。
 * 4：删除元素、插入元素效率比较低，需要移动大量的元素。
 * 5：数组定长，不能自动扩容。
 * 6：数组没有封装，数组对象只提供了一个数组长度的属性，但是没有提供方法用来操作元素。
 * java 提供了一整套的 针对不同需求的 对于容器的解决的方案。集合框架部分。不同的容器有不同的特点，满足不同的需求。数组的缺点都会被干掉。
 *
 *
 * 数组的初始化：静态初始化、动态初始化、默认初始化
 * 静态初始化：int[] arr = { 1, 2, 3 };// 静态初始化基本类型数组；
 * 动态初始化：int[] arr = new int[2];//动态初始化数组，先分配空间；
 * 　　　　　　arr[0]=1;//给数组元素赋值；
 * 　　　　　　arr[1]=2;//给数组元素赋值；
 * 默认初始化：int arr[] = new int[2]; // 默认值：0,0
 * 　　　　　　boolean[] b = new boolean[2]; // 默认值：false,false
 * 　　　　　　String[] s = new String[2]; // 默认值：null, null
 */


public class List {
    public static void main(String[] args) {
        // 数组大小
        int size = 10;
        // 定义数组
        double[] myList = new double[size];
        double[] myListTwo = {1,2,3,4,5,6,7,8,9,10};
        myList[0] = 5.6;
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 11123;
        // 计算所有元素的总和
        double total = 0;
        double total1 = 0;
        for (int i = 0; i < size; i++) {
            total += myList[i];
            total1 += myListTwo[i];
        }
        for (double element: myListTwo) {
            System.out.println("myListTwo： " + element);
        }
        System.out.println("总和为： " + total);
        System.out.println("总和为： " + total1);
    }

    // 数组作为函数的返回值

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }


    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }


}

/**
 * 基于数组的拷贝操作:拷贝、删除、扩容
 * System类里也包含了一个static void arraycopy(object src，int srcpos，object dest， int destpos，int length)方法，
 * 该方法可以将src数组里的元素值赋给dest数组的元素，其中srcpos指定从src数组的第几个元素开始赋值，
 * length参数指定将src数组的多少个元素赋给dest数组的元素。
 * */
class ArrayCopyTest {
    public static void main(String[] args) {
        arrayCopy();
        String[] str = { "Java", "C", "C++", "Python", "JScript" };
        String[] remove = ArrayCopyTest.removeElement(str, 1);
        System.out.print(Arrays.toString(remove) + " " + "\n");

        String[] str1 = { "Java", "C", "C++", "Python", "JScript" };
        String[] extend = ArrayCopyTest.extendRange(str1);
        System.out.print(Arrays.toString(extend) + " " + "\n");
        }
         // 数组的拷贝

         public static void arrayCopy() {
             String[] s1 = { "aa", "bb", "cc", "dd", "ee", };
             String[] s2 = new String[7];
             // 从s1 里下标为1的数组开始拷贝到s2,存放在s2里下标为2的位置开始，拷贝3个数组。
             System.arraycopy(s1, 1, s2, 2, 3);
             for (String s : s2) {
                 System.out.print(s + " ");
             }
         }

         // 删除数组中指定索引的位置,并返回原数组.实则还是拷贝数组，再覆盖原来的数组

         public static String[] removeElement(String[] s, int index) {
             System.arraycopy(s, index + 1, s, index, s.length - index - 1);
             // 特殊处理最后一个数组
             s[s.length - 1] = null;
             for (String value : s) {
                 System.out.print(value + " " + "\n");
             }
             return s;
         }

         // 数组的扩容

         public static String[] extendRange(String[] s1){
             // 传入的数组基础上空间+3
             String[] s2  = new String[s1.length+3];
             System.arraycopy(s1, 0, s2, 0, s1.length);
             for (String s : s2) {
                 System.out.println(s);
             }
             return s2;
    }

}

/**
 * java.util.Arrays类能方便地操作数组，它提供的所有方法都是静态的。具有以下功能：
 * 给数组赋值：通过fill方法。
 * 对数组排序：通过sort方法,按升序。
 * 比较数组：通过equals方法比较数组中元素值是否相等。
 * 查找数组元素：通过binarySearch方法能对排序好的数组进行二分查找法操作。
 *
 * java.util.Arrays类
 * JDK提供的java.util.Arrays类，包含了常用的数组操作，方便我们日常开发。Arrays类包含了：排序、查找、填充、打印内容等常见的操作。
 * 打印数组  Arrays.toString(arr)
 * */


class TestArrays {
    // Arrays.toString(arr) 可以进行替代

    public static void output(int[] array) {
        if (array != null) {
            for (int value : array) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        // 填充数组
        Arrays.fill(array, 5);
        System.out.println("填充数组：Arrays.fill(array, 5)：");
        TestArrays.output(array);
        // 将数组的第2和第3个元素赋值为8
        Arrays.fill(array, 2, 4, 8);
        System.out.println("将数组的第2和第3个元素赋值为8：Arrays.fill(array, 2, 4, 8)：");
        TestArrays.output(array);
        int[] array1 = { 7, 8, 3, 2, 12, 6, 3, 5, 4 };
        // 对数组的第2个到第6个进行排序进行排序
        Arrays.sort(array1, 2, 7);
        System.out.println("对数组的第2个到第6个元素进行排序进行排序：Arrays.sort(array,2,7)：");
        TestArrays.output(array1);
        // 对整个数组进行排序
        Arrays.sort(array1);
        System.out.println("对整个数组进行排序：Arrays.sort(array1)：");
        TestArrays.output(array1);
        // 比较数组元素是否相等
        System.out.println("比较数组元素是否相等:Arrays.equals(array, array1):" + "\n" + Arrays.equals(array, array1));
        int[] array2 = array1.clone();
        System.out.println("克隆后数组元素是否相等:Arrays.equals(array1, array2):" + "\n" + Arrays.equals(array1, array2));
        // 使用二分搜索算法查找指定元素所在的下标（必须是排序好的，否则结果不正确）
        Arrays.sort(array1);
        System.out.println("元素3在array1中的位置：Arrays.binarySearch(array1, 3)：" + "\n" + Arrays.binarySearch(array1, 3));
        // 如果不存在就返回负数
        System.out.println("元素9在array1中的位置：Arrays.binarySearch(array1, 9)：" + "\n" + Arrays.binarySearch(array1, 9));
    }
}

/**
 * 数组容量如果不够用可以使用 Arrays.copyOf() 进行扩容：
 * Array.copy(E[] e,newLength);
 * 其第一个形参指的是需要扩容的数组，后面是扩容后的大小，其内部实现其实是使用了 System.arrayCopy();
 * 在内部重新创建一个长度为 newLength 类型是 E 的数组。
 * */
class CopyMain {
    public static void main(String[] args) {
        int[] a= {10,20,30,40,50};
        a= Arrays.copyOf(a,a.length+1);
        for (int value : a) {
            // 10 20 30 40 50 0
            System.out.println(value);
        }
    }
}

/*深入认识Java数组*/
/**
 * 在我印象中的数组是应该这样的：通过new关键字创建并组装他们，通过使用整形索引值访问它的元素，并且它的尺寸是不可变的！
 * 但是这只是数组的最表面的东西！深一点？就是这样：数组是一个简单的复合数据类型，它是一系列有序数据的集合，
 * 它当中的每一个数据都具有相同的数据类型，我们通过数组名加上一个不会越界下标值来唯一确定数组中的元素。
 * 还有更深的，那就是数组是一个特殊的对象！！
 * */

class DeepIntoList {
    public static void main(String[] args) {
        int[] list = new int[10];
        System.out.println("array的父类是：" + list.getClass().getSuperclass());
        System.out.println("array的类名是：" + list.getClass().getName());
        // list的父类是：class java.lang.Object
        // list的类名是：[I
        // 数组是Object的直接子类,它属于“第一类对象”，但是它又与普通的java对象存在很大的不同，
        // 从它的类名就可以看出：[I，这是什么东东？？在JDK中我就没有找到这个类，话说这个"[I”都不是一个合法标识符。怎么定义成类啊？
        // 所以我认为SUM那帮天才肯定对数组的底层肯定做了特殊的处理。

        int[] array_00 = new int[10];
        System.out.println("一维数组：" + array_00.getClass().getName());
        int[][] array_01 = new int[10][10];
        System.out.println("二维数组：" + array_01.getClass().getName());
        int[][][] array_02 = new int[10][10][10];
        System.out.println("三维数组：" + array_02.getClass().getName());
        // 一维数组：[I
        // 二维数组：[[I
        // 三维数组：[[[I
        // 通过这个实例我们知道：[代表了数组的维度，一个[表示一维，两个[表示二维。可以简单的说数组的类名由若干个'['和数组元素类型的内部名称组成

        System.out.println("Object[]:" + Object[].class);
        System.out.println("Object[][]:" + Object[][].class);
        System.err.println("Object[][][]:" + Object[][][].class);
        System.out.println("Object:" + Object.class);
        // Object[]:class [Ljava.lang.Object;
        // Object[][]:class [[Ljava.lang.Object;
        // Object[][][]:class [[[Ljava.lang.Object;
        // Object:class java.lang.Object
        // 从这个实例我们可以看出数组的“庐山真面目”。同时也可以看出数组和普通的Java类是不同的，
        // 普通的java类是以全限定路径名+类名来作为自己的唯一标示的，而数组则是以若干个[+L+数组元素类全限定路径+类来最为唯一标示的。
        // 这个不同也许在某种程度上说明了数组也普通java类在实现上存在很大的区别，也许可以利用这个区别来使得JVM在处理数组和普通java类时作出区分。

        int[] array = new int[10];
        Class clazz = array.getClass();
        System.out.println(clazz.getDeclaredFields().length);
        System.out.println(clazz.getDeclaredMethods().length);
        System.out.println(clazz.getDeclaredConstructors().length);
        System.out.println(clazz.getDeclaredAnnotations().length);
        System.out.println(clazz.getDeclaredClasses().length);
        // 从这个运行结果可以看出，我们亲爱的[I没有生命任何成员变量、成员方法、构造函数、Annotation甚至连length成员变量这个都没有，
        // 它就是一个彻彻底底的空类。没有声明length，那么我们array.length时，编译器怎么不会报错呢？
        // 确实，数组的length是一个非常特殊的成员变量。我们知道数组的是Object的直接之类，但是Object是没有length这个成员变量的，
        // 那么length应该是数组的成员变量，但是从上面的示例中，我们发现数组根本就没有任何成员变量，这两者不是相互矛盾么？

        // 字节码中我们还是没有看到length这个成员变量，但是看到了这个:arraylength ,这条指令是用来获取数组的长度的，
        // 所以说JVM对数组的长度做了特殊的处理，它是通过arraylength这条指令来实现的。

    }
}
