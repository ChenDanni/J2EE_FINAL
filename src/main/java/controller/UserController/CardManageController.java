package controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CardService;

/**
 * Created by cdn on 17/3/10.
 */
@Controller
public class CardManageController {
    @Autowired
    CardService cardService;


    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public String getCard(ModelMap model) {





        return "member/card";
    }
}
