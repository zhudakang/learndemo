package com.dk.learndemo.proxy.demo2;

/**
 * @Author : zhudakang
 * @Description : Peter want to find work
 * @Date : 2019/8/1
 */
public class Peter implements IFindWork {


    @Override
    public void sendResume(String resume) {
        System.out.println("peter类发送了简历，简历内容如下：" + resume);
    }

    @Override
    public void inviteInterview() {
        System.out.println("peter类收到了面试邀请");
    }

}
