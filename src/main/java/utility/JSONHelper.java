package utility;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.javafx.jmx.json.JSONException;

import java.io.IOException;

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

}
