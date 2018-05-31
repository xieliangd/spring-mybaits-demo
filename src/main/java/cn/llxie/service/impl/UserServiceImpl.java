package cn.llxie.service.impl;

import cn.llxie.domain.User;
import cn.llxie.mapper.UserMapper;
import cn.llxie.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper dao;

    @Override
    public int addUser(User user) {
        return dao.addUser(user);
    }


    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = dao.findAllUser();
        PageInfo result = new PageInfo(userDomains);
        return result;
    }

    @Override
    public User findUserById(Long id) {
        return dao.findUserById(id);
    }
}
