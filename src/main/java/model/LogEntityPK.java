package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cdn on 17/3/13.
 */
public class LogEntityPK implements Serializable {
    private int cardId;
    private int classId;

    @Column(name = "card_id", nullable = false)
    @Id
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Column(name = "class_id", nullable = false)
    @Id
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntityPK that = (LogEntityPK) o;

        if (cardId != that.cardId) return false;
        if (classId != that.classId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + classId;
        return result;
    }
}
