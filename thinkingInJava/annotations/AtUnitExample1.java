package thinkingInJava.annotations;

import org.junit.Assert;
import org.junit.Test;

public class AtUnitExample1 {
    @Test
    public void methodOne() {
        String s = "This is methodOne";
        Assert.assertEquals(s, "This is methodOne");
    }
}
