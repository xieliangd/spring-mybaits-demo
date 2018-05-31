package cn.llxie.dao;

import cn.llxie.domain.User;

import java.util.List;

/*
* xml模式配置
* */

public interface UserDao {

    int addUser(User user);

    List<User> findAllUser();

    User findUserById(Long id);
}
