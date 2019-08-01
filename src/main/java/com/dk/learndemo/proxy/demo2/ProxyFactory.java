package com.dk.learndemo.proxy.demo2;

/**
 * @Author : zhudakang
 * @Description : ProxyFactory 产生代理对象的静态工厂类
 * @Date : 2019/8/1
 */
public class ProxyFactory {

    public static IFindWork getProxy(){
        //使用这种静态代理的方式，其实就是在代码的编译的时期就知道代理关系了，比如这次代理的是peter的！
        return new ProxyAgency(new Peter());
    }

    public static void main(String[] args) {
        ProxyFactory.getProxy().sendResume("我叫peter！！！");
        ProxyFactory.getProxy().inviteInterview();
    }

}
