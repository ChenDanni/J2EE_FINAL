package model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by cdn on 17/3/14.
 */
@Entity
@Table(name = "org_log", schema = "j2ee_final", catalog = "")
public class OrgLogEntity {
    private int id;
    private int type;
    private Integer money;
    private int balance;
    private Timestamp time;
    private CardEntity cardId;
    private ClassEntity classId;
    private OrganizationEntity orgId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
    @Column(name = "balance", nullable = false)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrgLogEntity that = (OrgLogEntity) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (balance != that.balance) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type;
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + balance;
        result = 31 * result + (time != null ? time.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "id", nullable = false)
    public OrganizationEntity getOrgId() {
        return orgId;
    }

    public void setOrgId(OrganizationEntity orgId) {
        this.orgId = orgId;
    }
}
