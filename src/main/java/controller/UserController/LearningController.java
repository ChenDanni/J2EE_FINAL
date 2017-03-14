package controller.UserController;

import dao.*;
import model.*;
import org.apache.commons.logging.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ClassService;
import service.LessonService;
import utility.CardHelper;
import utility.DateHelper;
import utility.IdHelper;
import utility.LogHelper;
import vo.member.LearningVO;
import vo.org.attendanceVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    ClassMemberDAO classMemberDAO;
    @Autowired
    LessonMemberDAO lessonMemberDAO;
    @Autowired
    LessonDAO lessonDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    LogDAO logDAO;


    private JSONArray getClassInfo(List<LearningVO> vos){
        JSONArray ret = new JSONArray();
        for (int i = 0;i < vos.size();i++){
            LearningVO vo = vos.get(i);
            JSONObject o = new JSONObject();
            o.put("classId",vo.id);
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

    @RequestMapping(value = "/quit_course", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject quitCourse(HttpServletResponse response, HttpServletRequest request,HttpSession session) {
        int cardId = CardHelper.getCurrentCardId(session);
        int classId = Integer.valueOf(request.getParameter("classId"));
        ClassEntity classEntity = classDAO.findOne(classId);
        //更新class member state 3
        classMemberDAO.updateClassMemberState(3,classId,cardId);

        //增加log(退款为剩下没上的课/总课时)
        List<LessonEntity> lessons = lessonDAO.findByClassId(classEntity);
        int total = lessons.size();
        int left = 0;
        for (int i = 0;i < total;i++){
            LessonMemberEntityPK lmpk = new LessonMemberEntityPK();
            lmpk.setCardId(cardId);
            lmpk.setLessonId(lessons.get(i).getId());
            LessonMemberEntity lm = lessonMemberDAO.findOne(lmpk);
            if (lm.getAttendance() == 0)
                left++;
        }
        int money = classEntity.getPrice();
        LogEntity log = LogHelper.getLogEntity(money,classId,cardId,total,total-left);
        logDAO.save(log);

        JSONObject ret = new JSONObject();
        ret.put("msg","success");

        return ret;
    }

    @RequestMapping(value = "/quitting", method = RequestMethod.GET)
    public String getQuitting(HttpSession session, ModelMap model) {
        int cardId = CardHelper.getCurrentCardId(session);
        List<LearningVO> vos = classService.getLearnings(cardId,2);
        JSONArray ret = getClassInfo(vos);
        model.addAttribute("lessons",ret);

        return "member/quitting";
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
