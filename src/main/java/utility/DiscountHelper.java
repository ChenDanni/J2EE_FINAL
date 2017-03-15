package utility;

import model.ChargeLogEntity;

import java.util.List;

/**
 * Created by cdn on 17/3/15.
 */
public class DiscountHelper {

    public static double getDiscount(int level){
        double[] discount = {1,1,0.98,0.95,0.9};
        return discount[level];
    }
    public static ChargeLogEntity getBookChargeLog(List<ChargeLogEntity> chs, int classId){
        ChargeLogEntity ch = new ChargeLogEntity();
        for (int i = 0;i < chs.size();i++){
            int op = chs.get(i).getOperation();
            if (op == 1){
                return chs.get(i);
            }
        }
        return ch;
    }
}
