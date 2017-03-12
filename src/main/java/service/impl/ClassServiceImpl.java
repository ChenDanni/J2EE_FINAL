package service.impl;

import dao.ClassDAO;
import dao.ClassMemberDAO;
import dao.OrgDAO;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ClassService;
import vo.member.BookingVO;
import vo.member.courseDetailVO;
import vo.member.courseVO;
import vo.org.applyInfoVO;
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
    public boolean bookCourse(int classId, int cardId) {


        return false;
    }

    @Override
    public boolean applyCourse(classApplyInfo ac) {

        OrganizationEntity org = orgDAO.findOne(ac.orgId);
        ArrayList<LessonEntity> ls = new ArrayList<>();

        ClassEntity c = new ClassEntity();
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

        ClassEntity cl = classDAO.findOne(ac.id);
        for (int i = 0;i < ac.lessons.size();i++){
            lessonInfo li = ac.lessons.get(i);
            LessonEntity l = new LessonEntity();
            l.setName(li.name);
            l.setDescription(li.description);
            l.setClassId(cl);
            l.setOrder(i);
            ls.add(l);
        }
        c.setLessones(ls);
        classDAO.save(c);
        return true;
    }


}
