package com.dk.learndemo.aop.cglib2;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.Method;

/**
 * @author :zhudakang
 * @description : CglibProxy
 * @create : 2020/03/18
 */
public class CglibProxy implements MethodInterceptor {


    private Object target;
    private Class clazz;

    /**
     * o 为代理的最终目标
     * clazz 是代理的目标的类型
     * */
    public CglibProxy(Object o, Class clazz) {
        this.target = o;
        this.clazz = clazz;
    }

    public Object getNewProxy() {
        Enhancer enhancer = new Enhancer();
        //要动态生成一个子类
        enhancer.setSuperclass(clazz);
        //通过回调指定代理类。
        enhancer.setCallback(CglibProxy.this);
        return enhancer.create();
    }

    /**
     * intercept [ˌɪntərˈsept] 拦截
     * */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("intercept方法invoke前");
        Object e = method.invoke(target, objects);
        System.out.println("intercept方法invoke后");
        return e;
    }

    public static void main(String[] args) {
        Work work = new Work();
        CglibProxy cglibProxy = new CglibProxy(work, Work.class);
        Work workProxy = (Work) cglibProxy.getNewProxy();
        workProxy.goToWork();
        workProxy.eatLunch();
        workProxy.getOffWork();
        //我们可以通过class来判断AOP是使用的哪种方式的代理。
        //class com.dk.learndemo.aop.cglib2.Work$$EnhancerByCGLIB$$b3dafa56
        System.out.println(workProxy.getClass());
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
    }
}
