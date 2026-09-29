public class SecurityDecision {

    public static int getSecurityLevel(
            String priority
    ) {

        if(priority.equalsIgnoreCase("HIGH")) {

            return 3;

        }

        if(priority.equalsIgnoreCase("MEDIUM")) {

            return 2;

        }

        return 1;

    }

}