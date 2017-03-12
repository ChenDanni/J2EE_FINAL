package controller.OrgController;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ClassService;
import utility.IdHelper;
import utility.OrgHelper;
import vo.org.classApplyInfo;
import vo.org.lessonInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class ApplyCourseController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/org_class_apply", method = RequestMethod.GET)
    public String getOrgClassApply() {
        return "organization/classApply";
    }

    @RequestMapping(value = "/org_course_fix", method = RequestMethod.GET)
    public String courseFixApplying(@RequestParam("id") int id, ModelMap model, HttpSession session) {
        return "organization/classFix";
    }
    @RequestMapping(value = "/apply_class",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject applyClass(HttpServletResponse response, HttpServletRequest request, HttpSession session){

        int orgId = OrgHelper.getCurrentOrgId(session);
        ArrayList<lessonInfo> ls = new ArrayList<>();
        int classId = IdHelper.getClassId();
        int i = 1;
        while (request.getParameter("lesson-title-" + i) != null){
            System.err.println("get lesson " + i);
            String title = request.getParameter("lesson-title-" + i);
            String des = request.getParameter("lesson-des-" + i);
            lessonInfo l = new lessonInfo(title,i,des,classId);
            ls.add(l);
            i++;
        }

        System.err.println("lesson num: " + ls.size());
        String name = request.getParameter("course-name");
        Date time = Date.valueOf(request.getParameter("start-time"));
        String learn_time = request.getParameter("learn-time");
        String teacher = request.getParameter("teacher");
        int price = Integer.valueOf(request.getParameter("price"));
        int memberNum = Integer.valueOf(request.getParameter("memberNum"));
        String des = request.getParameter("description");

        classApplyInfo ac = new classApplyInfo(classId,name,time,teacher,
                price,memberNum,des,learn_time,memberNum,orgId,ls);

        boolean res = classService.applyCourse(ac);

        JSONObject re = new JSONObject();
        if (res){
            re.put("result",1);
            return re;
        }else {
            re.put("result",0);
            return re;
        }

    }
}
