package controller.ManagerController;

import dao.*;
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LogService;
import utility.DateHelper;
import utility.LogHelper;
import vo.manager.LogVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Controller
public class MemberHandleController {
    @Autowired
    LogService logService;
    @Autowired
    CardDAO cardDAO;
    @Autowired
    ManagerDAO managerDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    ChargeLogDAO chargeLogDAO;
    @Autowired
    LogDAO logDAO;
    @Autowired
    MemberHandleLogDAO memberHandleLogDAO;

    @RequestMapping(value = "/memberHandle", method = RequestMethod.GET)
    public String getMemberHandle(ModelMap model) {
        List<LogVO> vos = logService.getMemberHandleLog();
        JSONArray ret = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            LogVO vo = vos.get(i);
            JSONObject obj = new JSONObject();
            obj.put("username",vo.username);
            obj.put("cardId",vo.cardId);
            obj.put("className",vo.className);
            obj.put("classId",vo.classId);
            obj.put("orgName",vo.orgName);
            obj.put("orgId",vo.orgId);
            obj.put("finish",vo.finish);
            obj.put("total",vo.total);
            obj.put("price",vo.money);
            obj.put("time", DateHelper.getDate(vo.time));
            obj.put("state",vo.state);
            obj.put("money_back",vo.money_back);

            ret.add(obj);
        }

        model.addAttribute("logs",ret);

        return "manager/member_handle";
    }

    @RequestMapping(value = "/applyMemberHandle", method = RequestMethod.POST)
    public String memberHandle() {
        return "manager/member_handle";
    }

    @RequestMapping(value = "/handle_quit", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject handleQuit(HttpServletResponse response, HttpServletRequest request) {

        System.err.println("handle quit");

        int money = Integer.valueOf(request.getParameter("money"));
        int cardId = Integer.valueOf(request.getParameter("cardId"));
        int classId = Integer.valueOf(request.getParameter("classId"));


        //增加学生balance
        CardEntity c = cardDAO.findOne(cardId);
        int balance = c.getBalance() + money;
        cardDAO.updateCardBalance(balance,cardId);

        System.err.println("add balance");

        //增加chargelog
        ClassEntity classEntity = classDAO.findOne(classId);
        c = cardDAO.findOne(cardId);
        ChargeLogEntity chargelog = LogHelper.getQuitClassChargeLog(money,balance,c,classEntity);
        chargeLogDAO.save(chargelog);
        System.err.println("add chargelog");

        //更新log money, state
        logDAO.updateLog(money,1,classId,cardId);

        System.err.println("update log");

        //机构账户退款增加
        ManagerEntity managerEntity = managerDAO.findOne(1);
        int memberHandle = managerEntity.getMemberHandle() + money;
        managerDAO.updateManagerMemberHandle(memberHandle,1);

        System.err.println("add member handle");

        //增加member handle log
        MemberhandleLogEntity m = LogHelper.getMemberHandleLogEntity(c,classEntity,money,chargelog.getDate());
        memberHandleLogDAO.save(m);

        System.err.println("add member handle log");

        JSONObject o = new JSONObject();
        o.put("msg","success");
        return o;
    }


}
