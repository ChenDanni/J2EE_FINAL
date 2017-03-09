package service.impl;

import dao.CardDAO;
import model.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserManagerService;

/**
 * Created by cdn on 17/3/8.
 */
@Service
public class UserManagerServiceImpl implements UserManagerService{
    @Autowired
    CardDAO cardDAO;


    @Override
    public boolean validateLogin(int id, String pwd) {

        CardEntity card = cardDAO.findOne(id);
        String password = card.getPassword();
        if (password.equals(pwd))
            return true;

        return false;
    }
}
