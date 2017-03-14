package dao;

import model.OrgLogEntity;
import model.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Repository
public interface OrgLogDAO extends JpaRepository<OrgLogEntity,Integer>{

    @Query("select o from OrgLogEntity o where o.orgId = ?1 order by o.time desc ")
    List<OrgLogEntity> findLogsByOrdId(OrganizationEntity org);


}
