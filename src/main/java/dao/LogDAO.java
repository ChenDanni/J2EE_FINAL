package dao;

import model.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cdn on 17/3/14.
 */
@Repository
public interface LogDAO extends JpaRepository<LogEntity,Integer>{

    LogEntity findByCardIdAndClassId(int cardId,int classId);

    @Query("select log from LogEntity log order by log.time desc ")
    List<LogEntity> findAllLogs();

    @Modifying
    @Transactional
    @Query("update LogEntity l set l.moneyBack = ?1, l.state = ?2 where l.classId = ?3 and l.cardId = ?4")
    int updateLog(int moneyback, int state, int classId, int cardId);

    @Modifying
    @Transactional
    @Query("update LogEntity l set l.moneyAccount = ?1, l.state = ?2 where l.classId = ?3 and l.cardId = ?4")
    int updateLogOrg(int money_account, int state, int classId, int cardId);

}
