package service.impl;

import dao.CardDAO;
import model.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CardService;
import vo.member.rechargeVO;

/**
 * Created by cdn on 17/3/10.
 */
@Service
public class CardServiceImpl implements CardService{

    @Autowired
    CardDAO cardDAO;

    @Override
    public rechargeVO getRecharge(int cardId) {

        CardEntity c = cardDAO.findOne(cardId);
        if (c == null)
            return null;

        rechargeVO vo = new rechargeVO(c.getBalance(),c.getAccountId());

        return vo;
    }
}
