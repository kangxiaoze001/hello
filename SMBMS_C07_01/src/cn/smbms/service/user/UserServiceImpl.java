package cn.smbms.service.user;

import java.util.List;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public List<User> findUsersWithConditions(User user) {
        try {
            return userMapper.getUserList(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
