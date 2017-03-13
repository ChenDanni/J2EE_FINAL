package utility;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.javafx.jmx.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.ui.ModelMap;
import vo.member.courseDetailVO;
import vo.member.courseVO;

import java.io.IOException;
import java.util.List;

/**
 * Created by cdn on 17/3/9.
 */
public class JSONHelper {

    public static String getJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(obj);
            return jsonInString;

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONArray courseVOsToJson(List<courseVO> vos){
        JSONArray ret = new JSONArray();

        for (int i = 0;i < vos.size();i++){
            courseVO vo = vos.get(i);

            JSONObject obj = new JSONObject();
            obj.put("id",vo.id);
            obj.put("name",vo.name);
            obj.put("price",vo.price);
            obj.put("memberNum",vo.memberNum);
            obj.put("leftMembers",vo.leftMembers);
            obj.put("learn_time",vo.learn_time);
            obj.put("orgName",vo.orgName);
            obj.put("start_time", DateHelper.getDate(vo.start_time));
            ret.add(obj);
        }
        return ret;
    }

    public static ModelMap courseDetailVOToModel(ModelMap model, courseDetailVO vo){

        model.addAttribute("id",vo.id);
        model.addAttribute("name",vo.name);
        model.addAttribute("price",vo.price);
        model.addAttribute("learn_time",vo.learn_time);
        model.addAttribute("orgName",vo.orgName);
        model.addAttribute("teacher",vo.teacher);
        model.addAttribute("description",vo.description);
        model.addAttribute("start_time", DateHelper.getDate(vo.start_time));
        model.addAttribute("state",vo.state);
        model.addAttribute("memberNum",vo.memberNum);
        model.addAttribute("leftMember",vo.leftMembers);

        return model;
    }

}
