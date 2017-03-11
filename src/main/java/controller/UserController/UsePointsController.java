package controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CardService;
import utility.CardHelper;
import vo.member.rechargeVO;
import vo.member.usePointsVO;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/11.
 */
@Controller
public class UsePointsController {
    @Autowired
    CardService cardService;


    @RequestMapping(value = "/use_points", method = RequestMethod.GET)
    public String getRecharge(HttpSession session, ModelMap model) {
        int cardId = CardHelper.getCurrentCardId(session);
        usePointsVO vo = cardService.getUsePoints(cardId);

        model.addAttribute("cardId",cardId);
        model.addAttribute("points",vo.points);

        return "member/usePoints";
    }

    @RequestMapping(value = "/use_points", method = RequestMethod.POST)
    public String addBalance(@RequestParam("pointNum") int pointNum, HttpSession session) {

        boolean res = cardService.usePoints(CardHelper.getCurrentCardId(session),pointNum);

        if (res){
            return "redirect:/card";
        }

        return "member/usePoints";
    }
}
