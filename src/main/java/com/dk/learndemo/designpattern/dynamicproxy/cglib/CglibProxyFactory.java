package com.dk.learndemo.designpattern.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author : zhudakang
 * @Description : CglibProxyFactory 动态代理工厂
 * @Date : 2019/8/1
 */
public class CglibProxyFactory {

    /**
     * Enhancer 是最核心的类
     * setSuperclass 设置产生的代理对象的父类 ----有什么用呢？
     * setCallback  设置CallBack接口的实例
     * setCallbacks 设置多个CallBack接口的实例
     * setCallbackFilter 设置方法回调过滤器
     * Object create() 使用默认无参数的构造函数创建目标对象
     * Object create(Class[], Object[]) 使用有参数的构造函数创建目标对象 参数Class[] 定义了参数的类型，第二个Object[]是参数的值
     */
    public static Object getGcLibDynProxy(Object target) {
        //Enhancer 是 cglib自带的实现类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        //所谓回调，因为之前定义了拦截器，所以这边CGLIB会回调MethodInterceptor接口方法拦截
        //有方法拦截可以去实现自己的代理逻辑
        //类似于JDK中的InvocationHandler接口
        enhancer.setCallback(new cgLibDynProxyAgency());
        Object targetProxy = enhancer.create();
        return targetProxy;
    }
}
