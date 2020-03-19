package com.dk.learndemo.designpattern.template;

/**
 * @author :zhudakang
 * @description : DodishTemplate
 *                 模板方法设计模式实例
 *                 很为常见，其实我们日常业务中也会用到。
 *                 比如核验身份证信息
 *                 1.上传图片 2. 调用数据源 3. 得到返回结果存储数据库并包装返回
 *                 那么也是一种模板模式，一个总体的方法，我们分别实现其中的内容。
 *                 比如父类中的上传图片，大家都是一样的，那么就没必要写多份了。
 *                 那么父类中的上传图片方法不是抽象的，可以直接用，那么每一家都可以只用实现那必要的数据源部分了~
 *                 优点：存在一种反向的控制结构，通过一个父类调用其子类的操作，通过子类对父类进行扩展增加新的行为，符合“开闭原则”OCP之前DI中有提到。
 *                 不足：每个不同的实现都需要定义一个子类，会导致类的个数增加，系统更加庞大。
 *
 *
 * @create : 2020/03/19
 */
public abstract class DayWorkTemplate {

    /**
     * 具体的整个过程
     */
    protected void process(){
        this.goToWork();
        this.working();
        this.getOffWork();
    }
    /**
     * 上班
     */
    public abstract void goToWork();
    /**
     * 工作中
     */
    public abstract void working();
    /**
     * 下班
     */
    public abstract void getOffWork ();


    public static void main(String[] args) {
        BobDayWork bobDayWork = new BobDayWork();
        bobDayWork.process();
        PeterDayWork peterDayWork = new PeterDayWork();
        peterDayWork.process();
    }
}
