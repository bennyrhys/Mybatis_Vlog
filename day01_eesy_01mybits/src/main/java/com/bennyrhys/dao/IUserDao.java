package com.bennyrhys.dao;

import com.bennyrhys.bean.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有员工
     * @return
     */
    List<User> findAll();
}
