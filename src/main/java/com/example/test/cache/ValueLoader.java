package com.example.test.cache;

/**
 * @author mistaker
 * @description：
 * @create 2018/06/01
 */
public interface ValueLoader<K, V> {
    V load(K key);
}
