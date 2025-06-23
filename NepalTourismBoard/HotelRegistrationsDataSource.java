import java.util.Arrays;
import java.util.List;

public class HotelRegistrationsDataSource extends TouristDataSource {

    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        try {
            if (sourceName.contains("Hotels") && Math.random() < 0.2) {
                throw new AuthenticationFailedException("Hotel API authentication failed! Did someone forget the password again?");
            }
            return Arrays.asList("Hotel: Yak & Yeti, Guest: Ram Thapa, NP", "Hotel: Annapurna, Guest: Alice Smith, AU");
        } catch (AuthenticationFailedException e) {
            throw new DataSourceAccessException("Failed to access hotel data", e);
        }
    }

    public static void main(String[] args) {
        HotelRegistrationsDataSource source = new HotelRegistrationsDataSource();
        try {
            List<String> data = source.fetchData();
            data.forEach(System.out::println);
        } catch (DataSourceAccessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}