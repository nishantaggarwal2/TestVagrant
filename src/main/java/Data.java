import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Data {

    static RCBData getData()  {
        Gson gson= new Gson();
        JsonReader jsonReader;
        try {
        File f= new File("src/main/resources/rcb.json");
        jsonReader = new JsonReader(new FileReader(f));
        RCBData rcbJson=gson.fromJson(jsonReader,RCBData.class);
       return  rcbJson;
        } catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }
}
