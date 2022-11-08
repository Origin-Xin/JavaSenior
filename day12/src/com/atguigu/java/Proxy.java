package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/10/7 10:06
 */
public class Proxy {
    interface Human{
        String getBelief();
        void eat(String food);
    }
    //被代理类
    class SuperMan implements com.atguigu.java.Human {

        @Override
        public String getBelief() {
            return "I believe I can fly";
        }

        @Override
        public void eat(String food) {
            System.out.println("我喜欢吃"+food);
        }

    }
    //代理类
class ProxyFactory{
    public Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}
}
