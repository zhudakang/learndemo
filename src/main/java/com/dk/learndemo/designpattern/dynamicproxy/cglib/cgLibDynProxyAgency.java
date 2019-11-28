package com.dk.learndemo.designpattern.dynamicproxy.cglib;

import com.dk.learndemo.proxy.demo2.IFindWork;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author : zhudakang
 * @Description : cgLibDynProxyAgency
 * @Date : 2019/8/1
 */
public class cgLibDynProxyAgency implements MethodInterceptor {

    private static String methodName = "sendResume";

    /**
     * 对反射进行提前的拦截
     * */
    @Override
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        if (methodName.equals(method.getName())) {
            System.out.println("简历发送成功, 简历参数如下：" + Arrays.asList(params));
        }
        Object result = methodProxy.invokeSuper(o, params);
        return result;
    }

    public static void main(String[] args) {
        IFindWork cProxy= (IFindWork) CglibProxyFactory.getGcLibDynProxy(new Mary());
        cProxy.sendResume("简历内容如下~~#!#$%");
        cProxy.inviteInterview();
    }
}
