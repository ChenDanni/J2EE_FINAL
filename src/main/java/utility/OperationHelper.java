package utility;

/**
 * Created by cdn on 17/3/10.
 */
public class OperationHelper {

    public static String getOperationName(int opType, String className) {
        switch (opType){
            case 0:
                return "充值";
            case 1:
                return "预定 " + className;
            case 2:
                return "退订 " + className;
            case 3:
                return "退课 " + className;
            case 4:
                return "积分兑换";
            default:
                System.err.println("WRONG OPTYPE");
                return "";
        }

    }
}
