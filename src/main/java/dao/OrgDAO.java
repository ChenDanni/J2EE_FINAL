package dao;

import model.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/9.
 */
@Repository
public interface OrgDAO extends JpaRepository<OrganizationEntity,Integer>{
}
