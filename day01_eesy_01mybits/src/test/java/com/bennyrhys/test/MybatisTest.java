package com.bennyrhys.test;

import com.bennyrhys.bean.User;
import com.bennyrhys.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 测试1，获取数据库数据test输出
 * 输出
 * User{id=41, username='老王', birthday=Wed Feb 28 01:47:08 CST 2018, sex='男', address='北京'}
 * User{id=42, username='小二王', birthday=Fri Mar 02 23:09:37 CST 2018, sex='女', address='北京金燕龙'}
 * User{id=43, username='小二王', birthday=Sun Mar 04 19:34:34 CST 2018, sex='女', address='北京金燕龙'}
 * User{id=45, username='bennyrhys', birthday=Sun Mar 04 20:04:06 CST 2018, sex='男', address='北京金燕龙'}
 * User{id=46, username='老王', birthday=Thu Mar 08 01:37:26 CST 2018, sex='男', address='北京'}
 * User{id=48, username='小马宝莉', birthday=Thu Mar 08 19:44:00 CST 2018, sex='女', address='北京修正'}
 */
public class MybatisTest  {
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3、使用工厂生产的SqlSession对象
        SqlSession session = factory.openSession();
        //4、使用SqlSession创建Dao的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5、使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user:users) {
            System.out.println(user);
        }
        //6、释放资源
        session.close();
        in.close();
    }
}
