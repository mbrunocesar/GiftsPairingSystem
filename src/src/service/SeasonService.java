package service;

import model.Gift;
import service.seasons.*;

import java.util.Arrays;
import java.util.List;

public class SeasonService {

    String season = "spring";
    GeneralSeasonService SpecificSeasonService;

    public SeasonService(String season) {
        this.season = season;

        if (season.equals("Spring")) {
            SpecificSeasonService = new SpringSeasonService();

        } else if (season.equals("Summer")) {
            SpecificSeasonService = new SummerSeasonService();

        } else if (season.equals("Autumn")) {
            SpecificSeasonService = new AutumnSeasonService();

        } else if (season.equals("Winter")) {
            SpecificSeasonService = new WinterSeasonService();
        }
    }

    public List<Gift> createBasket(Gift[] gifts) {
        return SpecificSeasonService.mountBasket(gifts);
    }

}
