package com.atguigu.exer1;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个 Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * public T get(String id)：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换 map 中 key 为 id 的内容,改为 entity 对象
 * public List<T> list()：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象定义一个 User 类：
 * 该类包含：private 成员变量（int 类型） id，age；（String 类型）name。
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试
 *
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/30 21:07
 */
public class DAO<T> {
    private Map<String, T> map=new HashMap<String,T>();

    //： 保存 T 类型的对象到 Map 成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    //从 map 中获取 id 对应的对象
    public T get(String id) {
       return map.get(id);
    }
    //替换 map 中 key 为 id 的内容,改为 entity 对象
    public void update(String id,T entity){
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }
    //：返回 map 中存放的所有 T 对象
    public List<T> list(){
        //错误的：
//        Collection<T> value=map.values();
//        return (List<T>) value;
        //正确的
        ArrayList list=new ArrayList();
        Collection<T> value=map.values();
        for (T t:value){
            list.add(value);
        }
        return list;
    }
    //删除指定 id 对象定义一个 User 类：
    public void delete(String id){
        map.remove(id);
    }
}
