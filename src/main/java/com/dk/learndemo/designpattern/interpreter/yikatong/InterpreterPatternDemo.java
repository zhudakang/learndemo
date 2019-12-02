package com.dk.learndemo.designpattern.interpreter.yikatong;

/**
 * @Description : InterpreterPatternDemo
 * @Date : 2019/12/2
 * @Author : zhudakang
 */
public class InterpreterPatternDemo {

    /**
     * 应用场景:
     * 当语言的文法较为简单，且执行效率不是关键问题时。
     * 当问题重复出现，且可以用一种简单的语言来进行表达时。
     * 当一个语言需要解释执行，并且语言中的句子可以表示为一个抽象语法树的时候，如 XML 文档解释。
     *
     * 注意：解释器模式在实际的软件开发中使用比较少，因为它会引起效率、性能以及维护等问题。
     * 如果碰到对表达式的解释，在 Java 中可以用 Expression4J 或 Jep 等来设计。
     *
     * */
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}
