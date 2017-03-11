package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/9.
 */
@Entity
@Table(name = "charge_log", schema = "j2ee_final", catalog = "")
public class ChargeLogEntity {
    private int id;
    private int operation;
    private int money;
    private Timestamp date;
    private int balance;
    private int points;
    private CardEntity cardId;
    private ClassEntity classId;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "operation", nullable = false)
    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
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


    @Basic
    @Column(name = "balance", nullable = false)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargeLogEntity that = (ChargeLogEntity) o;

        if (id != that.id) return false;
        if (money != that.money) return false;
        if (operation != that.operation) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (balance != that.balance) return false;
        if (points != that.points) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + money;
        result = 31 * result + operation;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + balance;
        result = 31 * result + points;

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

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    public ClassEntity getClassId() {
        return classId;
    }

    public void setClassId(ClassEntity classId) {
        this.classId = classId;
    }
}
