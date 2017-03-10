package dao;

import model.ChargeLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/10.
 */
@Repository
public interface ChargeLogDAO extends JpaRepository<ChargeLogEntity,Integer> {
}
