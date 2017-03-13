package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/13.
 */
@Entity
@Table(name = "log", schema = "j2ee_final", catalog = "")
@IdClass(LogEntityPK.class)
public class LogEntity {
    private int cardId;
    private int classId;
    private Timestamp time;
    private Integer state;
    private Integer money;

    @Id
    @Column(name = "card_id", nullable = false)
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Id
    @Column(name = "class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
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
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "money", nullable = true)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (cardId != logEntity.cardId) return false;
        if (classId != logEntity.classId) return false;
        if (time != null ? !time.equals(logEntity.time) : logEntity.time != null) return false;
        if (state != null ? !state.equals(logEntity.state) : logEntity.state != null) return false;
        if (money != null ? !money.equals(logEntity.money) : logEntity.money != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + classId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        return result;
    }
}
