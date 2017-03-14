package service;

import vo.manager.BalanceInfoVO;
import vo.manager.RechargeLogVO;

import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
public interface BalanceService {

    public List<RechargeLogVO> getRechargeLog();



    public BalanceInfoVO getBalanceInfo();

}
