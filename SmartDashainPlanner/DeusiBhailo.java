import java.util.List;

public class DeusiBhailo extends FestivalActivity {
    List<String> plannedRoutes;
    int numberOfPerformers;

    public DeusiBhailo(double estimatedCost, List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", estimatedCost);
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (plannedRoutes == null || plannedRoutes.isEmpty()) {
            throw new NoRouteException("No routes planned for Deusi Bhailo! Are we just singing in the living room?");
        }
        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException("Need at least 3 performers for a proper Deusi Bhailo!");
        }
        System.out.println("Deusi Bhailo program with " + numberOfPerformers + " performers planned for " + plannedRoutes.size() + " routes!");
    }

    public static void main(String[] args) {
        try {
            DeusiBhailo good = new DeusiBhailo(25000, java.util.Arrays.asList("Lazimpat", "Thamel"), 5);
            good.planActivity();

            DeusiBhailo noRoutes = new DeusiBhailo(20000, java.util.Collections.emptyList(), 4);
            noRoutes.planActivity();

            DeusiBhailo notEnoughPerformers = new DeusiBhailo(20000, java.util.Arrays.asList("Putalisadak"), 2);
            notEnoughPerformers.planActivity();
        } catch (FestivalPlanningException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}