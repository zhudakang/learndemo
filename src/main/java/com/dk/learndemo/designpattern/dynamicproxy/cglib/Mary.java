package com.dk.learndemo.designpattern.dynamicproxy.cglib;

import com.dk.learndemo.proxy.demo2.IFindWork;

/**
 * @Author : zhudakang
 * @Description : Mary
 * @Date : 2019/8/1
 */
public class Mary implements IFindWork {

    @Override
    public void sendResume(String resume) {
        System.out.println("Mary发送了简历，简历内容如下：" + resume);
    }

    @Override
    public void inviteInterview() {
        System.out.println("Mary收到了面试邀请");
    }
}
