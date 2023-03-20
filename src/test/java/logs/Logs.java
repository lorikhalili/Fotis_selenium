package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logs {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logs.class.getName());
    public static void info(String message) {
        LOGGER.info(message);
    }
}
