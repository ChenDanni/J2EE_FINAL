package controller.UserController;

import model.CardEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CardService;
import utility.CardHelper;
import utility.DateHelper;
import vo.member.cardManageVO;
import vo.member.opVO;
import vo.member.setCardInfoVO;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/11.
 */
@Controller
public class SetInfoController {

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/setCardInfo", method = RequestMethod.GET)
    public String getSetCardInfo(ModelMap model, HttpSession session) {
        int cardId = CardHelper.getCurrentCardId(session);
        setCardInfoVO vo = cardService.getSetCardInfo(cardId);

        model.addAttribute("cardId",cardId);
        model.addAttribute("username",vo.username);
        model.addAttribute("accountId",vo.accountId);
        model.addAttribute("phone",vo.phone);
        model.addAttribute("password",vo.password);
        return "member/setCardInfo";
    }

    @RequestMapping(value = "/setCardInfo", method = RequestMethod.POST)
    public String getCard(@RequestParam("username") String username,
            @RequestParam("accountId") String accountId, @RequestParam("phone") String phone,
            @RequestParam("password") String password, HttpSession session) {
        int cardId = CardHelper.getCurrentCardId(session);

        cardService.updateCardInfo(cardId,username,accountId,phone,password);

        return "redirect:/card";
    }

}
