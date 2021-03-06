package model;

import javax.persistence.*;

/**
 * Created by cdn on 17/3/10.
 */
@Entity
@Table(name = "class_member", schema = "j2ee_final", catalog = "")
@IdClass(ClassMemberEntityPK.class)
public class ClassMemberEntity {
    private int classId;
    private int cardId;
    private int state;
    private int scores;

    @Id
    @Column(name = "class_id", nullable = false)
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Id
    @Column(name = "card_id", nullable = false)
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Basic
    @Column(name = "scores", nullable = false)
    public int getScores() {
        return scores;
    }

    public void setScores(int progress) {
        this.scores = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassMemberEntity that = (ClassMemberEntity) o;

        if (classId != that.classId) return false;
        if (cardId != that.cardId) return false;
        if (state != that.state) return false;
        if (scores != that.scores) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + cardId;
        result = 31 * result + state;
        result = 31 * result + scores;
        return result;
    }
}
