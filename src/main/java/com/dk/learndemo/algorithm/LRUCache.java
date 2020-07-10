package com.dk.learndemo.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :zhudakang
 * @description : LRUCache
 * @create : 2020/07/10
 */
public class LRUCache {

    /**
     时间复杂度：对于 put 和 get 都是 O(1)
     空间复杂度：O(capacity)，因为哈希表和双向链表最多存储 capacity+1 个元素。*/
    /**
     * 双向链表的结构
     * */
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    //缓存Map有点像手动实现一个LinkedHashMap
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    //size大小
    private int size;
    private int capacity;
    //注意定义头尾节点
    private DLinkedNode head, tail;

    /**
     * 初始化容量
     * */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        //初始化头尾节点
        head.next = tail;
        tail.prev = head;
    }

    /**
     * get key得到node，
     * 把node挪动到头结点
     * 并返回node value
     *
     * 只不过更改了node的位置
     * key对应的还是没变
     * */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * put key和value
     * value可以看做一个值
     * 但是把它扔到一个node里面
     * 很巧妙的是，他的node里面放了KEY 和value 那么就直接能知道它对应的key了根据node
     * */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        //node节点指向head 双向指针操作
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //如果get存在，那么应该对节点挪动到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
