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

    //---------org---------
    public static OrgLogEntity getOrgLogEntity(CardEntity card,ClassEntity classEntity, OrganizationEntity org,
                                               int money, int balance, int type){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        OrgLogEntity o = new OrgLogEntity();
        o.setTime(time);
        o.setCardId(card);
        o.setClassId(classEntity);
        o.setMoney(money);
        o.setBalance(balance);
        o.setOrgId(org);
        o.setType(type);
        return o;
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

    //退课logentity
    public static LogEntity getLogEntity(int money,int classId,int cardId,int total,int finish){
        LogEntity log = new LogEntity();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        log.setTime(time);
        log.setMoney(money);
        log.setClassId(classId);
        log.setCardId(cardId);
        log.setState(0);
        log.setTotal(total);
        log.setFinish(finish);
        return log;
    }
    public static LogEntity getFinishLogEntity(int money,int classId,int cardId){
        LogEntity log = new LogEntity();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        log.setTime(time);
        log.setMoney(money);
        log.setClassId(classId);
        log.setCardId(cardId);
        log.setState(4);
        log.setTotal(1);
        log.setFinish(1);
        return log;
    }

    public static MemberhandleLogEntity getMemberHandleLogEntity(CardEntity cardEntity,
                                                                 int memberhandle,
                                                                 ClassEntity classEntity, int money, Timestamp time){
        MemberhandleLogEntity m = new MemberhandleLogEntity();
        m.setCardId(cardEntity);
        m.setMoney(money);
        m.setClassId(classEntity);
        m.setTime(time);
        m.setMemberhandle(memberhandle);
        return m;
    }

    public static OrghandleLogEntity getOrgHandleLogEntity(OrganizationEntity org, int money,
                                                           int orghandle,
                                                           ClassEntity classEntity, Timestamp time){
        OrghandleLogEntity o = new OrghandleLogEntity();
        o.setOrgId(org);
        o.setMoney(money);
        o.setClassId(classEntity);
        o.setTime(time);
        o.setOrghandle(orghandle);
        return o;
    }



    //------------member-------
    //退课chargelog
    public static ChargeLogEntity getQuitClassChargeLog(int money,int balance,CardEntity c,ClassEntity classEntity){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(3);
        chargeLog.setMoney(money);
        chargeLog.setDate(time);
        chargeLog.setBalance(balance);
        chargeLog.setCardId(c);
        chargeLog.setClassId(classEntity);
        chargeLog.setPoints(c.getPoints());

        return chargeLog;
    }

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

    public static ChargeLogEntity getBookChargeLog(CardEntity cardEntity, ClassEntity classEntity,int money){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ChargeLogEntity chargeLog = new ChargeLogEntity();
        chargeLog.setOperation(1);
        chargeLog.setMoney(money);
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
