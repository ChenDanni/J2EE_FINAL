package controller.OrgController;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClassService;
import utility.IdHelper;
import utility.JSONHelper;
import utility.OrgHelper;
import vo.member.courseVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class LearnRecordController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/org_learn_record", method = RequestMethod.GET)
    public String getOrgLearnRecord(HttpSession session, ModelMap model) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        List<courseVO> vos = classService.getStartCourse(orgId);

        JSONArray ret = JSONHelper.courseVOsToJson(vos);

        model.addAttribute("courses",ret);

        return "organization/learnRecord";
    }

    @RequestMapping(value = "/org_learn_record_detail", method = RequestMethod.GET)
    public String getOrgLearnRecordDetail(HttpSession session, ModelMap model) {
//        int orgId = OrgHelper.getCurrentOrgId(session);
//        List<courseVO> vos = classService.getStartCourse(orgId);
//        JSONArray ret = JSONHelper.courseVOsToJson(vos);
//        model.addAttribute("courses",ret);


        return "organization/recordDetail";
    }
}
