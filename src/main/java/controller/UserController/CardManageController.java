package controller.UserController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CardService;
import utility.CardHelper;
import utility.DateHelper;
import vo.member.cardManageVO;
import vo.member.opVO;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/10.
 */
@Controller
public class CardManageController {
    @Autowired
    CardService cardService;

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String getCard(ModelMap model, HttpSession session) {
        int cardId = CardHelper.getCurrentCardId(session);
        cardManageVO vo = cardService.getCardManage(cardId);

        JSONArray ops = new JSONArray();

        for (int i = 0;i < vo.ops.size();i++){
            opVO op = vo.ops.get(i);
            JSONObject obj = new JSONObject();
            obj.put("name",op.name);
            obj.put("charge",op.charge);
            obj.put("balance",op.balance);
            obj.put("points",op.points);
            obj.put("time", DateHelper.getDate(op.time));
            ops.add(obj);
        }

        model.addAttribute("name",vo.name);
        model.addAttribute("level",vo.level);
        model.addAttribute("balance",vo.balance);
        model.addAttribute("points",vo.points);
        model.addAttribute("state",vo.state);
        model.addAttribute("ops",ops);

        return "member/card";
    }




}
