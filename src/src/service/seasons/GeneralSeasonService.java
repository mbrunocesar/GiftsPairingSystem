package service.seasons;

import model.Gift;
import service.PairingService;

import java.util.Arrays;
import java.util.List;

public abstract class GeneralSeasonService {

    PairingService pairingService;

    public GeneralSeasonService() {
        pairingService = new PairingService();
    }

    public List<Gift> mountBasket(Gift[] gifts) {
        // if nothing else, is a discount basket
        return Arrays.stream(gifts).toList();
    }

    public List<Gift> mountVarietyBased(Gift[] gifts) {
        List<Gift> perfectVariety = pairingService.matchByPerfectVariety(gifts);
        if (!perfectVariety.isEmpty()) {
            return perfectVariety;
        }

        List<Gift> weightVariety = pairingService.matchByWeightVariety(gifts);
        if (!weightVariety.isEmpty()) {
            return weightVariety;
        }

        List<Gift> shapeVariety = pairingService.matchByShapeVariety(gifts);
        if (!shapeVariety.isEmpty()) {
            return shapeVariety;
        }

        return null;
    }

    public List<Gift> mountPairingBased(Gift[] gifts) {
        List<Gift> perfectPairing = pairingService.matchByPerfectPairing(gifts);
        if (!perfectPairing.isEmpty()) {
            return perfectPairing;
        }

        List<Gift> shapePairing = pairingService.matchByShapePairing(gifts);
        if (!shapePairing.isEmpty()) {
            return shapePairing;
        }

        return null;
    }

}
