package com.dk.learndemo.meet.design;

import java.io.*;

/**
 * @author :zhudakang
 * @description : SerEnumSingleton
 * @create : 2020/08/06
 */
public enum SerEnumSingleton implements Serializable {

    INSTANCE;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private SerEnumSingleton() {
    }

    /**
     *   枚举类是JDK1.5才出现的，那之前的程序员面对反射攻击和序列化问题是怎么解决的呢？
     *   其实就是像Enum源码那样解决的，只是现在可以用enum可以使我们代码量变的极其简洁了。
     *   至此，相信同学们应该能明白了为什么Joshua Bloch说的“单元素的枚举类型已经成为实现Singleton的最佳方法”了吧，
     *   也算解决了我自己的困惑。既然能解决这些问题，还能使代码量变的极其简洁，那我们就有理由选枚举单例模式了。
     *   对了，解决序列化问题，要先懂transient和readObject
     * */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerEnumSingleton s = SerEnumSingleton.INSTANCE;
        s.setContent("枚举单例序列化");
        System.out.println("枚举序列化前读取其中的内容：" + s.getContent());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerEnumSingleton.obj"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("SerEnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerEnumSingleton s1 = (SerEnumSingleton) ois.readObject();
        ois.close();
        System.out.println(s + "\n" + s1);
        System.out.println("枚举序列化后读取其中的内容：" + s1.getContent());
        System.out.println("枚举序列化前后两个是否同一个：" + (s == s1));
    }
}
