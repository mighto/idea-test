package com.example.test.cache;

import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;


/**
 * 简单的缓存服务，适用于需要手工控制的缓存场景
 * @author mistaker
 * @description：
 * @create 2018/06/01
 */
@Service
public class CacheService {

    static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    CacheManager cacheManager;

    public Cache getCache(String cacheName){
        Preconditions.checkArgument(StringUtils.isNotBlank(cacheName));
        return cacheManager.getCache(cacheName);
    }

    public <K,V> V get(String cacheName, K key){
        Preconditions.checkArgument(key != null);
        Cache cache = getCache(cacheName);
        Cache.ValueWrapper valueWrapper = cache.get(key);
        if(valueWrapper != null){
            return (V) valueWrapper.get();
        }else{
            return null;
        }
    }

    public <K,V> V get(String cacheName, K key, ValueLoader<K, V> valueLoader){
        V value = get(cacheName, key);
        if(value != null) {
            return value;
        }
        synchronized (CacheService.class){
            value = get(cacheName, key);
            if(value != null){
                return value;
            }
            logger.info("load value for cache: {}, key: {}", cacheName, key);
            value = valueLoader.load(key);
            Cache cache = getCache(cacheName);
            cache.put(key, value);
            return value;
        }
    }

    public <K,V> void put(String cacheName, K key, V value){
        Cache cache = getCache(cacheName);
        cache.put(key, value);
    }

    public void clear(String cacheName){
        logger.info("clear cache: {}", cacheName);
        Cache cache = getCache(cacheName);
        cache.clear();
    }

    public <K> void evict(String cacheName, K key){
        Preconditions.checkArgument(key != null);
        logger.info("evict cache: {}, key: {}", cacheName, key);
        Cache cache = getCache(cacheName);
        cache.evict(key);
    }

    public CacheManager getCacheManager(){
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

}
