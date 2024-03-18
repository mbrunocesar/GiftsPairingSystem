import model.Gift;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PairingTests {

    /*
    50g Square, 100g Circle, 150g Rectangle, 200g Triangle, 250g Oval

    50g Square, 100g Square, 150g Square, 200g Square, 250g Square

    150g Square, 150g Circle, 150g Rectangle, 150g Triangle, 150g Oval

    50g Square, 50g Square, 200g Circle, 200g Circle, 200g Circle

    150g Square, 50g Square, 50g Circle, 200g Circle, 200g Circle

    150g Square, 50g Triangle, 50g Rectangle, 200g Circle, 200g Circle
    */
    @Test
    public void TestInformedInputs() {
        String season = "SUMMER";


        Main summerMain = new Main();
        summerMain.setSeason(season);
        testPerfectVariety(summerMain);
        testWeightVariety(summerMain);
        testShapeVariety(summerMain);
        testSPerfectPairing(summerMain);
        testShapePairing(summerMain);

        assert(true);
    }

    private void testPerfectVariety(Main main) {
        String[] args = "50g Square, 100g Circle, 150g Rectangle, 200g Triangle, 250g Oval".split(" ");
        List<Gift> result = main.createBasket(args);
        assertEquals(result.get(0).size, 50);
        assertEquals(result.get(1).size, 100);
        assertEquals(result.get(2).size, 150);
        assertEquals(result.get(3).size, 200);
        assertEquals(result.get(4).size, 250);

        assertEquals(result.get(0).shape, "Square");
        assertEquals(result.get(1).shape, "Circle");
        assertEquals(result.get(2).shape, "Rectangle");
        assertEquals(result.get(3).shape, "Triangle");
        assertEquals(result.get(4).shape, "Oval");
    }

    private void testWeightVariety(Main main) {
        String[] args = "50g Square, 100g Square, 150g Square, 200g Square, 250g Square".split(" ");
        List<Gift> result = main.createBasket(args);
        assertEquals(result.get(0).size, 50);
        assertEquals(result.get(1).size, 100);
        assertEquals(result.get(2).size, 150);
        assertEquals(result.get(3).size, 200);
        assertEquals(result.get(4).size, 250);

        for (int i = 0; i < 5; i++) {
            assertEquals(result.get(i).shape, ("Square"));
        }
    }

    private void testShapeVariety(Main main) {
        String[] args = "150g Square, 150g Circle, 150g Rectangle, 150g Triangle, 150g Oval".split(" ");
        List<Gift> result = main.createBasket(args);
        for (int i = 0; i < 5; i++) {
            assertEquals(result.get(i).size, 150);
        }

        assertEquals(result.get(0).shape, "Square");
        assertEquals(result.get(1).shape, "Circle");
        assertEquals(result.get(2).shape, "Rectangle");
        assertEquals(result.get(3).shape, "Triangle");
        assertEquals(result.get(4).shape, "Oval");
    }

    private void testSPerfectPairing(Main main) {
        String[] args = "50g Square, 50g Square, 200g Circle, 200g Circle, 200g Circle".split(" ");
        List<Gift> result = main.createBasket(args);
        assertEquals(result.get(0).size, 50);
        assertEquals(result.get(1).size, 50);
        assertEquals(result.get(2).size, 200);
        assertEquals(result.get(3).size, 200);
        assertEquals(result.get(4).size, 200);

        assertEquals(result.get(0).shape, "Square");
        assertEquals(result.get(1).shape, "Square");
        assertEquals(result.get(2).shape, "Circle");
        assertEquals(result.get(3).shape, "Circle");
        assertEquals(result.get(4).shape, "Circle");
    }

    private void testShapePairing(Main main) {
        String[] args = "150g Square, 50g Square, 50g Circle, 200g Circle, 200g Circle".split(" ");
        List<Gift> result = main.createBasket(args);
        assertEquals(result.get(0).size, 150);
        assertEquals(result.get(1).size, 50);
        assertEquals(result.get(2).size, 50);
        assertEquals(result.get(3).size, 200);
        assertEquals(result.get(4).size, 200);

        assertEquals(result.get(0).shape, "Square");
        assertEquals(result.get(1).shape, "Square");
        assertEquals(result.get(2).shape, "Circle");
        assertEquals(result.get(3).shape, "Circle");
        assertEquals(result.get(4).shape, "Circle");
    }

}