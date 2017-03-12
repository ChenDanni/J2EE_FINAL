package controller.OrgController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utility.OrgHelper;

import javax.servlet.http.HttpSession;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class CoursesController {

    @RequestMapping(value = "/org_courses", method = RequestMethod.GET)
    public String getOrgCourses(HttpSession session, ModelMap model) {
        int orgId = OrgHelper.getCurrentOrgId(session);




        return "organization/courses";
    }
}
