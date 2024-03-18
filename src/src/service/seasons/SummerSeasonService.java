package service.seasons;

import model.Gift;

import java.util.Arrays;
import java.util.List;

public class SummerSeasonService extends GeneralSeasonService {

    public List<Gift> mountBasket(Gift[] gifts) {
        List<Gift> varietyBased = mountVarietyBased(gifts);
        if (varietyBased != null) {
            return varietyBased;
        }

        List<Gift> pairingBased = mountPairingBased(gifts);
        if (pairingBased != null) {
            return pairingBased;
        }

        // if nothing else, is a discount basket
        return returnDiscountBasket(gifts);
    }
}
