package sample;
import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.runner.JUnitPlatform;
@RunWith(JUnitPlatform.class)
@SelectClasses( {VectorsJUnit5Test.class, UtilsJUnit5Test.class} )
public class JUnit5TestSuite {
}