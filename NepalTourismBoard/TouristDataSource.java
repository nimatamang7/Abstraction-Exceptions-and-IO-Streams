import java.util.List;

public abstract class TouristDataSource {
    protected String sourceName;

    public TouristDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    public abstract List<String> fetchData() throws DataSourceAccessException;
}