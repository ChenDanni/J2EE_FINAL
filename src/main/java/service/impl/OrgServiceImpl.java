package service.impl;

import dao.CardDAO;
import dao.ClassDAO;
import dao.ClassMemberDAO;
import dao.LessonMemberDAO;
import model.CardEntity;
import model.ClassEntity;
import model.ClassMemberEntity;
import model.LessonMemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrgService;
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

    @Override
    public recordDetailVO getRecordDetail(int classId) {

        ClassEntity c = classDAO.findOne(classId);
        String name = c.getName();
        int totalMember = c.getMemberNum() - c.getLeftMembers();
        int price = c.getPrice();
        String learn_time = c.getLearnTime();
        Date start_time = c.getTime();
        List<attendanceVO> vos = new ArrayList<>();

        List<Integer> cardIds = classMemberDAO.findCardByClassId(classId);
        for (int i = 0;i < cardIds.size();i++){
            CardEntity card = cardDAO.findOne(cardIds.get(i));
            List<LessonMemberEntity> lm = lessonMemberDAO.findByCardIdOrderByAttendanceAsc(cardIds.get(i));
            List<Integer> ab = new ArrayList<>();
            for (int j = 0;j < lm.size();j++){
                ab.add(lm.get(j).getAttendance());
            }
            attendanceVO at = new attendanceVO(cardIds.get(i),card.getName(),ab);
            vos.add(at);
        }
        recordDetailVO ret = new recordDetailVO(name,totalMember,price,learn_time,start_time,vos);
        return ret;
    }
}
