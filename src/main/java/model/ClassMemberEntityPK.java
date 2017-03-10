package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cdn on 17/3/10.
 */
public class ClassMemberEntityPK implements Serializable {
    private int classId;
    private int cardId;

    @Column(name = "class_id", nullable = false)
    @Id
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Column(name = "card_id", nullable = false)
    @Id
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassMemberEntityPK that = (ClassMemberEntityPK) o;

        if (classId != that.classId) return false;
        if (cardId != that.cardId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classId;
        result = 31 * result + cardId;
        return result;
    }
}
