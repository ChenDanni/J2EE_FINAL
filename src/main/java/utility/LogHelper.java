package utility;

import model.CardEntity;
import model.ChargeLogEntity;
import model.ClassEntity;

import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/10.
 */
public class LogHelper {
    public static int getSysClassId(){
        return 99999999;
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

        return chargeLog;
    }
}
