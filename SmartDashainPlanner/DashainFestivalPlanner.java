import java.util.List;

public class DashainFestivalPlanner {
    public static void executeFestivalPlan(List<FestivalActivity> activities) {
        for (FestivalActivity activity : activities) {
            activity.displayOverview();
            try {
                activity.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Planning Warning (Guests): " + e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());
            } catch (NoRouteException e) {
                System.out.println("Planning Warning (Routes): " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            } finally {
                System.out.println("Activity planning attempt for " + activity.activityName + " completed.");
            }
        }
    }

    public static void main(String[] args) {
        List<FestivalActivity> activities = List.of(
            new TikaCeremony(30000, 10, "Aama"),
            new TikaCeremony(60000, 10, "Baje"),
            new TikaCeremony(25000, 2, "Buwa"),
            new DeusiBhailo(25000, java.util.Arrays.asList("Thamel", "Dillibazar"), 5),
            new DeusiBhailo(25000, java.util.Collections.emptyList(), 5),
            new DeusiBhailo(25000, java.util.Arrays.asList("Maitidevi"), 2)
        );

        executeFestivalPlan(activities);
    }
}