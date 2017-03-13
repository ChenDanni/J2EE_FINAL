package dao;

import model.RechargeLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
public interface RechargeLogDAO extends JpaRepository<RechargeLogEntity,Integer>{

    @Query("select r from RechargeLogEntity r order by r.time desc ")
    List<RechargeLogEntity> getRechargeLogs();

}
