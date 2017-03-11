package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by cdn on 17/3/11.
 */
public class IdHelper {

    private IdHelper(){}

    private static String filePath = "/Users/user/Documents/un/s6/j2ee/homework/J2EE_FINAL/src/main/java/utility/idHelper.txt";

    private static int[] readFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int id = Integer.parseInt(reader.readLine());
            int orgId = Integer.parseInt(reader.readLine());
            reader.close();

            int[] ret = {id,orgId};
            return ret;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean writeFile(int[] ids){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Integer.toString(ids[0]));
            writer.newLine();
            writer.write(Integer.toString(ids[1]));
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static int getId(int index){
        int[] ids = readFile();

        if (ids != null){
            int id = ids[0] + 1;
            ids[0] = id;
            boolean save = writeFile(ids);
            if (save){
                return id;
            }
        }

        return -1;
    }

    public static int getCardId(){
        return getId(0);
    }

    public static int getOrgId(){
        return getId(1);
    }

}
