package service.impl;

import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrgService;
import vo.org.accountInfoVO;
import vo.org.accountOPVO;
import vo.org.attendanceVO;
import vo.org.recordDetailVO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Service
public class OrgServiceImpl implements OrgService{

    @Autowired
    ClassDAO classDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;
    @Autowired
    LessonMemberDAO lessonMemberDAO;
    @Autowired
    CardDAO cardDAO;
    @Autowired
    OrgDAO orgDAO;
    @Autowired
    OrgLogDAO orgLogDAO;
    @Autowired
    LessonDAO lessonDAO;

    private List<attendanceVO> getAttendanceVO(int classId){
        List<Integer> cardIds = classMemberDAO.findCardByClassId(classId);
        List<attendanceVO> vos = new ArrayList<>();
        ClassEntity classEntity = classDAO.findOne(classId);
        List<LessonEntity> lessons = lessonDAO.findByClassIdOrderByIdAsc(classEntity);

        for (int i = 0;i < cardIds.size();i++){
            CardEntity card = cardDAO.findOne(cardIds.get(i));

            ClassMemberEntityPK cmpk = new ClassMemberEntityPK();
            cmpk.setCardId(card.getId());
            cmpk.setClassId(classId);
            ClassMemberEntity cm = classMemberDAO.findOne(cmpk);

            List<Integer> lessonIds = new ArrayList<>();
            List<Integer> ab = new ArrayList<>();

            for(int j = 0;j < lessons.size();j++){
                LessonMemberEntity lm = lessonMemberDAO.findByLessonIdAndCardId(lessons.get(j).getId(),card.getId());
                lessonIds.add(lm.getLessonId());
                ab.add(lm.getAttendance());
            }

            attendanceVO at = new attendanceVO(cardIds.get(i),card.getName(),lessonIds,ab,cm.getScores());
            vos.add(at);
        }
        return vos;
    }

    @Override
    public recordDetailVO getRecordDetail(int classId) {

        ClassEntity c = classDAO.findOne(classId);
        String name = c.getName();
        int totalMember = c.getMemberNum() - c.getLeftMembers();
        int price = c.getPrice();
        String learn_time = c.getLearnTime();
        Date start_time = c.getTime();
        List<attendanceVO> vos = getAttendanceVO(classId);
        recordDetailVO ret = new recordDetailVO(name,totalMember,price,learn_time,start_time,vos);
        return ret;
    }

    @Override
    public List<accountOPVO> getAccountOPs(int orgId) {
        OrganizationEntity org = orgDAO.findOne(orgId);
        List<OrgLogEntity> logs = orgLogDAO.findLogsByOrgId(org);
        List<accountOPVO> vos = new ArrayList<>();
        for (int i = 0;i < logs.size();i++){
            OrgLogEntity log = logs.get(i);
            String className = log.getClassId().getName();
            accountOPVO vo = new accountOPVO(log.getClassId().getId(),className,
                    log.getType(), log.getMoney(),log.getBalance(),log.getTime(),
                    log.getCardId().getId());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public accountInfoVO getAccountInfo(int orgId) {
        OrganizationEntity o = orgDAO.findOne(orgId);
        accountInfoVO vo = new accountInfoVO(o.getBalance());
        return vo;
    }
}
