package promotion.engine;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import promotion.engine.utility.InitializePromotoinsType;
import promotion.engine.utility.InitializeUnits;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	@BeforeClass
	public static void initalizeSystemDetail() {
		InitializeUnits.addSKUPriceDetail();
		InitializePromotoinsType.addPromotionTypeDetails();
	}
	/**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
