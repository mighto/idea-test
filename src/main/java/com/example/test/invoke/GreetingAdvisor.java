package com.example.test.invoke;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/01
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    /**
     * 定义一个切面，实现在Waiter#greetTo()方法调用前织入一个增强。
     */


    //切点方法匹配规则：方法名为greetTo
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }

    //切点类匹配规则：为Waiter的类或子类
    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }


}
