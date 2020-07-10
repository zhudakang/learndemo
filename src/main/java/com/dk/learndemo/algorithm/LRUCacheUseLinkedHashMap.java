package com.dk.learndemo.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :zhudakang
 * @description : LRUCacheUseLinkedHashMap
 * @create : 2020/07/10
 */
public class LRUCacheUseLinkedHashMap extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheUseLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        /**
         * getOrDefault
         * 这个方法是什么意思？
         * Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
         * */
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        //直接put
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        //通过覆盖这个方法，加入一定的条件，满足条件返回true。
        // 当put进新的值方法返回true时，便移除该map中最老的键和值。
        return size() > capacity;
    }
}
