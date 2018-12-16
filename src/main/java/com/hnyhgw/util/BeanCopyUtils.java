/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hnyhgw.util;

import net.sf.cglib.beans.BeanCopier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BeanCopyUtils {


    public static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<String,BeanCopier>();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     * copy对象属性，从source拷贝到target
     * @param source
     * @param target
     * @return
     * @exception
     */
    public static void copyProperties(Object source,Object target){
        String beanKey = generateKey(source.getClass(),target.getClass());
        BeanCopier copier = null;
        reentrantReadWriteLock.readLock().lock();
        try{
            if (!beanCopierMap.containsKey(beanKey)) {
                copier = BeanCopier.create(source.getClass(), target.getClass(), false);
                beanCopierMap.put(beanKey, copier);
            }else {
                copier = beanCopierMap.get(beanKey);
            }
            copier.copy(source, target, null);
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    private static String generateKey(Class<?>class1,Class<?>class2){
        return class1.toString() + class2.toString();
    }
}
