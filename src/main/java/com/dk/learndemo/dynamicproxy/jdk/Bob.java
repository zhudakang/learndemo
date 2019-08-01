package com.dk.learndemo.dynamicproxy.jdk;

import com.dk.learndemo.proxy.demo2.IFindWork;

/**
 * @Author : zhudakang
 * @Description : Bob 也想找工作
 * @Date : 2019/8/1
 */
public class Bob implements IFindWork {

    @Override
    public void sendResume(String resume) {
        System.out.println("bob发送了简历，简历内容如下：" + resume);
    }

    @Override
    public void inviteInterview() {
        System.out.println("bob收到了面试邀请");
    }


}
