public class CommutePlanner {

    public static void planMyCommute(String origin, String destination, RouteValidator validator, NavigationService navigator) {
        System.out.println("Planning your commute from " + origin + " to " + destination + "...");

        try {
            navigator.navigate(origin, destination, validator);
        } catch (NavigationFailedException e) {
            Throwable cause = e.getCause();
            if (cause instanceof SameLocationException) {
                System.out.println("Cannot plan: Invalid route details - " + cause.getMessage());
            } else if (cause instanceof InvalidRouteException) {
                System.out.println("Cannot plan: Invalid route details - " + cause.getMessage());
            } else {
                System.out.println("Cannot plan: GPS issue - " + e.getMessage());
            }
        } finally {
            System.out.println("Commute planning for " + origin + " to " + destination + " completed.");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService navigator = new GPSNavigationModule();

        // Valid commute
        planMyCommute("Baneshwor", "Patan", validator, navigator);

        // Same location error
        planMyCommute("Thamel", "Thamel", validator, navigator);

        // GPS error
        planMyCommute("Kalanki", "Balaju", validator, navigator);
    }
}