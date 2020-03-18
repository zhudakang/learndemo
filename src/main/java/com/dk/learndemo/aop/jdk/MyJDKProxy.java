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

    public MyJDKProxy() {
    }

    public MyJDKProxy(Object proxyObject) {
        this.proxyObject = proxyObject;
    }

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
        MyJDKProxy myJDKProxy = new MyJDKProxy(targetObject);

        /*JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        第二个参数 是我们提供给代理对象的接口，那么我们这个代理对象就会去实现这个接口，
        这种情况下，我们当然可以将这个代理对象强制转化成提供的接口类型。*/
        //这边的This指代proxyObject,可以用myJDKProxy来代替
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
                , targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        //实例化JDKProxy对象
        MyJDKProxy myJDKProxy = new MyJDKProxy();
        //获取代理对象
        //使用的是实现类来获得代理
        UserService userService = (UserService)myJDKProxy.getProxyInstance(new UserServiceImpl());
        userService.delUser("hehe");
    }
}
