package controller;

import org.springframework.stereotype.Controller;
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
        return "member/classList";
    }
    @RequestMapping(value = "/allCourses", method = RequestMethod.GET)
    public String getAllCourses() {
        return "member/allCourses";
    }
    @RequestMapping(value = "/allOrgs", method = RequestMethod.GET)
    public String getAllOrgs() {
        return "member/allOrgs";
    }

    @RequestMapping(value = "/learning", method = RequestMethod.GET)
    public String getStudying() {
        return "member/learning";
    }
    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String getBooking() {
        return "member/booking";
    }
    @RequestMapping(value = "/finishing", method = RequestMethod.GET)
    public String getFinishing() {
        return "member/finishing";
    }

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String getCard() {
        return "member/card";
    }
    @RequestMapping(value = "/cardStatistic", method = RequestMethod.GET)
    public String getCardStatistic() {
        return "member/cardStatistics";
    }





    @RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
    public String getMemberLogin() {
        return "memberLogin";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister() {
        return "register";
    }

    //充值
    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String getRecharge() {
        return "recharge";
    }

    @RequestMapping(value = "/mine", method = RequestMethod.GET)
    public String index() {
        return "mine";
    }

}