package com.dk.learndemo.meet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhudakang
 * @description : TryCatchFinally
 * @create : 2020/08/05
 */
public class TryCatchFinally {

    /**
     * try:2
     * finally:3
     */
    public static int testReturn1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    /**
     * try:[1]
     * finally:[1, 3]
     */
    public static List<Integer> testReturn2() {
        List<Integer> list = new ArrayList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("finally:" + list);
        }
        return list;
    }

    /**
     * 这个时候是在return最后返回 不过在返回之前会走一下finally
     */
    public static int testReturn3() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }

    /**
     * 当finally中有return的时候，try中的return会失效，在执行完finally的return之后，就不会再执行try中的return。
     * 这种写法，编译是可以编译通过的，但是编译器会给予警告，所以不推荐在finally中写return，这会破坏程序的完整性，
     * 而且一旦finally里出现异常，会导致catch中的异常被覆盖。
     */
    public static int testReturn4() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return i;
        }
    }

    /**
     * 如果这样写，就是catch不到异常的
     * */
    public static int testReturn5() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            i = i/0;
            return i;
        }
    }

    public static void main(String[] args) {
//        testReturn1();
//        testReturn2();
//        testReturn3();
        testReturn4();
//        testReturn5();
    }
}
