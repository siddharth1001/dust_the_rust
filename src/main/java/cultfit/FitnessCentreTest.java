package cultfit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FitnessCentreTest {

    FitnessCentre centre;

    @BeforeClass
    public void setUp() {
        centre = new FitnessCentre();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("done");
    }

    @Test
    public void testBookClass() {
        String str = centre.bookClass(FitnessProgramType.BOXING, 1);
        Assert.assertNotNull(str);
        Assert.assertEquals(str, "Successfully booked BOXING class for user id=1");
    }

    @Test
    public void testCancelClass() {
    }
}