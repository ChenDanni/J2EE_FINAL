package controller.OrgController;

import dao.*;
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.CardService;
import service.ClassService;
import service.OrgService;
import service.RecordService;
import utility.DateHelper;
import utility.JSONHelper;
import utility.LogHelper;
import utility.OrgHelper;
import vo.member.courseVO;
import vo.org.attendanceVO;
import vo.org.recordDetailVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public class LearnRecordController {

    @Autowired
    ClassService classService;
    @Autowired
    OrgService orgService;
    @Autowired
    RecordService recordService;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    CardDAO cardDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;
    @Autowired
    CardService cardService;
    @Autowired
    LessonDAO lessonDAO;
    @Autowired
    LessonMemberDAO lessonMemberDAO;

    @RequestMapping(value = "/record_attend", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject recordAttend(HttpServletResponse response, HttpServletRequest request){

        int cardId = Integer.valueOf(request.getParameter("cardId"));
        int lessonId = Integer.valueOf(request.getParameter("lessonId"));

        recordService.setAttend(cardId,lessonId);

        JSONObject ret = new JSONObject();
        ret.put("msg","success");
        return ret;
    }

    @RequestMapping(value = "/record_absence", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject recordAbsence(HttpServletResponse response, HttpServletRequest request){

        int cardId = Integer.valueOf(request.getParameter("cardId"));
        int lessonId = Integer.valueOf(request.getParameter("lessonId"));

        recordService.setAbsence(cardId,lessonId);

        JSONObject ret = new JSONObject();
        ret.put("msg","success");
        return ret;
    }

    @RequestMapping(value = "/special_quit", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject specialQuit(HttpServletResponse response, HttpServletRequest request){

        int cardId = Integer.valueOf(request.getParameter("cardId"));
        int classId = Integer.valueOf(request.getParameter("classId"));

        classMemberDAO.updateClassMemberState(3,classId,cardId);

        JSONObject ret = new JSONObject();
        ret.put("msg","success");
        return ret;
    }

    @RequestMapping(value = "/record_score", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject recordScore(HttpServletResponse response, HttpServletRequest request){

        int score = Integer.valueOf(request.getParameter("score"));
        int cardId = Integer.valueOf(request.getParameter("cardId"));
        int classId = Integer.valueOf(request.getParameter("classId"));

        recordService.setScore(score,cardId,classId);

        JSONObject ret = new JSONObject();
        ret.put("msg","success");
        return ret;
    }


    @RequestMapping(value = "/org_learn_record", method = RequestMethod.GET)
    public String getOrgLearnRecord(HttpSession session, ModelMap model) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        List<courseVO> vos = classService.getStartCourse(orgId);

        JSONArray ret = JSONHelper.courseVOsToJson(vos);

        model.addAttribute("courses",ret);

        return "organization/learnRecord";
    }

    @RequestMapping(value = "/org_learn_record_detail", method = RequestMethod.GET)
    public String getOrgLearnRecordDetail(@RequestParam("id") int id, ModelMap model) {
        JSONArray attendances = new JSONArray();

        recordDetailVO vo =  orgService.getRecordDetail(id);
        int lessonNum = vo.attendanceVOs.get(0).attendances.size();

        for (int i = 0; i < vo.attendanceVOs.size(); i++){
            attendanceVO a = vo.attendanceVOs.get(i);
            JSONObject o = new JSONObject();
            o.put("cardId",a.cardId);
            o.put("name",a.name);
            o.put("score",a.score);
            o.put("state",a.state);
            o.put("cmstate",a.cmstate);

            JSONArray ats = new JSONArray();
            for (int j = 0;j < a.attendances.size();j++){
                int attend = a.attendances.get(j);
                int lessonId = a.lessonid.get(j);

                JSONObject obj = new JSONObject();
                obj.put("state",attend);
                obj.put("lessonId",lessonId);
                ats.add(obj);
            }
            o.put("ats",ats);
            attendances.add(o);
        }

        model.addAttribute("classId",id);
        model.addAttribute("name",vo.course_name);
        model.addAttribute("totalMember",vo.totalMember);
        model.addAttribute("price",vo.price);
        model.addAttribute("learn_time",vo.learn_time);
        model.addAttribute("start_time", DateHelper.getDate(vo.start_time));
        model.addAttribute("attendances",attendances);
        model.addAttribute("lessonNum",lessonNum);

        return "organization/recordDetail";
    }

    private void bindLessonMember(int cardId,ClassEntity c){
        List<LessonEntity> lessons = lessonDAO.findByClassId(c);
        for (int j = 0;j < lessons.size();j++){
            LessonMemberEntity lm = new LessonMemberEntity();
            lm.setCardId(cardId);
            lm.setAttendance(0);
            lm.setLessonId(lessons.get(j).getId());
            lessonMemberDAO.save(lm);
        }

    }

    @RequestMapping(value = "/user/book/{cid}", method = RequestMethod.POST)
    public String bookCourseForUser(@PathVariable("cid") Integer id,
                                    @RequestParam("name") String name){
        int cardId = cardService.register(name, "123", "123");
        CardEntity cardEntity = cardDAO.findOne(cardId);
        cardEntity.setState(4);
        cardDAO.saveAndFlush(cardEntity);
        ClassEntity classEntity = classDAO.findOne(id);
        ClassMemberEntity cm = LogHelper.getBookCM(cardId,id);
        int leftMember = classEntity.getLeftMembers() - 1;
        classDAO.updateClassLeftMember(leftMember,id);
        classMemberDAO.save(cm);

        bindLessonMember(cardId,classEntity);
        return "redirect:/org_learn_record_detail?id="+id;
    }
}

