package vo.org;

import model.ClassEntity;

/**
 * Created by cdn on 17/3/11.
 */
public class lessonInfo {
    public String name;
    public int order;
    public String description;
    public int classId;

    public lessonInfo(String name, int order, String description, int classId) {
        this.name = name;
        this.order = order;
        this.description = description;
        this.classId = classId;
    }
}
