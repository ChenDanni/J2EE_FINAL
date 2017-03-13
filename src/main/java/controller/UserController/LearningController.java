package controller.UserController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ClassService;
import service.LessonService;
import utility.CardHelper;
import utility.DateHelper;
import utility.IdHelper;
import vo.member.LearningVO;
import vo.org.attendanceVO;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Controller
public class LearningController {

    @Autowired
    ClassService classService;
    @Autowired
    LessonService lessonService;

    private JSONArray getClassInfo(List<LearningVO> vos){
        JSONArray ret = new JSONArray();
        for (int i = 0;i < vos.size();i++){
            LearningVO vo = vos.get(i);
            JSONObject o = new JSONObject();
            o.put("name",vo.name);
            o.put("price",vo.price);
            o.put("totalMember",vo.totalMember);
            o.put("learn_time",vo.learn_time);
            o.put("orgName",vo.orgName);
            o.put("start_time", DateHelper.getDate(vo.start_time));

            attendanceVO at = vo.attendanceVO;
            JSONArray ats = new JSONArray();
            for (int j = 0;j < at.lessonid.size();j++){
                JSONObject obj = new JSONObject();
                String lName = lessonService.getLessonName(at.lessonid.get(j));
                obj.put("lesson_name",lName);
                obj.put("lessonId",at.lessonid.get(j));
                obj.put("attendance",at.attendances.get(j));
                ats.add(obj);
            }
            o.put("score",at.score);
            o.put("attendance",ats);
            ret.add(o);
        }
        return ret;
    }

    @RequestMapping(value = "/learning", method = RequestMethod.GET)
    public String getStudying(HttpSession session, ModelMap model) {
        int cardId = CardHelper.getCurrentCardId(session);
        List<LearningVO> vos = classService.getLearnings(cardId,0);
        JSONArray ret = getClassInfo(vos);
        model.addAttribute("lessons",ret);

        return "member/learning";
    }

    @RequestMapping(value = "/finishing", method = RequestMethod.GET)
    public String getFinishing(HttpSession session, ModelMap model) {
        int cardId = CardHelper.getCurrentCardId(session);
        List<LearningVO> vos = classService.getLearnings(cardId,1);
        JSONArray ret = getClassInfo(vos);
        model.addAttribute("lessons",ret);

        return "member/finishing";
    }

}
