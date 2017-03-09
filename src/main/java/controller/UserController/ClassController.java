package controller.UserController;

import dao.ClassDAO;
import dao.OrgDAO;
import model.ClassEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.ClassService;
import utility.JSONHelper;
import vo.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        JSONArray ret = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            courseVO vo = vos.get(i);

            JSONObject obj = new JSONObject();
            obj.put("name",vo.name);
            obj.put("price",vo.price);
            obj.put("memberNum",vo.memberNum);
            obj.put("learn_time",vo.learn_time);
            obj.put("orgName",vo.orgName);
            obj.put("create_time",vo.create_time);
            ret.add(obj);
        }

        model.addAttribute("allCourses",ret);

        return "member/allCourses";
    }
}
