package dao;

import model.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cdn on 17/3/13.
 */
@Repository
public interface ManagerDAO extends JpaRepository<ManagerEntity,Integer>{

    @Modifying
    @Transactional
    @Query("update ManagerEntity m set m.recharge = ?1 where m.id = ?2")
    int updateManagerRecharge(int recharge, int id);

}
