package com.dk.learndemo.meet;

/**
 * @author :zhudakang
 * @description : VolitaleTest
 * @create : 2020/08/11
 */
public class VolitaleTest {

    private int a = 0;
    private volatile boolean flag = false;

    public void writer() {
        a = 1;          //1
        flag = true;   //2
    }

    public void reader() {
        if (flag) {      //3
            int i = a; //4
        }
    }


    public static void main(String[] args) {
        VolitaleTest volitaleTest = new VolitaleTest();


        new Thread() {

            @Override
            public void run() {
                System.out.println("启动一个writter线程");//这里是线程需要做的事情
                volitaleTest.writer();
                System.out.println(volitaleTest.a);
                System.out.println(volitaleTest.flag);

            }
        }.start();


        new Thread() {

            @Override
            public void run() {
                System.out.println("启动一个reader线程");//这里是线程需要做的事情
                volitaleTest.reader();
                System.out.println(volitaleTest.a);
                System.out.println(volitaleTest.flag);

            }
        }.start();


    }


}

