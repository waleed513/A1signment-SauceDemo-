import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataProvider {
    private static final String DATA_FILE = "data.json";
    public static Map<String, String> getCredentials() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(DATA_FILE), new TypeReference<Map<String, String>>() {});
    }
}