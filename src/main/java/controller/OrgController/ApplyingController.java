package controller.OrgController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClassService;
import service.OrgService;
import utility.OrgHelper;
import vo.org.applyInfoVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class ApplyingController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/org_applying", method = RequestMethod.GET)
    public String getOrgApplying(HttpSession session, ModelMap model) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        List<applyInfoVO> vos = classService.getApplyInfo(orgId);

        JSONArray ret = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            applyInfoVO vo = vos.get(i);
            JSONObject o = new JSONObject();
            o.put("name",vo.name);
            o.put("state",vo.state);
            ret.add(o);
        }
        model.addAttribute("applications",ret);

        return "organization/applying";
    }
}
