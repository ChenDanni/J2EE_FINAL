package service.impl;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClassService;
import utility.IdHelper;
import vo.manager.applicationHandleVO;
import vo.member.BookingVO;
import vo.member.LearningVO;
import vo.member.courseDetailVO;
import vo.member.courseVO;
import vo.org.applyInfoVO;
import vo.org.attendanceVO;
import vo.org.classApplyInfo;
import vo.org.lessonInfo;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    ClassDAO classDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;
    @Autowired
    OrgDAO orgDAO;
    @Autowired
    LessonDAO lessonDAO;
    @Autowired
    LessonMemberDAO lessonMemberDAO;
    @Autowired
    CardDAO cardDAO;


    private List<courseVO> entityToVO(List<ClassEntity> classEntities){
        List<courseVO> ret = new ArrayList<>();

        for (int i = 0;i < classEntities.size();i++) {
            ClassEntity c = classEntities.get(i);
            String orgName = c.getOrgId().getName();
            courseVO vo = new courseVO(c.getId(),c.getName(), c.getPrice(), c.getMemberNum(), c.getLeftMembers(), c.getLearnTime(), orgName, c.getTime());
            ret.add(vo);
        }
        return ret;
    }

    @Override
    public boolean setApplicationSuccess(int classId) {
        classDAO.updateClassState(1,classId);
        return true;
    }

    @Override
    public boolean setApplicationFail(int classId) {
        classDAO.updateClassState(2,classId);
        return true;
    }

    @Override
    public List<applicationHandleVO> getApplicationHandle() {
        List<ClassEntity> c = classDAO.findAllClassesOrderByTimeDesc();
        List<applicationHandleVO> vos = new ArrayList<>();
        for (int i = 0;i < c.size();i++){
            ClassEntity e = c.get(i);
            applicationHandleVO vo = new applicationHandleVO(e.getId(),e.getName(),e.getOrgId().getName(),e.getState(),e.getTime());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public boolean startCourse(int classId) {
        int cState = classDAO.updateClassState(3,classId);
        int cmState = classMemberDAO.updateClassMemberStateByClassId(2,classId);
        ClassEntity c = classDAO.findOne(classId);
        List<Integer> cardIds = classMemberDAO.findCardByClassId(classId);
        List<LessonEntity> lessons = lessonDAO.findByClassId(c);

        for (int i = 0;i < cardIds.size();i++){
            for (int j = 0;j < lessons.size();j++){
                LessonMemberEntity lm = new LessonMemberEntity();
                lm.setCardId(cardIds.get(i));
                lm.setAttendance(0);
                lm.setLessonId(lessons.get(j).getId());
                lessonMemberDAO.save(lm);
            }
        }
        return true;
    }

    @Override
    public List<courseVO> getStartCourse(int orgId) {
        OrganizationEntity org = orgDAO.findOne(orgId);
        List<ClassEntity> classEntities = classDAO.findByOrgIdAndState(org,3);
        return entityToVO(classEntities);
    }

    @Override
    public List<applyInfoVO> getApplyInfo(int orgId) {

        OrganizationEntity org = orgDAO.findOne(orgId);
        List<ClassEntity> cs = classDAO.findClassesByOrg(org);
        List<applyInfoVO> vos = new ArrayList<>();
        for (int i = 0;i < cs.size();i++){
            ClassEntity c = cs.get(i);
            applyInfoVO vo = new applyInfoVO(c.getId(),c.getName(),c.getState());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<courseVO> getAllCoursesBrief() {
        List<ClassEntity> classEntities = classDAO.findByState(1);

        return entityToVO(classEntities);
    }

    @Override
    public List<courseVO> getOrgCoursesBrief(int orgId) {
        OrganizationEntity org = orgDAO.findOne(orgId);
        List<ClassEntity> classEntities = classDAO.findClassesByOrg(org);
        return entityToVO(classEntities);
    }

    @Override
    public courseDetailVO getCourseDetail(int courseId, int cardId) {
        ClassEntity c = classDAO.findOne(courseId);
        ClassMemberEntityPK classMemberEntityId = new ClassMemberEntityPK();
        classMemberEntityId.setClassId(courseId);
        classMemberEntityId.setCardId(cardId);
        ClassMemberEntity cm = classMemberDAO.findOne(classMemberEntityId);

        int state;

        if (c == null)
            return null;
        if (cm == null){
            state = -1;
        }else {
            state = cm.getState();
        }

        if (cardId == -1){
            state = c.getState();
        }
        String orgName = c.getOrgId().getName();

        courseDetailVO vo = new courseDetailVO(c.getId(), c.getMemberNum(), c.getLeftMembers(), state,c.getName(),c.getPrice(),c.getLearnTime(),orgName,c.getTeacher(),c.getDescription(),c.getTime());
        return vo;
    }

    @Override
    public List<BookingVO> getBookings(int cardId) {
        List<BookingVO> vos = new ArrayList<>();
        Collection<ClassMemberEntity> cms = classMemberDAO.findByCardIdAndState(cardId,0);
        Iterator<ClassMemberEntity> it = cms.iterator();
        while(it.hasNext()){
            ClassMemberEntity cm = it.next();
            int classId = cm.getClassId();
            ClassEntity c = classDAO.findOne(classId);
            BookingVO vo = new BookingVO(c.getId(),c.getName(),c.getPrice(),c.getMemberNum(), c.getLeftMembers(),c.getLearnTime(),c.getOrgId().getName(),c.getTime());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<LearningVO> getLearnings(int cardId,int type) {

        List<LearningVO> vos = new ArrayList<>();
        Collection<ClassMemberEntity> cms;
        if (type == 0){
            //learning
            cms = classMemberDAO.findByCardIdAndState(cardId,2);
        }else if (type == 1){
            //finishing
            cms = classMemberDAO.findByCardIdAndState(cardId,4);
        }else if (type == 2) {
            //quiting
            cms = classMemberDAO.findByCardIdAndState(cardId,3);
        }else{
            return vos;
        }
        Iterator<ClassMemberEntity> it = cms.iterator();
        while(it.hasNext()){
            ClassMemberEntity cm = it.next();
            int classId = cm.getClassId();
            ClassEntity c = classDAO.findOne(classId);

            List<LessonMemberEntity> lm = lessonMemberDAO.findByCardIdOrderByLessonIdAsc(cardId);
            List<Integer> lessonId = new ArrayList<>();
            List<Integer> attendances = new ArrayList<>();

            for (int i = 0;i < lm.size();i++){
                lessonId.add(lm.get(i).getLessonId());
                attendances.add(lm.get(i).getAttendance());
            }
            CardEntity card = cardDAO.findOne(cardId);
            attendanceVO a = new attendanceVO(cardId,card.getState(),c.getName(),lessonId,attendances,cm.getScores());

            LearningVO vo = new LearningVO(c.getId(),c.getName(),c.getPrice(),
                    c.getMemberNum()- c.getLeftMembers(),c.getLearnTime(),c.getOrgId().getName(),c.getTime(),a);
            vos.add(vo);
        }

        return vos;
    }

    @Override
    public boolean bookCourse(int classId, int cardId) {


        return false;
    }

    @Override
    public boolean applyCourse(classApplyInfo ac) {

        OrganizationEntity org = orgDAO.findOne(ac.orgId);
        ArrayList<LessonEntity> ls = new ArrayList<>();

        ClassEntity c = new ClassEntity();
        c.setId(ac.id);
        c.setName(ac.name);
        c.setTime(ac.time);
        c.setTeacher(ac.teacher);
        c.setPrice(ac.price);
        c.setMemberNum(ac.memberNum);
        c.setState(0);
        c.setDescription(ac.description);
        c.setLearnTime(ac.learnTime);
        c.setLeftMembers(ac.memberNum);
        c.setOrgId(org);
        classDAO.saveAndFlush(c);

        ClassEntity cl = classDAO.findOne(ac.id);
        System.err.println("had find cl");
//        c.setLessones(ls);

        for (int i = 0;i < ac.lessons.size();i++){
            lessonInfo li = ac.lessons.get(i);
            LessonEntity l = new LessonEntity();
            l.setName(li.name);
            l.setDescription(li.description);
            l.setClassId(cl);
            l.setOrder(i);
            l.setId(IdHelper.getLessonId());
            lessonDAO.save(l);
            ls.add(l);
        }
        return true;
    }


}
