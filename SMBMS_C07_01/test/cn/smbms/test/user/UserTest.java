package cn.smbms.test.user;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;

public class UserTest {

    private Logger logger = Logger.getLogger(UserTest.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetUserList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        List<User> userList = new ArrayList<User>();
        User userCondition = new User();
        userCondition.setUserName("赵");
        userCondition.setUserRole(3);
        userList = userService.findUsersWithConditions(userCondition);

        for (User userResult : userList) {
            logger.debug("testGetUserList userCode: "
                    + userResult.getUserCode() + " and userName: "
                    + userResult.getUserName() + " and userRole: "
                    + userResult.getUserRole() + " and userRoleName: "
                    + userResult.getUserRoleName() + " and address: "
                    + userResult.getAddress());
        }
    }

}
