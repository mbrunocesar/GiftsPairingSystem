package service.seasons;

import model.Gift;

import java.util.Arrays;
import java.util.List;

public class AutumnSeasonService extends GeneralSeasonService {

    public List<Gift> mountBasket(Gift[] gifts) {
        List<Gift> varietyBased = mountVarietyBased(gifts);
        if (varietyBased != null) {
            return varietyBased;
        }

        // if nothing else, is a discount basket
        return Arrays.stream(gifts).toList();
    }
}
