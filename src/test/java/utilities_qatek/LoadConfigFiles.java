package utilities_qatek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import playground.TestNgMavenExampleTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigFiles {

    public Properties readPropertyValues() throws IOException {

        final Logger LOGGER = LogManager.getLogger(LoadConfigFiles.class);

        Properties prop = new Properties();
        InputStream inputStream = null;

        try{
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if(inputStream!=null){
                prop.load(inputStream);
            } else{
                throw new FileNotFoundException("Property File " + propFileName + " not found in the path");
            }
        }  catch(Exception e){
            LOGGER.error("Exception: " + e.getMessage());
        } finally{
            inputStream.close();
        }

        return prop;

    }
}
