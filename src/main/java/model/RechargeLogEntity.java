package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/13.
 */
@Entity
@Table(name = "recharge_log", schema = "j2ee_final", catalog = "")
public class RechargeLogEntity {
    private int id;
    private Timestamp time;
    private Integer money;
    private Integer recharge;
    private CardEntity cardId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "money", nullable = true)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "recharge", nullable = true)
    public Integer getRecharge() {
        return recharge;
    }

    public void setRecharge(Integer recharge) {
        this.recharge = recharge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RechargeLogEntity that = (RechargeLogEntity) o;

        if (id != that.id) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (recharge != null ? !recharge.equals(that.recharge) : that.recharge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (recharge != null ? recharge.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false)
    public CardEntity getCardId() {
        return cardId;
    }

    public void setCardId(CardEntity cardId) {
        this.cardId = cardId;
    }
}
