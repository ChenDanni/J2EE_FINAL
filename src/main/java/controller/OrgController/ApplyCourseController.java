package controller.OrgController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class ApplyCourseController {

    @RequestMapping(value = "/org_class_apply", method = RequestMethod.GET)
    public String getOrgClassApply() {
        return "organization/classApply";
    }

    @RequestMapping(value = "/org_course_fix", method = RequestMethod.GET)
    public String courseFixApplying(@RequestParam("id") int id, ModelMap model, HttpSession session) {


        return "organization/classFix";
    }
}
