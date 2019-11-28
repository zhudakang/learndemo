package com.dk.learndemo.designpattern.adapter.objectadapter;

import com.dk.learndemo.designpattern.adapter.clazzadapter.Adaptee;
import com.dk.learndemo.designpattern.adapter.clazzadapter.Target;

/**
 * @Description : ObjectAdapterTest
 * @Date : 2019/11/28
 * @Author : zhudakang
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        //这种方式先创建一个适配者
        Adaptee adaptee = new Adaptee();
        //然后将适配者通过ObjectAdapter转换成目标对象
        //ObjectAdapter 中有一个属性是adaptee
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
