package service;

import model.Gift;
import service.seasons.*;

import java.util.List;

public class SeasonService {

    SeasonsEnum season = SeasonsEnum.SPRING;
    GeneralSeasonService SpecificSeasonService;

    public SeasonService(SeasonsEnum season) {
        this.season = season;

        if (season == SeasonsEnum.SPRING) {
            SpecificSeasonService = new SpringSeasonService();

        } else if (season == SeasonsEnum.SUMMER) {
            SpecificSeasonService = new SummerSeasonService();

        } else if (season == SeasonsEnum.AUTUMN) {
            SpecificSeasonService = new AutumnSeasonService();

        } else if (season == SeasonsEnum.WINTER) {
            SpecificSeasonService = new WinterSeasonService();
        }
    }

    public List<Gift> createBasket(Gift[] gifts) {
        return SpecificSeasonService.mountBasket(gifts);
    }

}
