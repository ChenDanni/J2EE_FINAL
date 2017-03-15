package dao;

import model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cdn on 17/3/8.
 */
@Repository
public interface CardDAO extends JpaRepository<CardEntity, Integer>{

    @Modifying
    @Transactional
    @Query("update CardEntity card set card.balance = ?1 where card.id = ?2")
    int updateCardBalance(int balance, int id);

    @Modifying
    @Transactional
    @Query("update CardEntity card set card.points = ?1 where card.id = ?2")
    int updateCardPoints(int points, int id);

    @Modifying
    @Transactional
    @Query("update CardEntity card set card.consume = ?1 where card.id = ?2")
    int updateCardConsume(int consume, int id);

    @Modifying
    @Transactional
    @Query("update CardEntity card set card.level = ?1 where card.id = ?2")
    int updateCardLevel(int level, int id);

    @Modifying
    @Transactional
    @Query("update CardEntity card set card.state = ?1 where card.id = ?2")
    int updateCardState(int state, int id);

    @Modifying
    @Transactional
    @Query("update CardEntity c set c.name = ?1, c.accountId = ?2, c.phone = ?3, c.password = ?4 where c.id = ?5")
    int updateCardInfo(String name, String accountId, String phone, String password, int id);


}
