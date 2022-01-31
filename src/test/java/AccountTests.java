import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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
                { "Т Ш", true},
                { "Ти Ш", true},
                { "ТимотиТимоти Шалам", true},
                { "ТимотиТимоти Шаламе", true},
                { "Тим ЁёЕе", true},
                { "Timothee Chalamet", true},
                { "ТимотиТимоти ШаламеШ", false},
                { "Ти", false},
                { "ТимотиШаламе", false},
                { " ТимотиШаламе", false},
                { "ТимотиШаламе ", false},
                { " ТимотиШаламе ", false},
                { "Тимоти  Шаламе", false},
                { "Тимоти Шаламе Шалам", false},
                { "Тимоти .,`", false},
                { "Тимоти 1", false},
                { "", false}
        };
    }


    @Test
    @DisplayName("Check name to emboss")
    public void checkNameToEmbossReturnExpectedBooleanValueTest(){
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Value \"" +name+ "\" is not valid.", expected,actual);
    }

}