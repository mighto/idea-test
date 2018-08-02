package com.example.test.invoke;

/**
 * @author mistaker
 * @description：
 * @create 2018/03/01
 */
public class NativeWaiter implements Waiter {


    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to " + name + "...");
    }
}
