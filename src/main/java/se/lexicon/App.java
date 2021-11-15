package se.lexicon;

import se.lexicon.io.IOManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{

    public static String NAMES_URL;
    public static String JAVA_LOGO;
    public static int CURRENT_ID;


    public static void main( String[] args )
    {
        try{
            readConfig();
            List<String> names = Arrays.asList(
                    "Erik Alfredsson", "Tono Granath", "Karmand Aziz",
                    "Basel Askar", "Haris", "Fabrice Badia", "Sneha", "Federico Sanders",
                    "Alaa Adeen", "Nicola Kitanovic", "Alexis Capot"
            );
            IOManager ioManager = new IOManager();
            File namesFile = new File(NAMES_URL);
            ioManager.readFunctional(NAMES_URL).forEach(System.out::println);
            storeConfig();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void readConfig() {
        Properties configProperties = new Properties();
        try {
            configProperties.load(Files.newBufferedReader(Paths.get("src/main/resources/config.properties")));
            NAMES_URL = configProperties.getProperty("namesLocation");
            JAVA_LOGO = configProperties.getProperty("javaLogo");
            CURRENT_ID = Integer.parseInt(
                    configProperties.getProperty("currentId")
            );


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void storeConfig(){
        Properties properties = new Properties();
        properties.put("namesLocation", NAMES_URL);
        properties.put("javaLogo", JAVA_LOGO);
        properties.put("currentId", String.valueOf(CURRENT_ID));
        try{
            Writer writer = new FileWriter("src/main/resources/config.properties");
            properties.store(writer, "");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
