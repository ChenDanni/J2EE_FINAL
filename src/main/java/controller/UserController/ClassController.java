package controller.UserController;

import dao.ClassDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClassService;
import utility.DateHelper;
import vo.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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
        JSONArray ret = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            courseVO vo = vos.get(i);

            JSONObject obj = new JSONObject();
            obj.put("id",vo.id);
            obj.put("name",vo.name);
            obj.put("price",vo.price);
            obj.put("memberNum",vo.memberNum);
            obj.put("learn_time",vo.learn_time);
            obj.put("orgName",vo.orgName);
            obj.put("start_time",DateHelper.getDate(vo.start_time));
            ret.add(obj);
        }

        System.out.println(ret);
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


        return "member/courseDetail";
    }


}

