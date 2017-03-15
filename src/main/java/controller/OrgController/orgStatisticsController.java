package controller.OrgController;

import dao.ClassMemberDAO;
import dao.OrgDAO;
import dao.OrgLogDAO;
import model.ClassEntity;
import model.ClassMemberEntity;
import model.OrgLogEntity;
import model.OrganizationEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import utility.DateHelper;
import utility.IdHelper;
import utility.OrgHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Controller
public class orgStatisticsController {

    @Autowired
    OrgLogDAO orgLogDAO;
    @Autowired
    OrgDAO orgDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;

    @RequestMapping(value = "/org_statistics", method = RequestMethod.GET)
    public String getOrgStatistics() {
        return "organization/orgStatistics";
    }

    @RequestMapping(value = "/org_balance_analysis", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getOrgBalanceStatistics(HttpServletResponse response, HttpServletRequest request,HttpSession session) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        OrganizationEntity org = orgDAO.findOne(orgId);
        JSONObject ret = new JSONObject();

        JSONArray time = new JSONArray();
        JSONArray balance = new JSONArray();


        List<OrgLogEntity> logs = orgLogDAO.findLogsByOrgIdOrderByTimeAsc(org);
        for (int i = 0;i < logs.size();i++){
            OrgLogEntity log = logs.get(i);
            time.add(DateHelper.getDate(log.getTime()));
            balance.add(log.getBalance());
        }
        ret.put("time",time);
        ret.put("balance",balance);

        return ret;
    }
    @RequestMapping(value = "/org_learning_status", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getOrgLearningStatus(HttpServletResponse response, HttpServletRequest request,HttpSession session) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        OrganizationEntity org = orgDAO.findOne(orgId);
        Collection<ClassEntity> classes = org.getClasses();
        Iterator<ClassEntity> iterator = classes.iterator();
        JSONArray classNames = new JSONArray();
        JSONArray scores = new JSONArray();

        while (iterator.hasNext()){
            ClassEntity c = iterator.next();
            List<ClassMemberEntity> cms = classMemberDAO.findByClassId(c.getId());

            if (cms.size() > 0){
                int sum = 0;
                for (int i = 0;i < cms.size();i++){
                    sum += cms.get(i).getScores();
                }
                int avg = sum/cms.size();
                classNames.add(c.getName());
                scores.add(avg);
            }

        }

        JSONObject ret = new JSONObject();
        ret.put("classNames",classNames);
        ret.put("scores",scores);

        return ret;
    }

    @RequestMapping(value = "/org_courses_analysis", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getOrgCoursesAnalisis(HttpServletResponse response, HttpServletRequest request,HttpSession session) {
        int orgId = OrgHelper.getCurrentOrgId(session);
        OrganizationEntity org = orgDAO.findOne(orgId);
        Collection<ClassEntity> classes = org.getClasses();
        Iterator<ClassEntity> iterator = classes.iterator();
        JSONArray courses = new JSONArray();
        JSONArray courses_start = new JSONArray();
        JSONArray book = new JSONArray();
        JSONArray unbook = new JSONArray();
        JSONArray learn = new JSONArray();
        JSONArray quit = new JSONArray();
        JSONObject ret = new JSONObject();

        while (iterator.hasNext()){
            ClassEntity c = iterator.next();
            List<ClassMemberEntity> cms = classMemberDAO.findByClassId(c.getId());
            if (cms != null){
                int bookNum = 0;
                int unbookNum = 0;
                int learnNum = 0;
                int quitNum = 0;
                for (int i = 0;i < cms.size();i++){
                    ClassMemberEntity cm = cms.get(i);
                    int state = cm.getState();
                    if (state == 0){
                        bookNum++;
                    }else if (state == 1){
                        unbookNum++;
                    }else if (state == 2 || state == 4){
                        learnNum++;
                    }else {
                        quitNum++;
                    }
                }
                if (learnNum == 0 && quitNum == 0){
                    courses.add(c.getName());
                    book.add(bookNum);
                    unbook.add(-unbookNum);
                }else {
                    courses_start.add(c.getName());
                    learn.add(learnNum);
                    quit.add(-quitNum);
                }

            }
        }


        ret.put("courses",courses);
        ret.put("book",book);
        ret.put("unbook",unbook);
        ret.put("courses_start",courses_start);
        ret.put("learn",learn);
        ret.put("quit",quit);

        return ret;
    }



}
