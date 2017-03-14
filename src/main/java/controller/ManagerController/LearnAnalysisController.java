package controller.ManagerController;

import dao.ClassDAO;
import dao.ClassMemberDAO;
import model.ClassEntity;
import model.ClassMemberEntity;
import model.OrganizationEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by cdn on 17/3/15.
 */
@Controller
public class LearnAnalysisController {

    @Autowired
    ClassDAO classDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;

    @RequestMapping(value = "/learnAnalysis", method = RequestMethod.GET)
    public String getLearnAnalysis() {
        return "manager/learnAnalysis";
    }

    @RequestMapping(value = "/learn_analysis", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getLearningAnalysis(HttpServletResponse response, HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        JSONArray classname = new JSONArray();
        JSONArray avg = new JSONArray();

        List<ClassEntity> classes = classDAO.findAllClassesOrderByTimeDesc();
        for (int i = 0;i < classes.size();i++){
            ClassEntity c = classes.get(i);
            int classId = c.getId();
            List<ClassMemberEntity> cms = classMemberDAO.findByClassId(classId);
            if (cms.size() > 0){
                int a = 0;
                for (int j = 0;j < cms.size();j++){
                    a += cms.get(j).getScores();
                }
                a = a/cms.size();
                classname.add(c.getName());
                avg.add(a);
            }

        }
        ret.put("classname",classname);
        ret.put("avg",avg);
        return ret;
    }

}
