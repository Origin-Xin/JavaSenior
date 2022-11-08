package com.atguigu.exer1;

import java.util.List;

/**
 *
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方
 * 法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试
 *
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/31 10:04
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao=new DAO<User>();
        dao.save("1001",new User(1001,18,"张三"));
        dao.save("1002",new User(1002,18,"李四"));
        dao.save("1003",new User(1002,18,"王五"));

        dao.update("1003",new User(1003,20,"老六"));

        List<User> list = dao.list();
        System.out.println(list);
    }
}
