import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import utils.ConverterTest;
import utils.ValidatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, ConverterTest.class, ValidatorTest.class})
class AllTests {}
