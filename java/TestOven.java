import static org.junit.jupiter.api.Test;

public class TestOven {
    //Input: Bottom of range(251), output: same
    @Test
    public void testPreheatToBottomRangeInputSame251_251() {
        // setup: make an oven, and check that its temp is not 251
        Oven oven = new Oven();
        assertFalse(oven.getTemp() == 251);

        // call: oven.preheatTo(251)
        oven.preheatTo(251);
        
        // check: assert that the oven temp is now 251
        //        oven.getTemp()
        assertTrue(oven.getTemp() == 251);

    }

    // Input: Top of range (499), output: same
    // Input: Middle of range (375), output: same

}