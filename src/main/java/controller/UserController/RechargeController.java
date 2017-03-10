package controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CardService;
import utility.CardHelper;
import vo.member.rechargeVO;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/10.
 */
@Controller
public class RechargeController {

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/recharge", method = RequestMethod.GET)
    public String getRecharge(HttpSession session, ModelMap model) {

        int cardId = -1;
        if (session.getAttribute("cardId") != null){
            cardId = (int)session.getAttribute("cardId");
        }
        rechargeVO vo = cardService.getRecharge(cardId);

        model.addAttribute("cardId",cardId);
        model.addAttribute("balance",vo.balance);
        model.addAttribute("accountId",vo.accountId);

        return "member/recharge";
    }
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public String addBalance(@RequestParam("rechargeNum") int charge, HttpSession session, ModelMap model) {

        System.out.println("==================recharge==============");
        System.out.println(charge);
        System.out.println("=========");


        boolean res = cardService.addBalance(CardHelper.getCurrentCardId(session),charge);

        if (res){
            return "redirect:/card";
        }

        return "member/recharge";
    }



}
