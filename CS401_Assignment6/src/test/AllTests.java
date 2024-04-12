package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ DVDCollectionTest.class, DVDTest.class, DVDConsoleUITest.class})
public class AllTests {

}
