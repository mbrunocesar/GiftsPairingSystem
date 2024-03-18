package service;

import model.Gift;
import service.pairings.PairingMatcher;
import service.pairings.PerfectVariety;
import service.pairings.ShapeVariety;
import service.pairings.WeightVariety;

import java.util.List;

public class PairingService {

    PerfectVariety perfectVariety;
    ShapeVariety shapeVariety;
    WeightVariety weightVariety;
    PairingMatcher pairer;

    public PairingService() {
        perfectVariety = new PerfectVariety();
        shapeVariety = new ShapeVariety();
        weightVariety = new WeightVariety();
        pairer = new PairingMatcher();
    }

    public List<Gift> matchByPerfectVariety(Gift[] gifts) {
        return perfectVariety.match(gifts);
    }

    public List<Gift> matchByWeightVariety(Gift[] gifts) {
        return weightVariety.match(gifts);
    }

    public List<Gift> matchByShapeVariety(Gift[] gifts) {
        return shapeVariety.match(gifts);
    }

    public List<Gift> matchByPerfectPairing(Gift[] gifts) {
        return pairer.match(gifts, "PerfectPairing");
    }

    public List<Gift> matchByShapePairing(Gift[] gifts) {
        return pairer.match(gifts, "ShapePairing");
    }

}
