package dao;

import model.MemberhandleLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cdn on 17/3/14.
 */
public interface MemberHandleLogDAO extends JpaRepository<MemberhandleLogEntity,Integer>{
}
