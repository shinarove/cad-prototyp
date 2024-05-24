package ch.zhaw.it.cadprototyp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomConfig {

    private static final Logger logger = Logger.getLogger(CustomConfig.class.getCanonicalName());

    private static final String CONFIG_FILE = "config.properties";

    private MeasurementUnit usedMeasurementUnit;

    /**
     * Reads the config properties file.
     * If the config could not be read, uses the standard system config.
     */
    public CustomConfig(){
        System.out.println(CustomConfig.class.getResource(CONFIG_FILE));

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(String.valueOf(CustomConfig.class.getResource(CONFIG_FILE))));
            String unit = properties.getProperty("MEASUREMENT_UNIT");
            Optional<MeasurementUnit> unitOptional = MeasurementUnit.parseUnit(unit);
            if (unitOptional.isPresent()) {
                logger.log(Level.INFO, "Using measurement unit: {0}", unitOptional.get());
                this.usedMeasurementUnit = unitOptional.get();
            } else {
                logger.log(Level.WARNING, "Invalid measurement unit in config file. Using standard unit.");
                this.usedMeasurementUnit = SystemConfiguration.DEFAULT_MEASUREMENT_UNIT;
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error reading config file. Using standard unit.", e);
            this.usedMeasurementUnit = SystemConfiguration.DEFAULT_MEASUREMENT_UNIT;
        }
    }

    public MeasurementUnit getUsedMeasurementUnit() {
        return usedMeasurementUnit;
    }
}
