package com.example.test.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/21
 */
public class CacheManagerByCust<T> {

    private Map<String, T> cache = new ConcurrentHashMap<String, T>();

    public T getValue(Object key){
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value){
        cache.put(key, value);
    }

    /**
     * 根据key来删除缓存中的一条记录
     * @param key
     */
    public void evictCache(String key){
        if(cache.containsKey(key)){
            cache.remove(key);
        }
    }

    /**
     * 清空缓存中的记录
     */
    public void evictCache(){
        cache.clear();
    }

}
