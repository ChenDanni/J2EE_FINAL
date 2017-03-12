package controller.UserController;

import dao.ClassDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClassService;
import utility.DateHelper;
import utility.IdHelper;
import utility.JSONHelper;
import utility.OrgHelper;
import vo.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vo.org.classApplyInfo;
import vo.org.lessonInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdn on 17/3/9.
 */
@Controller
public class ClassController {
    @Autowired
    ClassDAO classDAO;
    @Autowired
    ClassService classService;

    @RequestMapping(value = "/allCourses", method = RequestMethod.GET)
    public String getAllCourses(ModelMap model) {
        List<courseVO> vos = classService.getAllCoursesBrief();
        JSONArray ret = JSONHelper.courseVOsToJson(vos);

        model.addAttribute("allCourses",ret);

        return "member/allCourses";
    }

    @RequestMapping(value = "/course_detail",method = RequestMethod.GET)
    public String getCourseDetail(@RequestParam("id") int id, ModelMap model, HttpSession session){
        int cardId;
        if (session.getAttribute("cardId") == null){
            cardId = -1;
        }else {
            cardId = (int)session.getAttribute("cardId");
        }

        courseDetailVO vo = classService.getCourseDetail(id,cardId);

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
        model.addAttribute("id",vo.id);

        return "member/courseDetail";
    }

    @RequestMapping(value = "/apply_class",method = RequestMethod.POST)
    public String applyClass(HttpServletResponse response, HttpServletRequest request,HttpSession session){

        int orgId = OrgHelper.getCurrentOrgId(session);
        ArrayList<lessonInfo> ls = new ArrayList<>();
        int classId = IdHelper.getClassId();
        int i = 0;
        while (request.getParameter("lesson-title-" + i) != null){
            String title = request.getParameter("lesson-title-" + i);
            String des = request.getParameter("lesson-des-" + i);
            lessonInfo l = new lessonInfo(title,i,des,classId);
            ls.add(l);
        }
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

        if (res){
            return "redirect:/org_applying";
        }else {
            String msg = "申请失败";
            return msg;
        }

    }

}

