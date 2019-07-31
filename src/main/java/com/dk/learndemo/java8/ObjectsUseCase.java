package com.dk.learndemo.java8;

import java.util.Objects;

/**
 * @Author : zhudakang
 * @Description : ObjectsUseCase
 * @Date : 2019/6/13
 */
public class ObjectsUseCase {

    /**
     * Objects is null
     **/
    public static void isNull() {
        String a = "a";
        String b = null;
        if (Objects.isNull(b)) {
            System.out.println("Use Objects judge b is null");
        }
//        if(b.equals(a)){
//            System.out.println("equals");
//        }
        if (Objects.equals(a, b)) {
            System.out.println("Objects.equals(a,b):" + "true");
        } else {
            System.out.println("Objects.equals(a,b):" + "false");
        }
    }


    public static void deepEquals() {
        String[] i1 = new String[]{"1", "2", "4"};
        String[] i2 = new String[]{"1", "2", "4"};
        String[] i3 = i2;
        if(i1.equals(i2)){
            System.out.println("Object.equals " + "true");
        }
        boolean a = Objects.equals(i1, i2);
        boolean b = Objects.deepEquals(i1, i2);
        boolean c = Objects.equals(i2, i3);
        System.out.println("a: " + a + " b: " + b + " c: " + c);
    }

    public static void deepEquals2() {
        Music music1 = new Music(1, "rapgod", "2019");
        Music music2 = new Music(1, "rapgod", "2019");
        if (music1 == music2) {
            System.out.println("==");
        }

        //==比较的是变量栈内存中存放的对象的（堆）中的内存地址，用来判断两个对象的地址是否相同，比较的是真正意义上的指针操作
        boolean a = music1.equals(music2);
        boolean b = Objects.deepEquals(music1, music2);
        System.out.println("a" + a + "b" + b);
    }

    public static void main(String[] args) {
//        isNull();
//        deepEquals();
        deepEquals2();
    }
}
