package dao;

import model.OrgLogEntity;
import model.OrghandleLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/14.
 */
@Repository
public interface OrgHandleLogDAO extends JpaRepository<OrghandleLogEntity,Integer>{
}
