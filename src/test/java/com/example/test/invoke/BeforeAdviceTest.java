package com.example.test.invoke;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/01
 */
public class BeforeAdviceTest {

    @Test
    public void before(){
        Waiter target = new NativeWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        //Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        //设置代理目标
        pf.setTarget(target);

        //为代理目标添加增强
        pf.addAdvice(advice);

        //生成代理实例
        Waiter proxy =(Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tome");

    }


}
