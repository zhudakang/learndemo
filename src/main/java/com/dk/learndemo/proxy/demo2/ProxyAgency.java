package com.dk.learndemo.proxy.demo2;

/**
 * @Author : zhudakang
 * @Description : ProxyAgency 代理中介类
 * @Date : 2019/8/1
 */
public class ProxyAgency implements IFindWork {

    IFindWork target;

    /**
     * 构造函数
     * */
    public ProxyAgency(IFindWork target) {
        this.target = target;
    }

    @Override
    public void sendResume(String resume) {
        target.sendResume(resume);
    }

    @Override
    public void inviteInterview() {
        target.inviteInterview();
    }
}
