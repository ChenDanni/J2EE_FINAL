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
import service.LogService;
import utility.DateHelper;
import vo.manager.BalanceInfoVO;
import vo.manager.MemberHandleLogVO;
import vo.manager.OrgHandleLogVO;
import vo.manager.RechargeLogVO;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Controller
public class BalanceController {

    @Autowired
    BalanceService balanceService;
    @Autowired
    LogService logService;


    @RequestMapping(value = "/manager_balance", method = RequestMethod.GET)
    public String getManagerBalance(ModelMap model) {

        BalanceInfoVO bvo = balanceService.getBalanceInfo();
        model.addAttribute("recharge",bvo.recharge);
        model.addAttribute("mh",bvo.memberHandle);
        model.addAttribute("oh",bvo.orgHandle);
        model.addAttribute("balance",bvo.balance);

        List<RechargeLogVO> vos = balanceService.getRechargeLog();
        List<MemberHandleLogVO> mvos = logService.getManagerMemberHandleLog();
        List<OrgHandleLogVO> ovos = logService.getManagerOrgHandleLog();


        JSONArray re = new JSONArray();
        JSONArray mh = new JSONArray();
        JSONArray oh = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            RechargeLogVO vo = vos.get(i);
            JSONObject o = new JSONObject();
            o.put("cardId",vo.cardId);
            o.put("money",vo.money);
            o.put("recharge",vo.recharge);
            o.put("time", DateHelper.getDate(vo.time));
            re.add(o);
        }
        for (int i = 0;i < mvos.size();i++){
            MemberHandleLogVO vo = mvos.get(i);
            JSONObject o = new JSONObject();
            o.put("cardId",vo.cardId);
            o.put("classId",vo.classId);
            o.put("money",vo.money);
            o.put("memberhandle",vo.memberhandle);
            o.put("time", DateHelper.getDate(vo.time));
            mh.add(o);
        }
        for (int i = 0;i < ovos.size();i++){
            OrgHandleLogVO vo = ovos.get(i);
            JSONObject o = new JSONObject();
            o.put("orgId",vo.orgId);
            o.put("money",vo.money);
            o.put("classId",vo.classId);
            o.put("orghandle",vo.orgHandle);
            o.put("time", DateHelper.getDate(vo.time));
            oh.add(o);
        }


        model.addAttribute("ops",re);
        model.addAttribute("mhs",mh);
        model.addAttribute("ohs",oh);

        return "manager/balance";
    }
}
