package com.example.test.invoke;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.AopProxy;

import java.lang.reflect.Method;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/01
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object obj) throws Throwable{
        String clientName = (String)args[0];
        System.out.println("How are you , Mr." + clientName + ".");

    }

}
