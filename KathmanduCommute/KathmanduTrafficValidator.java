public class KathmanduTrafficValidator implements RouteValidator {

    @Override
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm) throws InvalidRouteException {
        if (origin.equalsIgnoreCase(destination)) {
            throw new SameLocationException("Origin and destination cannot be the same! Are you just spinning in circles, Damodar?");
        }
        if (distanceKm < 0.1 || distanceKm > 30.0) {
            throw new InvalidRouteException("Distance " + distanceKm + "km is unrealistic for Kathmandu commute!");
        }
        return true;
    }

    public static void main(String[] args) {
        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();
        try {
            System.out.println(validator.isValidCommuteRoute("Baneshwor", "Patan", 5.0)); // true
            System.out.println(validator.isValidCommuteRoute("Kalanki", "Kalanki", 2.0)); // same location
        } catch (SameLocationException e) {
            System.out.println("SameLocationException: " + e.getMessage());
        } catch (InvalidRouteException e) {
            System.out.println("InvalidRouteException: " + e.getMessage());
        }
    }
}