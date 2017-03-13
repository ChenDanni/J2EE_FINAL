package dao;

import model.CardEntity;
import model.ChargeLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by cdn on 17/3/10.
 */
@Repository
public interface ChargeLogDAO extends JpaRepository<ChargeLogEntity,Integer> {


    @Query("select c from ChargeLogEntity c where c.cardId = ?1 order by c.date desc ")
    Collection<ChargeLogEntity> findByCardId(CardEntity cardId);

}
