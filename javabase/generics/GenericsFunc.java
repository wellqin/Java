package javabase.generics;

/**
 * @Author: Wellqin
 * @Date: 2020/7/20 1:02
 */

public class GenericsFunc {
    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArray ){
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        // 传递一个整型数组
        printArray( intArray  );

        System.out.println( "\n双精度型数组元素为:" );
        // 传递一个双精度型数组
        printArray( doubleArray );

        System.out.println( "\n字符型数组元素为:" );
        // 传递一个字符型数组
        printArray( charArray );
    }
}
