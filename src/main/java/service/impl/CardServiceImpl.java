package service.impl;

import dao.*;
import model.CardEntity;
import model.ChargeLogEntity;
import model.ManagerEntity;
import model.RechargeLogEntity;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CardService;
import utility.CardHelper;
import utility.IdHelper;
import utility.LogHelper;
import utility.OperationHelper;
import vo.member.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
@Service
public class CardServiceImpl implements CardService{

    @Autowired
    CardDAO cardDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    ChargeLogDAO chargeLogDAO;
    @Autowired
    ManagerDAO managerDAO;
    @Autowired
    RechargeLogDAO rechargeLogDAO;

    @Override
    public rechargeVO getRecharge(int cardId) {

        CardEntity c = cardDAO.findOne(cardId);
        if (c == null)
            return null;
        rechargeVO vo = new rechargeVO(c.getBalance(),c.getAccountId());

        return vo;
    }

    private List<opVO> getCardOPs(CardEntity c){
        Collection<ChargeLogEntity> charges = chargeLogDAO.findByCardId(c);
        Iterator<ChargeLogEntity> it = charges.iterator();
        List<opVO> ops = new ArrayList<>();
        while (it.hasNext()){
            ChargeLogEntity cl = it.next();
            String opName = OperationHelper.getOperationName(cl.getOperation(),cl.getClassId().getName());
            opVO op = new opVO(opName,cl.getMoney(),cl.getBalance(),cl.getPoints(),cl.getDate());
            ops.add(op);
        }
        return ops;
    }

    @Override
    public cardManageVO getCardManage(int cardId) {

        CardEntity c = cardDAO.findOne(cardId);
        List<opVO> ops = getCardOPs(c);
        cardManageVO vo = new cardManageVO(c.getName(),c.getLevel(),c.getBalance(),c.getPoints(),ops);

        return vo;
    }

    @Override
    public List<opVO> getCardOPs(int cardId) {
        CardEntity c = cardDAO.findOne(cardId);
        return getCardOPs(c);
    }

    @Override
    public boolean addBalance(int cardId, int charge){

        CardEntity c = cardDAO.findOne(cardId);

        int balance = c.getBalance() + charge;
        int recharge = managerDAO.findOne(1).getRecharge();

        int ret = cardDAO.updateCardBalance(balance,cardId);
        managerDAO.updateManagerRecharge(recharge+charge,1);

        if (ret == 0){
            return false;
        }
        c = cardDAO.findOne(cardId);
        ChargeLogEntity chargeLog = LogHelper.getRechargeLog(charge,balance,c,classDAO.findOne(LogHelper.getSysClassId()));
        RechargeLogEntity rechargeLogEntity = LogHelper.getRechargeLogEntity(c,charge,recharge,chargeLog.getDate());

        chargeLogDAO.save(chargeLog);
        rechargeLogDAO.save(rechargeLogEntity);
        return true;
    }

    @Override
    public boolean usePoints(int cardId, int points) {
        CardEntity c = cardDAO.findOne(cardId);
        int charges = CardHelper.getChargeByPoints(points);
        int balance = c.getBalance() + charges;
        int ret = cardDAO.updateCardBalance(balance,cardId);
        cardDAO.updateCardPoints(c.getPoints() - points,cardId);

        if (ret == 0){
            return false;
        }
        c = cardDAO.findOne(cardId);
        ChargeLogEntity chargeLog = LogHelper.getUsePointsChargeLog(charges,balance,c,classDAO.findOne(LogHelper.getSysClassId()));

        chargeLogDAO.save(chargeLog);
        return true;
    }

    @Override
    public usePointsVO getUsePoints(int cardId) {
        CardEntity c = cardDAO.findOne(cardId);
        usePointsVO vo = new usePointsVO(c.getPoints());
        return vo;
    }

    @Override
    public setCardInfoVO getSetCardInfo(int cardId) {
        CardEntity c = cardDAO.findOne(cardId);
        setCardInfoVO vo = new setCardInfoVO(c.getName(),c.getAccountId(),c.getPhone(),c.getPassword());
        return vo;
    }

    @Override
    public boolean updateCardInfo(int id, String name, String accountId, String phone, String password) {
        cardDAO.updateCardInfo(name,accountId,phone,password,id);
        return true;
    }

    @Override
    public int register(String username, String phone, String pwd) {
        int cardId = IdHelper.getCardId();
        CardEntity c = new CardEntity();
        c.setId(cardId);
        c.setName(username);
        c.setPhone(phone);
        c.setPassword(pwd);
        c.setLevel(1);
        cardDAO.save(c);
        return cardId;
    }


}
