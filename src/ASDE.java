
public class ASDE {

    public static String getLevel(int level) {

        switch(level) {

            case 1:
                return "LOW";

            case 2:
                return "MEDIUM";

            case 3:
                return "HIGH";

            default:
                return "LOW";
        }

    }

}