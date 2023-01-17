package tests.log4Jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_LogsTests {

    private static Logger logger= LogManager.getLogger(Day15_LogsTests.class.getName());

    @Test
    public void test1(){

        logger.fatal("Fatal");
        logger.error("Error");
        logger.warn("Warnin");
        logger.debug("Debug");
        logger.info("Info");



    }
}
