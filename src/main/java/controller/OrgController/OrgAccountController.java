package controller.OrgController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.OrgService;
import vo.org.accountInfoVO;
import vo.org.accountOPVO;

import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Controller
public class OrgAccountController {

    @Autowired
    OrgService orgService;

    @RequestMapping(value = "/org_account", method = RequestMethod.GET)
    public String getOrgAccount(@RequestParam("id")int id, ModelMap model) {
        accountInfoVO accountInfo = orgService.getAccountInfo(id);
        List<accountOPVO> opVos = orgService.getAccountOPs(id);







        return "organization/orgAccount";
    }
}
