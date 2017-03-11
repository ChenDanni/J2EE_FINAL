package dao;

import model.ClassMemberEntity;
import model.ClassMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Collection;

/**
 * Created by cdn on 17/3/10.
 */
@Repository
public interface ClassMemberDAO extends JpaRepository<ClassMemberEntity, ClassMemberEntityPK>{

    Collection<ClassMemberEntity> findByCardIdAndState(int cardId, int state);


}
