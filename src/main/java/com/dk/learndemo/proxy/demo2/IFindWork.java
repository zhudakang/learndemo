package com.dk.learndemo.proxy.demo2;

/**
 * @Author : zhudakang
 * @Description : FindWork interface
 * @Date : 2019/7/31
 */
public interface IFindWork {

    /**
     * 发送简历
     * */
    void  sendResume(String resume);

    /**
     * 邀请面试
     * */
    void  inviteInterview();

}
