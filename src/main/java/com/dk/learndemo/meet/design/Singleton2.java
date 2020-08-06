package com.dk.learndemo.meet.design;

import java.io.*;

/**
 * @author :zhudakang
 * @description : Singleton2
 * Serializable 不实现这个接口进行序列化会报错的。
 * 饿汉形式
 * @create : 2020/08/06
 */
public class Singleton2 implements Serializable {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private static Singleton2 instance = new Singleton2();

    //私有构造器
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }

    /**
     *
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Singleton2 s = Singleton2.getInstance();
//        s.setContent("懒汉单例序列化");
//        System.out.println("懒汉单例序列化前读取其中的内容：" + s.getContent());
//
//        ByteArrayOutputStream bout = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bout);
//        oos.writeObject(s);
//        oos.flush();
//        oos.close();
//
//        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout
//                .toByteArray()));
//        Singleton2 s1 = (Singleton2) in2.readObject();
//        in2.close();
//        System.out.println(s + "\n" + s1);
//        System.out.println("懒汉单例序列化后读取其中的内容：" + s1.getContent());
//        System.out.println("懒汉单例序列化前后两个是否同一个：" + (s == s1));

        Singleton2 s = Singleton2.getInstance();
        s.setContent("枚举单例序列化");
        System.out.println("枚举序列化前读取其中的内容：" + s.getContent());
        //new FileOutputStream("Singleton2.obj") 相当于new File("叫啥都行")
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Singleton2.obj"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("Singleton2.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton2 s1 = (Singleton2) ois.readObject();
        ois.close();
        System.out.println(s + "\n" + s1);
        System.out.println("枚举序列化后读取其中的内容：" + s1.getContent());
        System.out.println("枚举序列化前后两个是否同一个：" + (s == s1));
    }
}
