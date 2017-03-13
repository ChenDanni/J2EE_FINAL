package controller.ManagerController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClassService;
import utility.DateHelper;
import utility.JSONHelper;
import vo.manager.applicationHandleVO;
import vo.member.courseDetailVO;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Controller
public class ApplicationHandleController {

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/manage_apply_handle", method = RequestMethod.GET)
    public String getApplyHandle(ModelMap model) {

        List<applicationHandleVO> vos = classService.getApplicationHandle();
        JSONArray ret = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            applicationHandleVO vo = vos.get(i);
            JSONObject o = new JSONObject();
            o.put("name",vo.name);
            o.put("state",vo.state);
            o.put("id",vo.id);
            o.put("orgName",vo.orgName);
            o.put("start_time", DateHelper.getDate(vo.start_time));
            ret.add(o);
        }
        model.addAttribute("applications",ret);

        return "manager/applicationHandle";
    }

    @RequestMapping(value = "/manage_apply_handle_detail", method = RequestMethod.GET)
    public String getApplyHandleDetail(@RequestParam("id") int id, ModelMap model) {

        courseDetailVO vo = classService.getCourseDetail(id,-1);

        model = JSONHelper.courseDetailVOToModel(model,vo);

        return "manager/applicationDetail";
    }

    @RequestMapping(value = "/application_success", method = RequestMethod.POST)
    public String handleApplicationSuccess(@RequestParam("id") int id){
        classService.setApplicationSuccess(id);
        return "redirect:/manage_apply_handle_detail?id="+id;
    }

    @RequestMapping(value = "/application_fail", method = RequestMethod.POST)
    public String handleApplicationFail(@RequestParam("id") int id){
        classService.setApplicationFail(id);
        return "redirect:/manage_apply_handle_detail?id="+id;
    }
}
