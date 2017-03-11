package service;

import vo.member.cardManageVO;
import vo.member.opVO;
import vo.member.rechargeVO;
import vo.member.usePointsVO;

import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
public interface CardService {

    public rechargeVO getRecharge(int cardId);

    public cardManageVO getCardManage(int cardId);

    public List<opVO> getCardOPs(int cardId);

    public boolean addBalance(int cardId, int charge);

    public boolean usePoints(int cardId, int points);

    public usePointsVO getUsePoints(int cardId);

}
