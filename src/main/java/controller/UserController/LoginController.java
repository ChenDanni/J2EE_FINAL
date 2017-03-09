package controller.UserController;

import dao.CardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserManagerService;
import service.impl.UserManagerServiceImpl;

/**
 * Created by cdn on 17/3/8.
 */
@Controller
public class LoginController {
    @Autowired
    UserManagerService userManagerService;


    @RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
    public String getMemberLogin() {
        return "member/memberLogin";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.GET)
    public String getHome() {
        return "member/classList";
    }





}
