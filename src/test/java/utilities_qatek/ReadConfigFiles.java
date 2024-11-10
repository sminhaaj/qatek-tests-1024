package utilities_qatek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import playground.TestNgMavenExampleTest;

import java.util.Properties;

public class ReadConfigFiles {

    private static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);

    public static String getPropertyValues(String propName){

        Properties prop;
        String propValue = null;
        try{
            prop = new LoadConfigFiles().readPropertyValues();
            propValue = prop.getProperty(propName);
            if(prop.getProperty(propName)==null){
                LOGGER.error("The property name " + propName + " is invalid");
            }
        } catch(Exception e){
            LOGGER.error("The config file exception is: " + e.getMessage());
        }

        return propValue;

    }
}
