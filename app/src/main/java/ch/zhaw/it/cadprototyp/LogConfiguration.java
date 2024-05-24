package ch.zhaw.it.cadprototyp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogConfiguration {

    private static final Logger logger = Logger.getLogger(LogConfiguration.class.getCanonicalName());

    private static final String DEFAULT_LOG_CONFIG_FILE = "log.properties";

    static {
        Locale.setDefault(Locale.ROOT);  // show log messages in English

        String logConfigFile = System.getProperty("java.util.logging.config.file", DEFAULT_LOG_CONFIG_FILE);
        Path logConfigPath = Path.of(logConfigFile);

        try {
            InputStream configFileStream;
            if (Files.isReadable(logConfigPath)) {
                configFileStream = Files.newInputStream(logConfigPath);
            } else {
                logConfigFile = "resources:/" + DEFAULT_LOG_CONFIG_FILE;
                configFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream(DEFAULT_LOG_CONFIG_FILE);
            }
            if (configFileStream != null) {
                LogManager.getLogManager().readConfiguration(configFileStream);
                logger.log(Level.FINE, "Log configuration read from {0}", logConfigFile);
            } else {
                logger.warning("No log configuration found. Using system default settings.");
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error loading log configuration", e);
        }
    }

    /**
     * Helper method to get a property from the LogManager.
     * @param name of the property
     * @return value of the property or null if not found
     */
    public static String getProperty(String name) {
        return LogManager.getLogManager().getProperty(name);
    }

    /**
     * Helper method to set the log level for a specific class.
     * @param clazz class to set the log level for
     * @param level log level to set
     */
    public static void setLogLevel(Class<?> clazz, Level level) {
        Logger.getLogger(clazz.getCanonicalName()).setLevel(level);
    }

    /**
     * Helper method to get the log level for a specific class.
     * @param clazz class to get the log level for
     * @return log level of the class
     */
    public static Level getLogLevel(Class<?> clazz) {
        return Logger.getLogger(clazz.getCanonicalName()).getLevel();
    }
}
