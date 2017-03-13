package service.impl;

import dao.ManagerDAO;
import dao.RechargeLogDAO;
import model.ManagerEntity;
import model.RechargeLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BalanceService;
import vo.manager.BalanceInfoVO;
import vo.manager.RechargeLogVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Service
public class BalanceServiceImpl implements BalanceService{

    @Autowired
    RechargeLogDAO rechargeLogDAO;
    @Autowired
    ManagerDAO managerDAO;

    @Override
    public List<RechargeLogVO> getRechargeLog() {
        List<RechargeLogEntity> rs = rechargeLogDAO.getRechargeLogs();
        List<RechargeLogVO> vos = new ArrayList<>();
        for (int i = 0;i < rs.size();i++){
            RechargeLogEntity r = rs.get(i);
            RechargeLogVO vo = new RechargeLogVO(r.getCardId().getId(),r.getMoney(),r.getTime(),r.getRecharge());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public BalanceInfoVO getBalanceInfo() {
        ManagerEntity m = managerDAO.findOne(1);

        int recharge = m.getRecharge();
        int mh = m.getMemberHandle();
        int oh = m.getOrgHandle();

        BalanceInfoVO vo = new BalanceInfoVO(recharge,mh,oh);

        return vo;
    }
}
