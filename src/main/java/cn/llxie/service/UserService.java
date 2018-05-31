package cn.llxie.service;

import cn.llxie.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

    User findUserById(Long id);
}
