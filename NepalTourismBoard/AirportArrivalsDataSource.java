import java.util.Arrays;
import java.util.List;

public class AirportArrivalsDataSource extends TouristDataSource {

    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        try {
            if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
                throw new ConnectionLostException("Airport data connection lost! Maybe a pigeon sat on the antenna?");
            }
            return Arrays.asList("Visitor: John Doe, USA", "Visitor: Emily White, UK");
        } catch (ConnectionLostException e) {
            throw new DataSourceAccessException("Failed to access airport data", e);
        }
    }

    public static void main(String[] args) {
        AirportArrivalsDataSource source = new AirportArrivalsDataSource();
        try {
            List<String> data = source.fetchData();
            data.forEach(System.out::println);
        } catch (DataSourceAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}