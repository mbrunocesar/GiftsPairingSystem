package service;

import model.Gift;
import service.seasons.*;

import java.util.Arrays;
import java.util.List;

public class SeasonService {

    Season season = Season.SPRING;
    GeneralSeasonService SpecificSeasonService;

    public SeasonService(Season season) {
        this.season = season;

        if (season == Season.SPRING) {
            SpecificSeasonService = new SpringSeasonService();

        } else if (season == Season.SUMMER) {
            SpecificSeasonService = new SummerSeasonService();

        } else if (season == Season.AUTUMN) {
            SpecificSeasonService = new AutumnSeasonService();

        } else if (season == Season.WINTER) {
            SpecificSeasonService = new WinterSeasonService();
        }
    }

    public List<Gift> createBasket(Gift[] gifts) {
        return SpecificSeasonService.mountBasket(gifts);
    }

}
