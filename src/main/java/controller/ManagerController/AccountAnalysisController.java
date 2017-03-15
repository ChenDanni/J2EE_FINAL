package controller.ManagerController;

import dao.MemberHandleLogDAO;
import dao.OrgHandleLogDAO;
import dao.RechargeLogDAO;
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utility.DateHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cdn on 17/3/15.
 */
@Controller
public class AccountAnalysisController {
    @Autowired
    RechargeLogDAO rechargeLogDAO;
    @Autowired
    OrgHandleLogDAO orgHandleLogDAO;
    @Autowired
    MemberHandleLogDAO memberHandleLogDAO;

    @RequestMapping(value = "/manager_account_analysis", method = RequestMethod.GET)
    public String getManagerAccountAnalysis() {

        return "manager/accountAnalysis";
    }


    @RequestMapping(value = "/manager_recharge", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getManagerRecharge(HttpServletResponse response, HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        JSONArray time = new JSONArray();
        JSONArray num = new JSONArray();

        List<RechargeLogEntity> logs = rechargeLogDAO.getRechargeLogs();
        for (int i = 0;i < logs.size();i++){
            time.add(DateHelper.getDate(logs.get(i).getTime()));
            num.add(logs.get(i).getRecharge());
        }

        ret.put("time",time);
        ret.put("num",num);
        return ret;
    }
    @RequestMapping(value = "/manager_quit", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getManagerQuit(HttpServletResponse response, HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        JSONArray time = new JSONArray();
        JSONArray num = new JSONArray();

        List<OrghandleLogEntity> logs = orgHandleLogDAO.findAllLogsOrderByTimeDesc();
        for (int i = 0;i < logs.size();i++){
            time.add(DateHelper.getDate(logs.get(i).getTime()));
            num.add(logs.get(i).getOrghandle());
        }

        ret.put("time",time);
        ret.put("num",num);
        return ret;
    }
    @RequestMapping(value = "/manager_set_account", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getManagerSetAccount(HttpServletResponse response, HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        JSONArray time = new JSONArray();
        JSONArray num = new JSONArray();

        List<MemberhandleLogEntity> logs = memberHandleLogDAO.findAllLogsOrderByTimeDesc();
        for (int i = 0;i < logs.size();i++){
            time.add(DateHelper.getDate(logs.get(i).getTime()));
            num.add(logs.get(i).getMemberhandle());
        }

        ret.put("time",time);
        ret.put("num",num);
        return ret;
    }
}
