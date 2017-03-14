package dao;

import model.ClassEntity;
import model.LessonEntity;
import model.LessonMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cdn on 17/3/11.
 */
@Repository
public interface LessonDAO extends JpaRepository<LessonEntity, Integer>{

    List<LessonEntity> findByClassId(ClassEntity classId);

    List<LessonEntity> findByClassIdOrderByIdAsc(ClassEntity classEntity);

}
