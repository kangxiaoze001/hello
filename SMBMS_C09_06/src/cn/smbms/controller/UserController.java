package cn.smbms.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController{
	private Logger logger = Logger.getLogger(UserController.class);
	@RequestMapping({"/welcome","/"})
	public String welcome(String username){
		logger.info("welcome, username:" + username);
		return "index";
	}
}
