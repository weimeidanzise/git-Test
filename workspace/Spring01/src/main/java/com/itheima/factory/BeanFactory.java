package com.itheima.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties pro;
    private static Map<String, Object> beans;

    static {
        try {
            pro = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            pro.load(in);

            beans = new HashMap<String, Object>();
            Enumeration<Object> keys = pro.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = pro.getProperty(key);
                //创建反射对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);

            }
        } catch (Exception e) {


        }
    }

    /*
     * 根据bean名称获取对象*/
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }
}
