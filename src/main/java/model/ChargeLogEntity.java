package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by user on 17/3/2.
 */
@Entity
@Table(name = "charge_log", schema = "j2ee_final", catalog = "")
public class ChargeLogEntity {
    private int id;
    private int money;
    private Timestamp date;
    private CardEntity cardBycardId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "money", nullable = false)
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargeLogEntity that = (ChargeLogEntity) o;

        if (id != that.id) return false;
        if (money != that.money) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + money;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id", nullable = false)
    public CardEntity getCardBycardId() {
        return cardBycardId;
    }

    public void setCardBycardId(CardEntity cardBycardId) {
        this.cardBycardId = cardBycardId;
    }
}
