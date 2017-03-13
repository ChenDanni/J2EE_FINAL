package dao;

import model.CardEntity;
import model.ClassMemberEntity;
import model.ClassMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
@Repository
public interface ClassMemberDAO extends JpaRepository<ClassMemberEntity, ClassMemberEntityPK>{

    Collection<ClassMemberEntity> findByCardIdAndState(int cardId, int state);

    List<ClassMemberEntity> findByClassId(int classId);

    @Modifying
    @Transactional
    @Query("update ClassMemberEntity cm set cm.state = ?1 where cm.classId = ?2")
    int updateClassMemberStateByClassId(int state, int classId);

    @Query("select cm.cardId from ClassMemberEntity cm where cm.classId = ?1")
    List<Integer> findCardByClassId(int classId);


    @Modifying
    @Transactional
    @Query("update ClassMemberEntity cm set cm.scores = ?1 where cm.cardId = ?2 and cm.classId = ?3")
    int updateScore(int score, int cardId, int classId);

    @Modifying
    @Transactional
    @Query("update ClassMemberEntity cm set cm.state = ?1 where cm.classId = ?2 and cm.cardId = ?3")
    int updateClassMemberState(int state,int classId,int cardId);


}
