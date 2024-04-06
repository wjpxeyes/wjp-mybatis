package com.wjp.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class MapperProxy<T> implements InvocationHandler {

    private Map<String, String> sqlSession;

    private Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 不对object的方法进行代理
        if (Object.class.equals(method.getDeclaringClass())) {
            // method.invoke(放入被代理对象, args)
            return method.invoke(this, args);
        }
        System.out.println("你被代理了：：" + sqlSession.get(mapperInterface.getName()));
        return null;
    }
}
