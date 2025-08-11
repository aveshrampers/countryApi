// src/test/java/base/BaseTest.java
package base;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.filter.log.LogDetail;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected ByteArrayOutputStream requestLog;
    protected ByteArrayOutputStream responseLog;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://restcountries.com/v3.1";
        requestLog = new ByteArrayOutputStream();
        responseLog = new ByteArrayOutputStream();
        RestAssured.filters(
                new RequestLoggingFilter(LogDetail.ALL, new PrintStream(requestLog)),
                new ResponseLoggingFilter(LogDetail.ALL, new PrintStream(responseLog))
        );
    }

    @AfterMethod
    public void logOnFailure(ITestResult result) {
        if (!result.isSuccess()) {
            logger.error("Request log:\n{}", requestLog.toString());
            logger.error("Response log:\n{}", responseLog.toString());
        }
        requestLog.reset();
        responseLog.reset();
    }
}