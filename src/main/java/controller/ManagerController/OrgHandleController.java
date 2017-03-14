package controller.ManagerController;

import dao.*;
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LogService;
import utility.DateHelper;
import utility.JSONHelper;
import utility.LogHelper;
import vo.manager.LogVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Controller
public class OrgHandleController {

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
    OrgHandleLogDAO orgHandleLogDAO;
    @Autowired
    OrgDAO orgDAO;
    @Autowired
    OrgLogDAO orgLogDAO;

    @RequestMapping(value = "/orgHandle", method = RequestMethod.GET)
    public String getOrgHandle(ModelMap model) {

        List<LogVO> vos = logService.getMemberHandleLog();

        JSONArray ret = JSONHelper.logVOsToJson(vos);

        model.addAttribute("logs",ret);

        return "manager/org_handle";
    }

    @RequestMapping(value = "/handle_org", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject handleQrg(HttpServletResponse response, HttpServletRequest request) {

        int money = Integer.valueOf(request.getParameter("money"));
        int orgId = Integer.valueOf(request.getParameter("orgId"));
        int cardId = Integer.valueOf(request.getParameter("cardId"));
        int classId = Integer.valueOf(request.getParameter("classId"));
        int type = Integer.valueOf(request.getParameter("type"));

        //增加机构balance
        OrganizationEntity org = orgDAO.findOne(orgId);
        int balance = org.getBalance() + money;
        orgDAO.updateOrgBalance(balance,orgId);

        //增加org_log
        org = orgDAO.findOne(orgId);
        CardEntity card = cardDAO.findOne(cardId);
        ClassEntity classEntity = classDAO.findOne(classId);
        OrgLogEntity org_log = LogHelper.getOrgLogEntity(card,classEntity,org,money,balance,type);
        orgLogDAO.save(org_log);

        //更新log state为2
        int state = logDAO.findByCardIdAndClassId(cardId,classId).getState();
        if (state == 0)
            state = 2;
        if (state == 1)
            state = 3;
        if (state == 4)
            state = 5;
        logDAO.updateLogOrg(money,state,classId,cardId);

        //orghandle增加
        ManagerEntity managerEntity = managerDAO.findOne(1);
        int orgHandle = managerEntity.getOrgHandle() + money;
        managerDAO.updateManagerOrgHandle(orgHandle,1);

        //增加org_handleLog
        OrghandleLogEntity orghandleLogEntity = LogHelper.getOrgHandleLogEntity(org,money,orgHandle,classEntity,org_log.getTime());
        orgHandleLogDAO.save(orghandleLogEntity);

        JSONObject o = new JSONObject();
        o.put("msg","success");
        return o;
    }




}
