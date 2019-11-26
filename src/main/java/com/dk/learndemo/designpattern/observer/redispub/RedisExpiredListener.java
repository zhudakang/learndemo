package com.dk.learndemo.designpattern.observer.redispub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @Description : RedisExpiredListener
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
@Slf4j
@Component
public class RedisExpiredListener implements MessageListener {

    /**
     * 客户端监听订阅的topic，当有消息的时候，会触发该方法;
     * 并不能得到value, 只能得到key。
     * 姑且理解为: redis服务在key失效时(或失效后)通知到java服务某个key失效了, 那么在java中不可能得到这个redis-key对应的redis-value。
     * * 解决方案:
     * 创建copy/shadow key, 例如 set vkey "vergilyn"; 对应copykey: set copykey:vkey "" ex 10;
     * 真正的key是"vkey"(业务中使用), 失效触发key是"copykey:vkey"(其value为空字符为了减少内存空间消耗)。
     * 当"copykey:vkey"触发失效时, 从"vkey"得到失效时的值, 并在逻辑处理完后"del vkey"
     * <p>
     * 缺陷:
     * 1: 存在多余的key; (copykey/shadowkey)
     * 2: 不严谨, 假设copykey在 12:00:00失效, 通知在12:10:00收到, 这间隔的10min内程序修改了key, 得到的并不是 失效时的value.
     * (第1点影响不大; 第2点貌似redis本身的Pub/Sub就不是严谨的, 失效后还存在value的修改, 应该在设计/逻辑上杜绝)
     * 当"copykey:vkey"触发失效时, 从"vkey"得到失效时的值, 并在逻辑处理完后"del vkey"
     *
     * TIPS: 实际上onMessage并没有显示的被调用，而是通过监听发现了失效，然后去做这个key失效之后的事情
     *        无所谓key名是什么，在我们的业务场景里面，key过期就通知一下。
     *        然后到具体的service中然后再去判断是否equals那个key，然后做对应的操作。
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        // 建议使用: valueSerializer
        byte[] body = message.getBody();
//        byte[] channel = message.getChannel();
//        System.out.print("onMessage >> ");
//        System.out.println(String.format("channel: %s, body: %s, bytes: %s", new String(channel), new String(body), new String(bytes)));
        String key = new String(body);
        /** 因实现监听就无法注入对象，所以所有操作都写在 RedisListenerService  */
        RedisListenerService redisListenerService = SpringContextHolder.getBean("redisListenerServiceImpl");
        redisListenerService.clearUserCache(key);
        redisListenerService.releaseOrder(key);
    }

}
