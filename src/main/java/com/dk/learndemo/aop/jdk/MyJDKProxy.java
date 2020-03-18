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
     * 三个参数分别是代理实例、调用的方法、方法的参数列表。
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(proxyObject, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    /**
     *
     * 1. JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
     *  第二个参数 是我们提供给代理对象的接口，那么我们这个代理对象就会去实现这个接口，
     *  这种情况下，我们当然可以将这个代理对象强制转化成提供的接口类型。
     * 2. 这边的This指代proxyObject,可以用myJDKProxy来代替
     * 3. Proxy.newProxyInstance创建的代理对象是在JVM运行时动态生成的一个对象，这个对象不是我们知道的任何一个对象，
     *   而是运行时动态生成的，并且命名方式都是以$Proxy这种类型的。看运行结果也看出来 $Proxy0就是实际代理类。
     *   所以才是动态代理。
     *
     * */
    private Object getProxyInstance(Object targetObject) {
        //为目标对象target赋值
        this.proxyObject = targetObject;
        MyJDKProxy myJDKProxy = new MyJDKProxy(targetObject);

        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
                , targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        //实例化JDKProxy对象
        MyJDKProxy myJDKProxy = new MyJDKProxy();
        //获取代理对象，UserServiceImpl倒不如说是代理的最终生成的目标，动态代理会获取这个类所实现的接口，然后创建一个动态的类来实现这个接口
        UserService userService = (UserService)myJDKProxy.getProxyInstance(new UserServiceImpl());
        System.out.println("下面的方法才是调用的方法，应该通过invoke来实现的，所以上面的userService是相当于一个实现了UserService接口的代理类");
        //代理类调用方法会用到invoke
        userService.delUser("hehe");
        System.out.println(userService.getClass());
    }
}
