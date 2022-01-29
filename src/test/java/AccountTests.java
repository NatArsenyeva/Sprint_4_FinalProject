import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTests {

    private final String name;
    private final boolean expected;

    public AccountTests(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                { "N M", true},
                { "NA M", true},
                { "NAMENAMENAME NAMEN", true},
                { "NAMENAMENAME NAMENA", true},
                { "NAMENAMENAME NAMENAM", false},
                { "NA", false},
                { "NAMENAMENAME", false},
                { " NAMENAMENAME", false},
                { "NAMENAMENAME ", false},
                { " NAMENAMENAME ", false},
                { "NAMENA  MENAME", false},
                { "NAMENA MEN AME", false},
                { "NAME 123", false},
                { "NAME .,`", false},
                { "ИМЯ ИМЯ", false},
                { "n m", false},
                { "", false}
        };
    }

    @Test
    public void checkNameToEmbossReturnExpectedBooleanValue(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Value \"" +name+ "\" is not valid.", expected,actual);
    }

}