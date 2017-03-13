package utility;

import model.*;

import javax.smartcardio.Card;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/10.
 */
public class LogHelper {
    public static int getSysClassId(){
        return 99999999;
    }


    //---------manager---------
    public static RechargeLogEntity getRechargeLogEntity(CardEntity card, int money, int recharge, Timestamp time){
        RechargeLogEntity rechargeLogEntity = new RechargeLogEntity();
        rechargeLogEntity.setCardId(card);
        rechargeLogEntity.setMoney(money);
        rechargeLogEntity.setRecharge(recharge);
        rechargeLogEntity.setTime(time);
        return  rechargeLogEntity;
    }


    //------------member-------
    //上课产生的chargelog
    public static ChargeLogEntity getStudyChargeLog(CardEntity c, ClassEntity classEntity){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(5);
        chargeLog.setMoney(0);
        chargeLog.setDate(time);
        chargeLog.setBalance(c.getBalance());
        chargeLog.setCardId(c);
        chargeLog.setClassId(classEntity);
        chargeLog.setPoints(c.getPoints());

        return chargeLog;
    }

    public static ChargeLogEntity getRechargeLog(int charge, int balance, CardEntity c, ClassEntity sys){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(0);
        chargeLog.setMoney(charge);
        chargeLog.setDate(time);
        chargeLog.setBalance(balance);
        chargeLog.setCardId(c);
        chargeLog.setClassId(sys);
        chargeLog.setPoints(c.getPoints());

        return chargeLog;
    }

    public static ChargeLogEntity getUsePointsChargeLog(int charge, int balance, CardEntity c, ClassEntity sys){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(4);
        chargeLog.setMoney(charge);
        chargeLog.setDate(time);
        chargeLog.setBalance(balance);
        chargeLog.setCardId(c);
        chargeLog.setClassId(sys);
        chargeLog.setPoints(c.getPoints());

        return chargeLog;
    }

    public static ChargeLogEntity getBookChargeLog(CardEntity cardEntity, ClassEntity classEntity){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(1);
        chargeLog.setMoney(-classEntity.getPrice());
        chargeLog.setDate(time);
        chargeLog.setBalance(cardEntity.getBalance());
        chargeLog.setCardId(cardEntity);
        chargeLog.setClassId(classEntity);
        chargeLog.setPoints(cardEntity.getPoints());

        return chargeLog;
    }

    public static ChargeLogEntity getUnbookChargeLog(CardEntity cardEntity, ClassEntity classEntity){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(2);
        chargeLog.setMoney((int)(classEntity.getPrice()*0.9));
        chargeLog.setDate(time);
        chargeLog.setBalance(cardEntity.getBalance());
        chargeLog.setCardId(cardEntity);
        chargeLog.setClassId(classEntity);
        chargeLog.setPoints(cardEntity.getPoints());

        return chargeLog;
    }


    public static ClassMemberEntity getBookCM(int cardId, int classId){
        ClassMemberEntity cm = new ClassMemberEntity();
        cm.setCardId(cardId);
        cm.setClassId(classId);
        cm.setScores(0);
        cm.setState(0);
        return cm;
    }

    public static ClassMemberEntity getUnbookCM(int cardId, int classId){
        ClassMemberEntity cm = new ClassMemberEntity();
        cm.setCardId(cardId);
        cm.setClassId(classId);
        cm.setScores(0);
        cm.setState(1);
        return cm;
    }
}
