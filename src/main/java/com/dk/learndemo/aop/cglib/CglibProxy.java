package com.dk.learndemo.aop.cglib;


import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author :zhudakang
 * @description : CglibProxy
 *                 某个类被标记为final，那么它是无法使用CGLIB做动态代理的
 *                 Code Generation Library
 *                 CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，比使用Java反射效率要高。
 *                 唯一需要注意的是，CGLib不能对声明为final的方法进行代理，因为CGLib原理是动态生成被代理类的子类。
 *                 (也就是通过继承去实现代理类，目标类变成final，无法继承)
 *                 感谢博客：https://blog.csdn.net/bicheng4769/article/details/80030266

 *                 JDK动态代理要比cglib代理执行速度快，但性能不如cglib好
 * @create : 2020/03/18
 */
public class CglibProxy implements MethodInterceptor {

    private Object proxyObject;

    /**
     * 通过intercept来进行的动态代理
     * */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGlib动态代理，监听开始！");
        Object result = method.invoke(proxyObject, objects);
        System.out.println("CGlib动态代理，监听结束！");
        return result;
    }

    private Object getCglibProxy(Object objectTarget){
        this.proxyObject = objectTarget;
        Enhancer enhancer = new Enhancer();
        //设置父类,因为Cglib是针对指定的类生成一个子类，所以需要指定父类
        enhancer.setSuperclass(objectTarget.getClass());
        enhancer.setCallback(this);
        //创建并返回代理对象
        return enhancer.create();
    }

    public static void main(String[] args) {
        //实例化CglibProxy对象
        CglibProxy cglib = new CglibProxy();
        //获取代理对象
        AgentServiceImpl agentService =  (AgentServiceImpl) cglib.getCglibProxy(new AgentServiceImpl());
        agentService.addAgent("小狗");
    }
}


