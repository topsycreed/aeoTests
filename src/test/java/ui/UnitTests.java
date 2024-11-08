package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {
    @Test
    void firstUnitTest() {
        int a = 1;
        int b = 2;

        int sum = a + b;
        Assert.assertEquals(sum, 3);
    }
}
