package service.impl;

import dao.*;
import model.CardEntity;
import model.ChargeLogEntity;
import model.ClassEntity;
import model.LessonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RecordService;
import utility.LogHelper;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    LessonMemberDAO lessonMemberDAO;
    @Autowired
    ClassMemberDAO classMemberDAO;
    @Autowired
    LessonDAO lessonDAO;
    @Autowired
    CardDAO cardDAO;
    @Autowired
    ChargeLogDAO chargeLogDAO;

    private void addLog(int cardId, int lessonId){
        //增加学员的point和consume
        CardEntity card = cardDAO.findOne(cardId);
        LessonEntity lesson = lessonDAO.findOne(lessonId);
        ClassEntity classEntity = lesson.getClassId();
        int classId = classEntity.getId();
        int price = classEntity.getPrice();
        List<LessonEntity> lessons = lessonDAO.findByClassId(classEntity);
        int lessonNum = lessons.size();
        int point = (int)((price*0.01)/lessonNum) + card.getPoints();
        int consume = (int)(price/lessonNum) + card.getConsume();
        cardDAO.updateCardPoints(point,cardId);
        cardDAO.updateCardConsume(consume,cardId);

        //增加charge_log
        card = cardDAO.findOne(cardId);
        ChargeLogEntity chargeLogEntity = LogHelper.getStudyChargeLog(card,classEntity);
        chargeLogDAO.save(chargeLogEntity);
    }

    @Override
    public boolean setAttend(int cardId, int lessonId) {

        //更新学员课程记录
        lessonMemberDAO.updateAttendance(1,cardId,lessonId);

        addLog(cardId,lessonId);
        return true;
    }

    @Override
    public boolean setAbsence(int cardId, int lessonId) {

        lessonMemberDAO.updateAttendance(2,cardId,lessonId);
        addLog(cardId,lessonId);

        return false;
    }

    @Override
    public boolean setScore(int score, int cardId, int classId){
        classMemberDAO.updateScore(score,cardId,classId);
        //设置classmember状态为4 (已完成课)
        classMemberDAO.updateClassMemberState(4,classId,cardId);
        return true;
    }
}
