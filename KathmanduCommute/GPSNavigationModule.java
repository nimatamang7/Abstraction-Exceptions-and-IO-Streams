public class GPSNavigationModule implements NavigationService {

    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException {
        System.out.println("Attempting to navigate from " + startPoint + " to " + endPoint + "...");

        if (startPoint.equalsIgnoreCase("Kalanki")) {
            throw new NavigationFailedException("GPS signal lost near Kalanki! Welcome to Kathmandu traffic!");
        }

        try {
            double distance = simulatedDistance(startPoint, endPoint);
            if (validator.isValidCommuteRoute(startPoint, endPoint, distance)) {
                System.out.println("Navigation successful! Estimated time: 20 minutes (or 2 hours depending on traffic).");
            }
        } catch (InvalidRouteException e) {
            throw new NavigationFailedException("Route validation failed!", e);
        }
    }

    private double simulatedDistance(String start, String end) {
        return 5.0; // fixed distance for simulation
    }

    public static void main(String[] args) {
        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService gps = new GPSNavigationModule();

        try {
            gps.navigate("Baneshwor", "Patan", validator); // should pass
            gps.navigate("Kalanki", "Balaju", validator);  // GPS error
        } catch (NavigationFailedException e) {
            System.out.println("NavigationFailedException: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Caused by: " + e.getCause().getMessage());
            }
        }
    }
}