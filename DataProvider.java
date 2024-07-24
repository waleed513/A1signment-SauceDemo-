import com.google.gson.Gson;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataProvider {
    private static final String DATA_FILE = "src/test/data.json";
    private static User result;
    public static User getCredentials() throws IOException {
        Gson gson = new Gson();
        File file = new File(".");
        for(String fileNames : file.list()) System.out.println(fileNames);

        // Read JSON from a file
        try (Reader reader = new FileReader("src/data.json")) {

            // convert the JSON data to a Java object
            result = gson.fromJson(reader, User.class);
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
class User{
    public String username;
    public String password;
}