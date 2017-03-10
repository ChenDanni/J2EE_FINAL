package dao;

import model.ClassMemberEntity;
import model.ClassMemberEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/10.
 */
@Repository
public interface ClassMemberDAO extends JpaRepository<ClassMemberEntity, ClassMemberEntityPK>{
}
