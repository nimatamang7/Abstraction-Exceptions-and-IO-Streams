public interface NavigationService {
    void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException;
}