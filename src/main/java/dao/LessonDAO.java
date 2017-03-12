package dao;

import model.LessonEntity;
import model.LessonMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/11.
 */
@Repository
public interface LessonDAO extends JpaRepository<LessonEntity, LessonMemberEntityPK>{
}
