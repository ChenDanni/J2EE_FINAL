package controller.OrgController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrgService;
import utility.DateHelper;
import utility.IdHelper;
import utility.OrgHelper;
import vo.org.accountInfoVO;
import vo.org.accountOPVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Controller
public class OrgAccountController {

    @Autowired
    OrgService orgService;

    @RequestMapping(value = "/org_account", method = RequestMethod.GET)
    public String getOrgAccount(ModelMap model, HttpSession session) {
        int id = OrgHelper.getCurrentOrgId(session);
        accountInfoVO accountInfo = orgService.getAccountInfo(id);
        List<accountOPVO> opVos = orgService.getAccountOPs(id);
        model.addAttribute("balance",accountInfo.balance);
        JSONArray ret = new JSONArray();
        for (int i = 0;i < opVos.size();i++){
            accountOPVO vo = opVos.get(i);
            JSONObject o = new JSONObject();
            o.put("className",vo.className);
            o.put("classId",vo.classId);
            o.put("state",vo.state);
            o.put("money",vo.money);
            o.put("balance",vo.balance);
            o.put("time", DateHelper.getDate(vo.time));
            o.put("cardId",vo.cardId);
            ret.add(o);
        }
        model.addAttribute("ops",ret);

        return "organization/orgAccount";
    }
}
