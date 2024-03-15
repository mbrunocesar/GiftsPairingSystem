package service.seasons;

import model.Gift;

import java.util.Arrays;
import java.util.List;

public class WinterSeasonService extends GeneralSeasonService {

    public List<Gift> mountBasket(Gift[] gifts) {
        List<Gift> perfectVariety = pairingService.matchByPerfectVariety(gifts);
        if (!perfectVariety.isEmpty()) {
            return perfectVariety;
        }

        List<Gift> perfectPairing = pairingService.matchByPerfectPairing(gifts);
        if (!perfectPairing.isEmpty()) {
            return perfectPairing;
        }

        // if nothing else, is a discount basket
        return Arrays.stream(gifts).toList();
    }
}
