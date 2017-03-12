package dao;

import model.LessonMemberEntity;
import model.LessonMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

/**
 * Created by cdn on 17/3/12.
 */
@Controller
public interface LessonMemberDAO extends JpaRepository<LessonMemberEntity, LessonMemberEntityPK>{
}
