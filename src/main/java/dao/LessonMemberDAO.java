package dao;

import model.LessonMemberEntity;
import model.LessonMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public interface LessonMemberDAO extends JpaRepository<LessonMemberEntity, LessonMemberEntityPK>{

    List<LessonMemberEntity> findByCardIdOrderByLessonIdAsc(int cardId);

    @Modifying
    @Transactional
    @Query("update LessonMemberEntity lm set lm.attendance = ?1 where lm.cardId = ?2 and lm.lessonId = ?3")
    int updateAttendance(int attendance, int cardId, int lessonId);

    LessonMemberEntity findByLessonIdAndCardId(int lessonId, int cardId);

}
