package dao;

import model.ClassEntity;
import model.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by cdn on 17/3/9.
 */
@Repository
public interface ClassDAO extends JpaRepository<ClassEntity,Integer>{

    @Modifying
    @Transactional
    @Query("update ClassEntity c set c.leftMembers = ?1 where c.id = ?2")
    int updateClassLeftMember(int leftMember, int id);

    @Modifying
    @Transactional
    @Query("update ClassEntity c set c.state = ?1 where c.id = ?2")
    int updateClassState(int state, int id);


    @Query("select c from ClassEntity c where c.orgId = ?1")
    List<ClassEntity> findClassesByOrg(OrganizationEntity org);

    List<ClassEntity> findByState(int state);

    List<ClassEntity> findByOrgIdAndState(OrganizationEntity orgId, int state);

    @Query("select c from ClassEntity c order by c.time desc ")
    List<ClassEntity> findAllClassesOrderByTimeDesc();


}
