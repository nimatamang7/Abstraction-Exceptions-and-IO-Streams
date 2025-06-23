import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData) throws DataProcessingException {
        if (rawData.isEmpty()) {
            throw new EmptyDataException("No raw data to process! Did all tourists go missing?");
        }

        Set<String> uniqueNames = new HashSet<>();
        for (String entry : rawData) {
            String[] parts = entry.split(":");
            if (parts.length > 1) {
                String[] details = parts[1].split(",");
                if (details.length > 0) {
                    uniqueNames.add(details[0].trim());
                }
            }
        }

        List<String> result = new ArrayList<>();
        result.add("Unique Visitors: " + uniqueNames.size());
        return result;
    }

    public static void main(String[] args) {
        UniqueVisitorCounter counter = new UniqueVisitorCounter();
        try {
            counter.process(new ArrayList<>()); // empty list test
        } catch (DataProcessingException e) {
            System.out.println("Processing Error: " + e.getMessage());
        }
    }
}