package controller.ManagerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cdn on 17/3/13.
 */
@Controller
public class MemberHandleController {
    @RequestMapping(value = "/memberHandle", method = RequestMethod.GET)
    public String getMemberHandle() {
        return "manager/member_handle";
    }

    @RequestMapping(value = "/applyMemberHandle", method = RequestMethod.POST)
    public String memberHandle() {
        return "manager/member_handle";
    }



}
