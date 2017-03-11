package service;

import vo.member.*;

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

    public setCardInfoVO getSetCardInfo(int cardId);

    public boolean updateCardInfo(int id, String name, String accountId, String phone, String password);

    public int register(String username, String phone, String pwd);
}
