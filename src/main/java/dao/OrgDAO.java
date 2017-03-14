package dao;

import model.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cdn on 17/3/9.
 */
@Repository
public interface OrgDAO extends JpaRepository<OrganizationEntity,Integer>{

    @Modifying
    @Transactional
    @Query("update OrganizationEntity o set o.balance = ?1 where o.id = ?2")
    int updateOrgBalance(int balance, int id);

}
