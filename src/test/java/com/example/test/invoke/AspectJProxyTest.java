package com.example.test.invoke;

import com.example.test.invoke.NativeWaiter;
import com.example.test.invoke.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/13
 */
public class AspectJProxyTest {

    @Test
    public void test(){
        Waiter target = new NativeWaiter();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        //设置目标对象
        proxyFactory.setTarget(target);
        //添加切面类
        proxyFactory.addAspect(com.example.test.aop.PreGreetAspect.class);
        //生成织入切面的代理对象
        Waiter proxy = proxyFactory.getProxy();

        proxy.greetTo("Jonn");
        proxy.serveTo("Jonn");
    }


}
