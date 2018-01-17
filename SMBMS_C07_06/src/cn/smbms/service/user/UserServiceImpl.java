package cn.smbms.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired // @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findUsersWithConditions(User user) {
        try {
            return userMapper.getUserList(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public boolean addNewUser(User user) {
        boolean result = false;
        try {
            if (userMapper.add(user) == 1)
                result = true;
            // int i = 1 / 0;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
//    public UserMapper getUserMapper() {
//        return userMapper;
//    }
//
//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

}
