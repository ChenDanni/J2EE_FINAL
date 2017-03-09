package model;

import javax.persistence.*;

/**
 * Created by cdn on 17/3/9.
 */
@Entity
@Table(name = "class_member", schema = "j2ee_final", catalog = "")
@IdClass(ClassMemberEntityPK.class)
public class ClassMemberEntity {
    private int classId;
    private int cardId;
    private int state;
    private Integer progress;

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
    @Column(name = "progress", nullable = true)
    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassMemberEntity that = (ClassMemberEntity) o;

        if (classId != that.classId) return false;
        if (cardId != that.cardId) return false;
        if (state != that.state) return false;
        if (progress != null ? !progress.equals(that.progress) : that.progress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + cardId;
        result = 31 * result + state;
        result = 31 * result + (progress != null ? progress.hashCode() : 0);
        return result;
    }
}
