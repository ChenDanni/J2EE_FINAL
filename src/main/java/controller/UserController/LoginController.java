package controller.UserController;

import dao.CardDAO;
import dao.OrgDAO;
import model.CardEntity;
import model.OrganizationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserManagerService;
import service.impl.UserManagerServiceImpl;
import utility.IdHelper;

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
    @Autowired
    OrgDAO orgDAO;

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "member/memberLogin";
    }


    @RequestMapping(value = "/memberLogin", method = RequestMethod.GET)
    public String getMemberLogin() {
        return "member/memberLogin";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.GET)
    public String getHome() {
        return "member/classList";
    }

    @RequestMapping(value = "/memberHome", method = RequestMethod.POST)
    public String handleLogin(@RequestParam("cardId") int id,
                              @RequestParam("password") String pwd, HttpSession session, ModelMap model) {

        int idType = IdHelper.getIdType(id);
        System.err.println(idType);
        if (idType == 1){
            System.err.println("user login");
            CardEntity card = cardDAO.findOne(id);
            if (card == null){
                System.err.println("用户名不存在");
                return "member/memberLogin";
            }else {
                if (card.getPassword().equals(pwd)){
                    session.setAttribute("cardId",id);
                    session.setAttribute("name",card.getName());
                    model.addAttribute("name",card.getName());
                    return "member/classList";
                }else {
                    System.err.println("密码错误");
                    return "member/classList";
                }
            }
        } else if (idType == 2){
            System.err.println("org login");
            OrganizationEntity o = orgDAO.findOne(id);
            if (o == null){
                System.err.println("用户名不存在");
                return "member/memberLogin";
            }else {
                if (o.getPassword().equals(pwd)){
                    session.setAttribute("orgId",id);
                    session.setAttribute("name",o.getName());
                    model.addAttribute("name",o.getName());
                    return "redirect:/org_courses";
                }else {
                    System.err.println("密码错误");
                    return "member/classList";
                }
            }
        }else {
            return "member/memberLogin";
        }





    }

}
