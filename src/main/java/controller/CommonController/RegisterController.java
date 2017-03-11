package controller.CommonController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CardService;

/**
 * Created by cdn on 17/3/11.
 */
@Controller
public class RegisterController {

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("phone") String phone,
                           @RequestParam("password") String pwd,
                           @RequestParam("pwd_again") String pwd_again,
                           ModelMap model) {

        if (!pwd.equals(pwd_again)){
            model.addAttribute("message","两次输入密码不相同");
            return "register";
        }

        int cardId = cardService.register(username,phone,pwd);
        model.addAttribute("cardId",cardId);

        return "registerSuccess";
    }
}
