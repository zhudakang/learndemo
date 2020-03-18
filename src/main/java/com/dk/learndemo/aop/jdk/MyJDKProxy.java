package com.dk.learndemo.aop.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author :zhudakang
 * @description : MyJDKProxy
 *                 要求被代理的类必须实现一个接口，核心是InvocationHandler接口和Proxy类
 * @create : 2020/03/18
 */
public class MyJDKProxy implements InvocationHandler {

    //需要被代理的目标对象
    private Object proxyObject;

    /**
     *
     * 通过invoke来进行的动态代理
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(proxyObject, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    private Object getProxyInstance(Object targetObject) {
        //为目标对象target赋值
        this.proxyObject = targetObject;
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
                , targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        //实例化JDKProxy对象
        MyJDKProxy myJDKProxy = new MyJDKProxy();
        //获取代理对象
        UserService userService = (UserService)myJDKProxy.getProxyInstance(new UserServiceImpl());
        userService.delUser("hehe");
    }
}
