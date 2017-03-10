package utility;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cdn on 17/3/10.
 */
public class DateHelper {

    public static String getDate(Date date){

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date);

        return s;
    }
}
