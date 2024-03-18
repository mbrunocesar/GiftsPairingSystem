import model.Gift;

import org.junit.Test;
import service.SeasonService;
import service.seasons.SeasonsEnum;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PairingTests {

    final String[] perfectVariety = {
            "50", "Square",
            "100", "Circle",
            "150", "Rectangle",
            "200", "Triangle",
            "250", "Oval",
            "200", "Rectangle"
    };
    final String[] weightVariety = {
            "200", "Oval",
            "50", "Square",
            "100", "Square",
            "150", "Square",
            "200", "Square",
            "250", "Square",
            "200", "Rectangle"
    };
    final String[] shapeVariety = {
            "200", "Oval",
            "150", "Square",
            "150", "Circle",
            "150", "Rectangle",
            "150", "Triangle",
            "150", "Oval",
            "200", "Rectangle"
    };
    final String[] perfectPairing = {
            "200", "Oval",
            "150", "Square",
            "50", "Square",
            "50", "Circle",
            "200", "Circle",
            "200", "Circle",
            "200", "Rectangle"
    };
    final String[] shapePairing = {
            "200", "Oval",
            "50", "Square",
            "50", "Square",
            "200", "Circle",
            "200", "Circle",
            "200", "Circle",
            "200", "Rectangle"
    };

    @Test
    public void TestInformedInputs() {
        String season = "SUMMER";
        SeasonService summerService = new SeasonService(SeasonsEnum.valueOf(season));

        testPerfectVariety(summerService);
        testWeightVariety(summerService);
        testShapeVariety(summerService);
        testSPerfectPairing(summerService);
        testShapePairing(summerService);

        assureMismatchPerfectVariety(summerService, weightVariety);
        assureMismatchWeightVariety(summerService, weightVariety);
        assureMismatchShapeVariety(summerService, weightVariety);
        assureMismatchSPerfectPairing(summerService, weightVariety);
        assureMismatchShapePairing(summerService, weightVariety);

        assert(true);
    }

    private void testPerfectVariety(SeasonService service) {
        List<Gift> result = service.createBasket(Helper.formatIntoGiftArray(perfectVariety));
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

    private void testWeightVariety(SeasonService service) {
        List<Gift> result = service.createBasket(Helper.formatIntoGiftArray(weightVariety));
        assertEquals(result.get(0).size, 50);
        assertEquals(result.get(1).size, 100);
        assertEquals(result.get(2).size, 150);
        assertEquals(result.get(3).size, 200);
        assertEquals(result.get(4).size, 250);

        for (int i = 0; i < 5; i++) {
            assertEquals(result.get(i).shape, ("Square"));
        }
    }

    private void testShapeVariety(SeasonService service) {
        List<Gift> result = service.createBasket(Helper.formatIntoGiftArray(shapeVariety));
        for (int i = 0; i < 5; i++) {
            assertEquals(result.get(i).size, 150);
        }

        assertEquals(result.get(0).shape, "Square");
        assertEquals(result.get(1).shape, "Circle");
        assertEquals(result.get(2).shape, "Rectangle");
        assertEquals(result.get(3).shape, "Triangle");
        assertEquals(result.get(4).shape, "Oval");
    }

    private void testShapePairing(SeasonService service) {
        List<Gift> result = service.createBasket(Helper.formatIntoGiftArray(perfectPairing));
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

    private void testSPerfectPairing(SeasonService service) {
        List<Gift> result = service.createBasket(Helper.formatIntoGiftArray(shapePairing));
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

    private void assureMismatchPerfectVariety(SeasonService service, String[] params) {
        List<Gift> result = service.createBasket(Helper.formatIntoGiftArray(perfectVariety));
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

    private void assureMismatchWeightVariety(SeasonService service, String[] params) {

    }

    private void assureMismatchShapeVariety(SeasonService service, String[] params) {

    }

    private void assureMismatchSPerfectPairing(SeasonService service, String[] params) {

    }

    private void assureMismatchShapePairing(SeasonService service, String[] params) {

    }
}