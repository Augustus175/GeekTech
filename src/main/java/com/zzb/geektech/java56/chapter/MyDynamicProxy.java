package com.zzb.geektech.java56.chapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello! ");
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("Invoking sayHello");
        Object result = null;
        try {
            result = method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;

    }
}

public class MyDynamicProxy {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        Hello proxyHello = (Hello) Proxy.newProxyInstance(Hello.class.getClassLoader()
                , HelloImpl.class.getInterfaces(), handler);
        proxyHello.sayHello();
    }
}
