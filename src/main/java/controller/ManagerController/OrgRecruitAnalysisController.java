package controller.ManagerController;

import dao.ClassDAO;
import dao.ClassMemberDAO;
import dao.OrgDAO;
import model.ClassEntity;
import model.ClassMemberEntity;
import model.OrganizationEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utility.OrgHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Controller
public class OrgRecruitAnalysisController {

    @Autowired
    OrgDAO orgDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;

    @RequestMapping(value = "/org_recruits", method = RequestMethod.GET)
    public String getOrgRecruits() {
        return "manager/orgAnalysis";
    }

    @RequestMapping(value = "/org_recruit_analysis", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getOrgLearningStatus(HttpServletResponse response, HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        JSONArray orgName = new JSONArray();
        JSONArray recruitNum = new JSONArray();
        List<OrganizationEntity> orgs = orgDAO.findAllOrgs();
        for (int i = 0;i < orgs.size();i++){
            int sum = 0;
            List<ClassEntity> classEntities = classDAO.findClassesByOrg(orgs.get(i));
            for (int j = 0;j < classEntities.size();j++){
                List<ClassMemberEntity> cms = classMemberDAO.findByClassId(classEntities.get(j).getId());
                sum += cms.size();
            }
            orgName.add(orgs.get(i).getName());
            recruitNum.add(sum);
        }
        ret.put("orgName",orgName);
        ret.put("recruitNum",recruitNum);
        return ret;
    }


}
