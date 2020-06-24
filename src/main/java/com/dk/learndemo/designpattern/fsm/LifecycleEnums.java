package com.dk.learndemo.designpattern.fsm;

/**
 * @Description : LifecycleEnums
 *                 这是一种状态模式的一种应用，使用在真实的业务场景里面。
 * @Date : 2019/10/31
 * @Author : zhudakang
 */
public enum LifecycleEnums {

    /**
     * <p>
     * 订单生命状态
     * </p>
     */
    LifecycleEnums_1(1, 3, 1),
    LifecycleEnums_2(2, 4, 1),
    LifecycleEnums_3(1, 5, 2),
    LifecycleEnums_4(2, 6, 2),
    ;

    private Integer oldLifeCycle;
    private Integer newLifeCycle;

    /**
     * 做一个判断
     * 1 = 提交的时候已经做了xxx操作
     * 2 = 提交的时候未进行xxx操作
     */
    private Integer type;

    LifecycleEnums(Integer oldLifeCycle, Integer newLifeCycle, Integer type) {
        this.oldLifeCycle = oldLifeCycle;
        this.newLifeCycle = newLifeCycle;
        this.type = type;
    }

    /**
     * 获得新的状态机
     * */
    public static int getNewLifeCycle(Integer oldLifeCycle, Integer type) {
        for (LifecycleEnums lifecycleEnums : LifecycleEnums.values()) {
            if (lifecycleEnums.getOldLifeCycle().equals(oldLifeCycle)
                    && lifecycleEnums.getType().equals(type)) {
                return lifecycleEnums.getNewLifeCycle();
            }
        }
        return 0;
    }

    public Integer getOldLifeCycle() {
        return oldLifeCycle;
    }

    public void setOldLifeCycle(Integer oldLifeCycle) {
        this.oldLifeCycle = oldLifeCycle;
    }

    public Integer getNewLifeCycle() {
        return newLifeCycle;
    }

    public void setNewLifeCycle(Integer newLifeCycle) {
        this.newLifeCycle = newLifeCycle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

