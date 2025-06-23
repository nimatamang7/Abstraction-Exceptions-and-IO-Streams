import java.util.List;
import java.util.ArrayList;

public class TourismReportGenerator {

    public static void generateOverallReport(List<TouristDataSource> dataSources, DataProcessor processor) {
        System.out.println("Generating overall tourism report...");
        for (TouristDataSource source : dataSources) {
            List<String> data = null;
            try {
                data = source.fetchData();
            } catch (DataSourceAccessException e) {
                System.out.println("Could not fetch data from " + source.sourceName + ": " + e.getMessage() + ". Skipping this source.");
                if (e.getCause() != null) {
                    System.out.println("Reason: " + e.getCause().getMessage());
                }
                continue;
            }

            try {
                List<String> result = processor.process(data);
                result.forEach(System.out::println);
            } catch (DataProcessingException e) {
                System.out.println("Error processing data from " + source.sourceName + ": " + e.getMessage() + ". Skipping this data.");
            } finally {
                System.out.println("Data handling from " + source.sourceName + " completed.");
            }
        }
    }

    public static void main(String[] args) {
        List<TouristDataSource> sources = new ArrayList<>();
        sources.add(new AirportArrivalsDataSource());
        sources.add(new HotelRegistrationsDataSource());

        DataProcessor processor = new UniqueVisitorCounter();
        generateOverallReport(sources, processor);
    }
}