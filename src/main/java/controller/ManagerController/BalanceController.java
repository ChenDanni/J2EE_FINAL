package controller.ManagerController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.BalanceService;
import utility.DateHelper;
import vo.manager.BalanceInfoVO;
import vo.manager.RechargeLogVO;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Controller
public class BalanceController {

    @Autowired
    BalanceService balanceService;


    @RequestMapping(value = "/manager_balance", method = RequestMethod.GET)
    public String getManagerBalance(@RequestParam("type")int type, ModelMap model) {

        BalanceInfoVO bvo = balanceService.getBalanceInfo();
        model.addAttribute("recharge",bvo.recharge);
        model.addAttribute("mh",bvo.memberHandle);
        model.addAttribute("oh",bvo.orgHandle);
        model.addAttribute("balance",bvo.balance);

        model.addAttribute("type",type);

        if (type == 0){
            List<RechargeLogVO> vos = balanceService.getRechargeLog();
            JSONArray ret = new JSONArray();
            for (int i = 0;i < vos.size();i++){
                RechargeLogVO vo = vos.get(i);
                JSONObject o = new JSONObject();
                o.put("cardId",vo.cardId);
                o.put("money",vo.money);
                o.put("recharge",vo.recharge);
                o.put("time", DateHelper.getDate(vo.time));
                ret.add(o);
            }
            model.addAttribute("ops",ret);
            return "manager/balance";
        }




        return "manager/balance";
    }
}
