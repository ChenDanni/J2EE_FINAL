package dao;

import model.MemberhandleLogEntity;
import model.OrgLogEntity;
import model.OrghandleLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Repository
public interface OrgHandleLogDAO extends JpaRepository<OrghandleLogEntity,Integer>{

    @Query("select m from OrghandleLogEntity m order by m.time desc ")
    List<OrghandleLogEntity> findAllLogsOrderByTimeDesc();
}
