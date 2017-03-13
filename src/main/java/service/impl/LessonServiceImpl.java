package service.impl;

import dao.LessonDAO;
import model.LessonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LessonService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdn on 17/3/13.
 */
@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    LessonDAO lessonDAO;

    @Override
    public List<String> getLessonName(List<Integer> lessonIds) {
        List<String> names = new ArrayList<>();

        for (int i = 0;i < lessonIds.size();i++){
            LessonEntity l = lessonDAO.findOne(lessonIds.get(i));
            names.add(l.getName());
        }
        return names;
    }

    @Override
    public String getLessonName(int lessonId) {
        LessonEntity l = lessonDAO.findOne(lessonId);
        return l.getName();
    }
}
