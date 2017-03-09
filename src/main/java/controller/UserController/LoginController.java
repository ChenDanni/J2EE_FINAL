package controller.UserController;

import dao.CardDAO;
import model.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserManagerService;
import service.impl.UserManagerServiceImpl;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/8.
 */
@Controller
public class LoginController {
    @Autowired
    UserManagerService userManagerService;
    @Autowired
    CardDAO cardDAO;


    @RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
    public String getMemberLogin() {
        return "member/memberLogin";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.GET)
    public String getHome() {
        return "member/classList";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.POST)
    public String handleLogin(@RequestParam("cardId") int cardId,
                              @RequestParam("password") String pwd, HttpSession session, ModelMap model) {

        CardEntity card = cardDAO.findOne(cardId);
        if (card == null){
            System.err.println("用户名不存在");
            return "member/memberLogin";
        }else {
            if (card.getPassword().equals(pwd)){
                session.setAttribute("cardId",cardId);
                session.setAttribute("username",card.getName());
                model.addAttribute("username",card.getName());
                return "member/classList";
            }else {
                System.err.println("密码错误");
                return "member/classList";
            }
        }

    }

}
