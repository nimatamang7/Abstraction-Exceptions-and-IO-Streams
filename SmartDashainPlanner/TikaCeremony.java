public class TikaCeremony extends FestivalActivity {
    int expectedGuests;
    String mainFamilyElder;

    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (expectedGuests < 5) {
            throw new InvalidGuestCountException("Not enough guests for a lively Tika! Is everyone on vacation?");
        }
        if (estimatedCost > 50000) {
            throw new BudgetExceededException("Tika budget too high! Is this for the whole village?");
        }
        System.out.println("Tika ceremony with " + mainFamilyElder + " planned successfully for " + expectedGuests + " guests!");
    }

    public static void main(String[] args) {
        try {
            TikaCeremony good = new TikaCeremony(30000, 10, "Grandpa Ram");
            good.planActivity();

            TikaCeremony tooFewGuests = new TikaCeremony(30000, 2, "Grandpa Ram");
            tooFewGuests.planActivity();

            TikaCeremony tooCostly = new TikaCeremony(60000, 10, "Grandpa Ram");
            tooCostly.planActivity();
        } catch (FestivalPlanningException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}