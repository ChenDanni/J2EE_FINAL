package dao;

import model.MemberhandleLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
public interface MemberHandleLogDAO extends JpaRepository<MemberhandleLogEntity,Integer>{

    @Query("select m from MemberhandleLogEntity m order by m.time desc ")
    List<MemberhandleLogEntity> findAllLogsOrderByTimeDesc();
}
