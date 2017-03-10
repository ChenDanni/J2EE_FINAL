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

}
