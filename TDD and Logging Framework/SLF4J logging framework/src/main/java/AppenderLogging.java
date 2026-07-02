import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLogging.class);

    public static void main(String[] args) {
        logger.debug("This Is A Debug Message");
        logger.info("This Is An Info Message");
        logger.warn("This Is A Warning Message");
        logger.error("This Is An Error Message");
    }
}