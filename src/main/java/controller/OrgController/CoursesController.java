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
import utility.DateHelper;
import utility.JSONHelper;
import utility.OrgHelper;
import vo.member.courseDetailVO;
import vo.member.courseVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class CoursesController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/org_courses", method = RequestMethod.GET)
    public String getOrgCourses(HttpSession session, ModelMap model) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        List<courseVO> vos = classService.getOrgCoursesBrief(orgId);

        JSONArray ret = JSONHelper.courseVOsToJson(vos);

        model.addAttribute("allCourses",ret);

        return "organization/courses";
    }

    @RequestMapping(value = "/org_course_detail",method = RequestMethod.GET)
    public String getCourseDetail(@RequestParam("id") int id, ModelMap model, HttpSession session){

        courseDetailVO vo = classService.getCourseDetail(id,-1);

        model.addAttribute("id",vo.id);
        model.addAttribute("name",vo.name);
        model.addAttribute("price",vo.price);
        model.addAttribute("learn_time",vo.learn_time);
        model.addAttribute("orgName",vo.orgName);
        model.addAttribute("teacher",vo.teacher);
        model.addAttribute("description",vo.description);
        model.addAttribute("start_time", DateHelper.getDate(vo.start_time));
        model.addAttribute("state",vo.state);
        model.addAttribute("memberNum",vo.memberNum);
        model.addAttribute("leftMember",vo.leftMembers);

        return "organization/courseDetail";
    }
}
