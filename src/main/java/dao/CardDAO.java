package dao;

import model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cdn on 17/3/8.
 */
@Repository
public interface CardDAO extends JpaRepository<CardEntity, Integer>{

}
