package dao;

import model.OrgLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/14.
 */
@Repository
public interface OrgLogDAO extends JpaRepository<OrgLogEntity,Integer>{
}
