package utility;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.javafx.jmx.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

}
