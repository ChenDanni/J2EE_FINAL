package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 17/3/1.
 */

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getWelcome() {
        return "welcome";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.GET)
    public String getHome() {
        return "memberHome";
    }
    @RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
    public String getMemberLogin() {
        return "memberLogin";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister() {
        return "register";
    }
    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String index() {
        return "mine";
    }
}