package cn.smbms.test.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /*@Test
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
            logger.info("testGetUserList userCode: "
                    + userResult.getUserCode() + " and userName: "
                    + userResult.getUserName() + " and userRole: "
                    + userResult.getUserRole() + " and userRoleName: "
                    + userResult.getUserRoleName() + " and address: "
                    + userResult.getAddress());
        }
    }*/

    @Test
    public void testAddNewUser() throws ParseException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        
        User user = new User();
        user.setUserCode("test002");
        user.setUserName("测试用户002");
        user.setUserPassword("1234567");
        Date birthday =new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
        user.setBirthday(birthday);
        user.setCreationDate(new Date());
        user.setAddress("地址测试");
        user.setGender(1);
        user.setPhone("13688783697");
        user.setUserRole(1);
        user.setCreatedBy(1);
        user.setCreationDate(new Date());

        boolean result = userService.addNewUser(user);

        logger.info("testAdd result : " + result);
    }
}
