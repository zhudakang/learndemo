package com.dk.learndemo.designpattern.command.cooking;

/**
 * @Description : CookingCommand
 *                入口类
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class CookingCommand {

    /**
     * 这是从网上考出来的例子
     * 没啥大用 现在还在写JFrame太复古了
     **/
    public static void main(String[] args) {
        Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunTun();
        Breakfast food3 = new HeFen();
        Waiter fwy = new Waiter();
        fwy.setChangFen(food1);//设置肠粉菜单
        fwy.setHunTun(food2);  //设置河粉菜单
        fwy.setHeFen(food3);   //设置馄饨菜单
        fwy.chooseChangFen();  //选择肠粉
        fwy.chooseHeFen();     //选择河粉
        fwy.chooseHunTun();    //选择馄饨
    }
}
