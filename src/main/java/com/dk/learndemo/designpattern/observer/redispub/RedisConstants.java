package com.dk.learndemo.designpattern.observer.redispub;

/**
 * @Description : RedisConstants
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class RedisConstants {
    /**
     * 质检订单锁定前缀
     * order_quality_audit_lock_ + id
     */
    public static final String ORDER_QUALITY_AUDIT_LOCK_ = "order_quality_audit_lock_";

    /**
     * 质检订单释放前缀
     */
    public static final String ORDER_QUALITY_AUDIT_RELEASE_ = "order_release_";

    /**
     * 用户token 的redis头
     * */
    public static final String TOKEN = "tokencache_";
    /**
     * app版本更新
     */
    public static final String APP_VERSION_UPDATE = "app_version_update";
}
