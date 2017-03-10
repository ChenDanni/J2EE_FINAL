package daotest;

import base.BaseTest;
import dao.CardDAO;
import model.CardEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cdn on 17/3/8.
 */
public class CardDAOTest extends BaseTest{



    @Autowired
    CardDAO cardDAO;

//    @Test
    public void testGetCard(){
        System.out.println("in");
        CardEntity card = cardDAO.findOne(1000001);
        System.out.println(card.getName());

    }

    @Test
    public void testUpdateBalance(){
        cardDAO.updateCardBalance(9000,1000001);
        CardEntity card = cardDAO.findOne(1000001);
        System.out.println(card.getBalance());
    }
}
