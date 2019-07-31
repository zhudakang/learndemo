package com.dk.learndemo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author : zhudakang
 * @Description :   接口IConvert的实现
 * 比如构造方法，它传参为String类型，返回值类型为AcceptMethod
 * 注解@FunctionalInterface保证了接口有且仅有一个抽象方法，所以JDK能准确地匹配到相应方法。
 * @Date : 2019/6/13
 *
 *
 */
public class AcceptMethod {


    public AcceptMethod() {
    }

    public AcceptMethod(String something){
        System.out.println(something);
    }

    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }


    public static void printValue(String str) {
        System.out.println("print value : " + str);
    }


    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d");
        //1
        al.forEach(x -> {
            AcceptMethod.printValue(x);
        });
        //2
        al.forEach(AcceptMethod::printValue);
        //3
        Consumer<String> methodParam = AcceptMethod::printValue; //support lambda
        al.forEach(x -> methodParam.accept(x));//方法执行accept

        IConvert<String, String> convert = AcceptMethod::startsWith;
        String converted = convert.convert("123");
        System.out.println(converted);

        AcceptMethod acceptMethod = new AcceptMethod();
        IConvert<String, String> converter = acceptMethod::endWith;
        System.out.println(converter.convert("Java"));

        IConvert<String, AcceptMethod> converter1 = AcceptMethod::new;
        AcceptMethod method = converter1.convert("print constructors");

        FunctionalSimple functionalSimple = message -> System.out.println("Hello " + message);
        functionalSimple.sayMessage("111");
    }
}
