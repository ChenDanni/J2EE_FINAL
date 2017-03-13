package controller.OrgController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClassService;
import service.OrgService;
import utility.DateHelper;
import utility.JSONHelper;
import utility.OrgHelper;
import vo.member.courseVO;
import vo.org.attendanceVO;
import vo.org.recordDetailVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class LearnRecordController {

    @Autowired
    ClassService classService;
    @Autowired
    OrgService orgService;

    @RequestMapping(value = "/org_learn_record", method = RequestMethod.GET)
    public String getOrgLearnRecord(HttpSession session, ModelMap model) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        List<courseVO> vos = classService.getStartCourse(orgId);

        JSONArray ret = JSONHelper.courseVOsToJson(vos);

        model.addAttribute("courses",ret);

        return "organization/learnRecord";
    }

    @RequestMapping(value = "/org_learn_record_detail", method = RequestMethod.GET)
    public String getOrgLearnRecordDetail(@RequestParam("id") int id, ModelMap model) {
        JSONArray attendances = new JSONArray();

        recordDetailVO vo =  orgService.getRecordDetail(id);
        int lessonNum = vo.attendanceVOs.get(0).attendances.size();

        for (int i = 0; i < vo.attendanceVOs.size(); i++){
            attendanceVO a = vo.attendanceVOs.get(i);
            JSONObject o = new JSONObject();
            o.put("cardId",a.cardId);
            o.put("name",a.name);
            JSONArray ats = new JSONArray();
            for (int j = 0;j < a.attendances.size();j++){
                int attend = a.attendances.get(j);
                ats.add(attend);
            }
            o.put("ats",ats);
            attendances.add(o);
        }

        model.addAttribute("name",vo.course_name);
        model.addAttribute("totalMember",vo.totalMember);
        model.addAttribute("price",vo.price);
        model.addAttribute("learn_time",vo.learn_time);
        model.addAttribute("start_time", DateHelper.getDate(vo.start_time));
        model.addAttribute("attendances",attendances);
        model.addAttribute("lessonNum",lessonNum);

        return "organization/recordDetail";
    }
}
